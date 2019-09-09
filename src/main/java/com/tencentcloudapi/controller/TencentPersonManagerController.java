package com.tencentcloudapi.controller;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.IaiClient;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.model.TenFacePerson;
import com.tencentcloudapi.models.*;
import com.tencentcloudapi.service.TenFacePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/face")
public class TencentPersonManagerController {

    @Autowired
    TenFacePersonService tenFacePersonService;

    @Autowired
    Environment env;
    /**
     * @Author chenxueliang
     * @Date 2019/7/12 10:06
     * @Desc 创建人人员库
     **/
    @RequestMapping("/createGroup")
    public Object CreateGroup(){
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
          CreateGroupRequest createGroupRequest = new CreateGroupRequest();
        createGroupRequest.setGroupName("cxlGroupOne");
        createGroupRequest.setGroupId("001");
        //createGroupRequest.setGroupExDescriptions();
        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            CreateGroupResponse createGroupResponse = iaiClient.CreateGroup(createGroupRequest);
            System.out.println(createGroupResponse);
            System.out.println();
        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * @Author chenxueliang
     * @Date 2019/7/12 10:06
     * @Desc 获取人员库列表
     **/
    @RequestMapping("/getGroupList")
    public Object getGroupList(){
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
        GetGroupListRequest getGroupListRequest = new GetGroupListRequest();
        getGroupListRequest.setLimit(10);
        getGroupListRequest.setOffset(0);
        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            GetGroupListResponse getGroupListResponse = iaiClient.GetGroupList(getGroupListRequest);

        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * @Author chenxueliang
     * @Date 2019/7/12 10:07
     * @Desc 创建人员
     **/
    @PostMapping("/createPerson")
    public Object createPerson(String personName,Integer gender,String image){
        String picture = image.substring(image.indexOf(",")+1);
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
        TenFacePerson tenFacePerson = new TenFacePerson();
        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setGroupId("001");
        tenFacePerson.setGroupId("001");
        tenFacePerson.setGroup_state(true);
        createPersonRequest.setPersonName(personName);
        String personId = String.valueOf(new Random().nextInt(899999) + 100000);
        createPersonRequest.setPersonId(personId);
        tenFacePerson.setPersonId(personId);
        tenFacePerson.setPerson_state(true);
        if (gender==null){//未填写
            createPersonRequest.setGender(0);
            tenFacePerson.setGender(0);
        }else{
            createPersonRequest.setGender(gender);
            tenFacePerson.setGender(gender);
        }
        createPersonRequest.setImage(picture);
        //tenFacePerson.setImage(picture);
        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            CreatePersonResponse createPersonResponse = iaiClient.CreatePerson(createPersonRequest);
            String faceId = createPersonResponse.getFaceId();
            tenFacePerson.setFaceId(faceId);
            tenFacePerson.setTimes(new Date());
            tenFacePersonService.insertPersonInfo(tenFacePerson);
            return "success";
        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
            return "fail";
        }
    }

    /**
     * @Author chenxueliang
     * @Date 2019/7/12 14:02
     * @Desc 删除人员
     **/
    @RequestMapping("/deletePerson")
    public Object deletePerson(){
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
        DeletePersonRequest deletePersonRequest = new DeletePersonRequest();
        deletePersonRequest.setPersonId("");
        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            DeletePersonResponse deletePersonResponse = iaiClient.DeletePerson(deletePersonRequest);

        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * @Author chenxueliang
     * @Date 2019/7/12 14:12
     * @Desc 获取人员列表
     **/
    @RequestMapping("/getPersonList")
    public Object getPersonList(){
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
        GetPersonListRequest getPersonListRequest = new GetPersonListRequest();
        getPersonListRequest.setGroupId("001");
        getPersonListRequest.setLimit(100);
        getPersonListRequest.setOffset(0);
        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            GetPersonListResponse getPersonListResponse = iaiClient.GetPersonList(getPersonListRequest);
            com.tencentcloudapi.iai.v20180301.models.PersonInfo[] personInfos = getPersonListResponse.getPersonInfos();
            for (com.tencentcloudapi.iai.v20180301.models.PersonInfo personInfo : personInfos) {

            }

            System.out.println(getPersonListResponse);
        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
        return null;
    }




    public static void main(String[] args) {


        GetGroupListRequest getGroupListRequest = new GetGroupListRequest();
        getGroupListRequest.setLimit(10);
        getGroupListRequest.setOffset(0);
        Credential credential = new Credential("AKID7zbXEilvwjGXZMjJ2SkmAIF2Ztyah4vc","g7JFxQecNyJzPZUBoETSCgvud6LtCF4r");
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            GetGroupListResponse getGroupListResponse = iaiClient.GetGroupList(getGroupListRequest);
            System.out.println(getGroupListResponse.getGroupInfos()+"----"+getGroupListResponse.getGroupNum()+"--"+getGroupListResponse.getRequestId());
        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
    }

}