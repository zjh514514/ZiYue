package com.superbluecat.ziyue.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "packages", schema = "zy", catalog = "")
public class PackagesEntity {
    private int id;
    private String name;
    private int money;
    private byte type;
    private Integer monNumber;
    private Integer comNumber;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Money")
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Basic
    @Column(name = "Type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "MonNumber")
    public Integer getMonNumber() {
        return monNumber;
    }

    public void setMonNumber(Integer monNumber) {
        this.monNumber = monNumber;
    }

    @Basic
    @Column(name = "ComNumber")
    public Integer getComNumber() {
        return comNumber;
    }

    public void setComNumber(Integer comNumber) {
        this.comNumber = comNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagesEntity that = (PackagesEntity) o;
        return id == that.id &&
                money == that.money &&
                type == that.type &&
                Objects.equals(name, that.name) &&
                Objects.equals(monNumber, that.monNumber) &&
                Objects.equals(comNumber, that.comNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, money, type, monNumber, comNumber);
    }
}
