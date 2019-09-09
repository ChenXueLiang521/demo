package com.tencentcloudapi.controller;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.IaiClient;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.iai.v20180301.models.Candidate;
import com.tencentcloudapi.iai.v20180301.models.FaceRect;
import com.tencentcloudapi.iai.v20180301.models.Result;
import com.tencentcloudapi.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auth chenxueliang
 * @Date 2019/7/12 14:22
 * @Dec TODO
 **/
@RestController
public class TencentFaceSearchController {
    @Autowired
    Environment env;
    /**
     * @Author chenxueliang
     * @Date 2019/7/12 10:06
     * @Desc 人脸搜索
     **/
    @PostMapping("/searchFaces")
    public Object searchFaces(String image, HttpServletResponse response){
        String picture = image.substring(image.indexOf(",")+1);
        String secretId = env.getProperty("secretId");
        String secretKey = env. getProperty("secretKey");
        SearchFacesRequest searchFacesRequest = new SearchFacesRequest();
        String[] strings = {"001"};
        searchFacesRequest.setGroupIds(strings);
        searchFacesRequest.setImage(picture);

        Credential credential = new Credential(secretId,secretKey);
        IaiClient iaiClient = new IaiClient(credential,"");
        try {
            SearchFacesResponse searchFacesResponse = iaiClient.SearchFaces(searchFacesRequest);
            Integer faceNum = searchFacesResponse.getFaceNum();
            System.out.println("faceNum: "+faceNum);
            Result[] results = searchFacesResponse.getResults();
            String personId = "";
            for (Result result : results) {
                Candidate[] candidates = result.getCandidates();
                for (Candidate candidate : candidates) {
                    String faceId = candidate.getFaceId();
                    System.out.println("faceId: "+faceId);
                    personId = candidate.getPersonId();
                    System.out.println("personId: "+personId);
                    Float score = candidate.getScore();
                    Float ss = 90f;
                    System.out.println("score: "+score);
                    if (score>ss){
                        //人脸验证
                        VerifyFaceRequest verifyFaceRequest = new VerifyFaceRequest();
                        verifyFaceRequest.setImage(picture);
                        verifyFaceRequest.setPersonId(personId);
                        VerifyFaceResponse verifyFaceResponse = iaiClient.VerifyFace(verifyFaceRequest);
                        Boolean isMatch = verifyFaceResponse.getIsMatch();
                        Float scores = verifyFaceResponse.getScore();
                        System.out.println("是否匹配： "+isMatch);
                        System.out.println("匹配分数： "+scores);
                        if(isMatch==true){
                            return "success";
                        }
                        return "fail";
                    }{
                        System.out.println("没有匹配的数据");
                        return "fail";
                    }

                }
                FaceRect faceRect = result.getFaceRect();
                System.out.println("faceRect："+faceRect);
            }

        } catch (TencentCloudSDKException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
