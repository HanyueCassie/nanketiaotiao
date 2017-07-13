package com.notfound.nktt.model;

import javax.persistence.*;

public class Token {
    @Id
    private Integer userid;

    private Integer studentid;

    @Column(name = "tokenString")
    private String tokenstring;

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return studentid
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
     * @return tokenString
     */
    public String getTokenstring() {
        return tokenstring;
    }

    /**
     * @param tokenstring
     */
    public void setTokenstring(String tokenstring) {
        this.tokenstring = tokenstring;
    }
}