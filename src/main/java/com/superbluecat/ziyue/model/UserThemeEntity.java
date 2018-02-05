package com.superbluecat.ziyue.model;

import javax.persistence.*;

@Entity
@Table(name = "userTheme", schema = "zy", catalog = "")
public class UserThemeEntity {
    private int id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserThemeEntity that = (UserThemeEntity) o;

        if (id != that.id) return false;
        if (themeId != that.themeId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + themeId;
        result = 31 * result + userId;
        return result;
    }
}
