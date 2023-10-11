package com.lbms.view;

public class Book {
    private String b_name;
    private String b_id;
    private int count;

    public Book() {
    }

    public Book(String b_name,String b_id){
        this.b_name=b_name;
        this.b_id=b_id;
        this.count=0;
    }

    public Book(String b_name, String b_id,int count) {
        this.b_name = b_name;
        this.b_id = b_id;
        this.count=count;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
