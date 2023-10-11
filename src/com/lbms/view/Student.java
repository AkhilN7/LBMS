package com.lbms.view;

public class Student {
    private String s_name;
    private String s_id;

    public Student() {
    }

    public Student(String s_name, String s_id) {
        this.s_name = s_name;
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
}
