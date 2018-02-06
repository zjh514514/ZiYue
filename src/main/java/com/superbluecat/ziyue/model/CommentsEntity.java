package com.superbluecat.ziyue.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comments", schema = "zy", catalog = "")
public class CommentsEntity {
    private int commentId;
    private String nickname;
    private String email;
    private String website;
    private String comment;
    private String ua;
    private Timestamp time;
    private int userId;
    private Integer toCommentId;

    @Id
    @Column(name = "CommentId")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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
    @Column(name = "Website")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "Comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "Ua")
    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    @Basic
    @Column(name = "Time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "ToCommentId")
    public Integer getToCommentId() {
        return toCommentId;
    }

    public void setToCommentId(Integer toCommentId) {
        this.toCommentId = toCommentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentsEntity that = (CommentsEntity) o;

        if (commentId != that.commentId) return false;
        if (userId != that.userId) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (ua != null ? !ua.equals(that.ua) : that.ua != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (toCommentId != null ? !toCommentId.equals(that.toCommentId) : that.toCommentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (ua != null ? ua.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (toCommentId != null ? toCommentId.hashCode() : 0);
        return result;
    }
}
