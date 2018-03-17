package com.superbluecat.ziyue.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "theme", schema = "zy", catalog = "")
public class ThemeEntity {
    private int themeId;
    private String themename;
    private double money;
    private Collection<UserThemeEntity> userThemesByThemeId;

    @Id
    @Column(name = "ThemeId")
    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    @Basic
    @Column(name = "Themename")
    public String getThemename() {
        return themename;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }

    @Basic
    @Column(name = "Money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThemeEntity that = (ThemeEntity) o;

        if (themeId != that.themeId) return false;
        if (Double.compare(that.money, money) != 0) return false;
        if (themename != null ? !themename.equals(that.themename) : that.themename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = themeId;
        result = 31 * result + (themename != null ? themename.hashCode() : 0);
        temp = Double.doubleToLongBits(money);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "themeByThemeId")
    public Collection<UserThemeEntity> getUserThemesByThemeId() {
        return userThemesByThemeId;
    }

    public void setUserThemesByThemeId(Collection<UserThemeEntity> userThemesByThemeId) {
        this.userThemesByThemeId = userThemesByThemeId;
    }
}
