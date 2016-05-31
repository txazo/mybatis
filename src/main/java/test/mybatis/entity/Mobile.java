package test.mybatis.entity;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "mobile")
public class Mobile implements Serializable {

    private static final long serialVersionUID = -5438339795954006852L;

    private int id;
    private String os;
    private String brand;
    private String model;
    private int price;

    public Mobile() {
    }

    public Mobile(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public Mobile(String os, String brand, String model, int price) {
        this.os = os;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
