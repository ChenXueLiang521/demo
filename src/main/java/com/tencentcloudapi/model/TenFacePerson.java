package com.tencentcloudapi.model;

import java.util.Date;
import java.io.Serializable;

/**
 * @Auth chenxueliang
 * @Date 2019/7/12 10:37
 * @Dec TODO
 **/
public class TenFacePerson implements Serializable{
    private int id ;
    private String groupId;
    private String personId;
    private int gender;
    private String image;
    private String url;
    private Boolean group_state;
    private Boolean person_state;
    private Date times;
    private String faceId;

    @Override
    public String toString() {
        return "TenFacePerson{" +
                "id=" + id +
                ", groupId='" + groupId + '\'' +
                ", personId='" + personId + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                ", group_state=" + group_state +
                ", person_state=" + person_state +
                ", times=" + times +
                ", faceId='" + faceId + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getGroup_state() {
        return group_state;
    }

    public void setGroup_state(Boolean group_state) {
        this.group_state = group_state;
    }

    public Boolean getPerson_state() {
        return person_state;
    }

    public void setPerson_state(Boolean person_state) {
        this.person_state = person_state;
    }

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }
}
