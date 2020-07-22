package com.validator.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;


public class Book implements Serializable {

    @NotEmpty(message="图书的ID不能为空")
    @Length(max=4, message="图书的ID最长为4")
    private String ID;

    @NotEmpty(message="亲， 图书名不能为空哦")
    @Pattern(regexp="[\\u4e00-\\u9fa5]+", message="亲，图书名称必须是汉字哦")
    private String name;

    @NotEmpty(message="亲， 图书的价格不能为空哦")
    @Pattern(regexp="[0-9]+\\.[0-9]*[1-9]$", message="亲，图书的价格必须是小数哦，不能随便填的哦")
    private String price;

    public Book() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID=ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price=price;
    }
}
