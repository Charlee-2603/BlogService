package com.hunter.blog.modules.user.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author ChenLiang
 * @version 1.0.0
 * @data: 2019/9/2 10:28
 */
@Component
public class UserDo implements Serializable {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户帐号
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户手机号
     */
    private String userTel;

    /**
     * 用户UUID
     */
    private String userUUID;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户真实名称
     */
    private String userActualName;

    /**
     * 用户行业
     */
    private String userIndustry;

    /**
     * 职位
     */
    private String userPosition;

    /**
     * 用户所在城市
     */
    private String userCity;

    /**
     * 用户出生年月
     */
    private String userBirthday;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户性别
     */
    private Character userSex;

    /**
     * 用户签名
     */
    private String userSignature;

    /**
     * 用户简介
     */
    private String userDesc;

    /**
     * 用户粉丝
     */
    private Integer userFan;

    /**
     * 用户关注量
     */
    private Integer userAttention;

    /**
     * 用户积分
     */
    private Integer userIntegral;


    /**
     * 用户注册时间
     */
    private String userCreateTime;

    /**
     * 用户帐号状态（默认1 正常 / 异常）
     */
    private Integer userStatus;

    /**
     * 用户帐号状态描述
     */
    private String userStatusDesc;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserActualName() {
        return userActualName;
    }

    public void setUserActualName(String userActualName) {
        this.userActualName = userActualName;
    }

    public String getUserIndustry() {
        return userIndustry;
    }

    public void setUserIndustry(String userIndustry) {
        this.userIndustry = userIndustry;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Character getUserSex() {
        return userSex;
    }

    public void setUserSex(Character userSex) {
        this.userSex = userSex;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Integer getUserFan() {
        return userFan;
    }

    public void setUserFan(Integer userFan) {
        this.userFan = userFan;
    }

    public Integer getUserAttention() {
        return userAttention;
    }

    public void setUserAttention(Integer userAttention) {
        this.userAttention = userAttention;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserStatusDesc() {
        return userStatusDesc;
    }

    public void setUserStatusDesc(String userStatusDesc) {
        this.userStatusDesc = userStatusDesc;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userUUID='" + userUUID + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userActualName='" + userActualName + '\'' +
                ", userIndustry='" + userIndustry + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", userCity='" + userCity + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", userSignature='" + userSignature + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", userFan=" + userFan +
                ", userAttention=" + userAttention +
                ", userIntegral=" + userIntegral +
                ", userCreateTime='" + userCreateTime + '\'' +
                ", userStatus=" + userStatus +
                ", userStatusDesc='" + userStatusDesc + '\'' +
                '}';
    }
}
