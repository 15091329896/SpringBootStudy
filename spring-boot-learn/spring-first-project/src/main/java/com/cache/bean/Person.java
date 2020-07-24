package com.cache.bean;

import javax.persistence.*;

/**
 * @ClassName person
 * @Description
 * @Author dyk
 * @Date 2020/7/23 10:15
 */
@Entity
@Table(name="person")
public class Person {

    @Id
    private Integer id;
    private String name;
    private String address;

    public Person() {
    }

    public Person(Integer id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }
    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }
}
