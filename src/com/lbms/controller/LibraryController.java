package com.lbms.controller;

public interface LibraryController {
    public void addnewBook(String name,String id);
    public int countupgrade(int n,String id);
    public boolean searchbook(String id);

    public void showallbooks();
    public void addnewStudent(String id,String name);

    public void showallstudents();

    public void checkout(String b_id,String s_id);

    public void checkin(String b_id,String s_id);
}
