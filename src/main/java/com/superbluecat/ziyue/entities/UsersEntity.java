package com.superbluecat.ziyue.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "zy", catalog = "")
public class UsersEntity {
    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String tel;
    private String apiKey;
    private byte userType;
    private byte isMonth;
    private Timestamp payTime;
    private Integer commentsLeft;
    private Integer monthLeft;

    @Id
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "ApiKey")
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Basic
    @Column(name = "UserType")
    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "IsMonth")
    public byte getIsMonth() {
        return isMonth;
    }

    public void setIsMonth(byte isMonth) {
        this.isMonth = isMonth;
    }

    @Basic
    @Column(name = "PayTime")
    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "CommentsLeft")
    public Integer getCommentsLeft() {
        return commentsLeft;
    }

    public void setCommentsLeft(Integer commentsLeft) {
        this.commentsLeft = commentsLeft;
    }

    @Basic
    @Column(name = "MonthLeft")
    public Integer getMonthLeft() {
        return monthLeft;
    }

    public void setMonthLeft(Integer monthLeft) {
        this.monthLeft = monthLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId &&
                userType == that.userType &&
                isMonth == that.isMonth &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(email, that.email) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(apiKey, that.apiKey) &&
                Objects.equals(payTime, that.payTime) &&
                Objects.equals(commentsLeft, that.commentsLeft) &&
                Objects.equals(monthLeft, that.monthLeft);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, username, password, nickname, email, tel, apiKey, userType, isMonth, payTime, commentsLeft, monthLeft);
    }
}
