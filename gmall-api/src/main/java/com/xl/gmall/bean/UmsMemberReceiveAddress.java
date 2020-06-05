package com.xl.gmall.bean;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="ums_member_receive_address")// 用来命名 当前实体类 对应的数据库 表的名字
public class UmsMemberReceiveAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private String id;
    private String memberId;
    private String  name;
    @Column(name = "phone_number")
    private String  phoneNumber;
    @Column(name = "default_status")
    private Integer defaultStatus;
    @Column(name = "post_code")
    private String postCode;
    private String province;
    private String city;
    private String region;
    @Column(name = "detail_address")
    private String detailAddress;

    public UmsMemberReceiveAddress() {
    }

    public UmsMemberReceiveAddress(String memberId, String name, String phoneNumber, Integer defaultStatus, String postCode, String province, String city, String region, String detailAddress) {
        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.defaultStatus = defaultStatus;
        this.postCode = postCode;
        this.province = province;
        this.city = city;
        this.region = region;
        this.detailAddress = detailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
