package com.notfound.nktt.model;

import javax.persistence.*;

public class Users {
    @Id
    @Column(name = "iUser_serial_number")
    private Integer iuserSerialNumber;

    @Column(name = "user_name")
    private String userName;

    private String gender;

    @Column(name = "studentID")
    private Integer studentid;

    @Column(name = "IDnumber")
    private String idnumber;

    private String password;

    private String qq;

    private String telephone;

    /**
     * @return iUser_serial_number
     */
    public Integer getIuserSerialNumber() {
        return iuserSerialNumber;
    }

    /**
     * @param iuserSerialNumber
     */
    public void setIuserSerialNumber(Integer iuserSerialNumber) {
        this.iuserSerialNumber = iuserSerialNumber;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return studentID
     */
    public Integer getStudentid() {
        return studentid;
    }

    /**
     * @param studentid
     */
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    /**
     * @return IDnumber
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * @param idnumber
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}