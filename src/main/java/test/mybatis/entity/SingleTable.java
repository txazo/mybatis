package test.mybatis.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "singleTable")
public class SingleTable implements Serializable {

    private static final long serialVersionUID = 1660654172807901660L;

    private int id;

    private String key1;

    private int key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getKeyPart1() {
        return keyPart1;
    }

    public void setKeyPart1(String keyPart1) {
        this.keyPart1 = keyPart1;
    }

    public String getKeyPart2() {
        return keyPart2;
    }

    public void setKeyPart2(String keyPart2) {
        this.keyPart2 = keyPart2;
    }

    public String getKeyPart3() {
        return keyPart3;
    }

    public void setKeyPart3(String keyPart3) {
        this.keyPart3 = keyPart3;
    }

    public String getCommonField() {
        return commonField;
    }

    public void setCommonField(String commonField) {
        this.commonField = commonField;
    }

}
