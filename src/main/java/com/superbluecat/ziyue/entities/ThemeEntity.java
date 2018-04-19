package com.superbluecat.ziyue.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "theme", schema = "zy", catalog = "")
public class ThemeEntity {
    private int themeId;
    private String themeName;
    private double money;
    private String themename;

    @Id
    @Column(name = "ThemeId")
    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    @Basic
    @Column(name = "ThemeName")
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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
        return themeId == that.themeId &&
                Double.compare(that.money, money) == 0 &&
                Objects.equals(themeName, that.themeName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(themeId, themeName, money);
    }

    @Basic
    @Column(name = "Themename")
    public String getThemename() {
        return themename;
    }

    public void setThemename(String themename) {
        this.themename = themename;
    }
}
