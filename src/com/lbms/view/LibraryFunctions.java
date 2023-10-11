package com.lbms.view;

public interface LibraryFunctions {
    public void innewbook(String name,String id);
    public void upgradecount(int n,String id);
    public void  booksearch(String id);
    public void showbooks();
    public void registerstudent(String name,String id);
    public void showstudents();
    public void checkoutbook();
    public void checkinbook();

}
