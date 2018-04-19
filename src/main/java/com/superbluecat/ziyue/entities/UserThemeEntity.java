package com.superbluecat.ziyue.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userTheme", schema = "zy", catalog = "")
public class UserThemeEntity {
    private int id;
    private byte isUse;
    private int themeId;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IsUse")
    public byte getIsUse() {
        return isUse;
    }

    public void setIsUse(byte isUse) {
        this.isUse = isUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserThemeEntity that = (UserThemeEntity) o;
        return id == that.id &&
                isUse == that.isUse;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isUse);
    }

    @Basic
    @Column(name = "ThemeId")
    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    @Basic
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
