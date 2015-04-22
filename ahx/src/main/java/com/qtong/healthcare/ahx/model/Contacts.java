package com.qtong.healthcare.ahx.model;

import javax.persistence.*;

/**
 * Created by ZML on 2015/4/22.
 * 联系人
 */

@Entity
@Table(name="t_contacts")
public class Contacts {

    private int contactId;//联系人ID

    private String phoneNumber;//手机号

    private String email;//邮箱

    private String address;//地址

    private String qq;//QQ号

    private String neckName;//昵称


    private Region region;//区域


    @ManyToOne(targetEntity = Region.class)
    @JoinColumn(name = "regionId",nullable = true)
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getNeckName() {
        return neckName;
    }

    public void setNeckName(String neckName) {
        this.neckName = neckName;
    }
}
