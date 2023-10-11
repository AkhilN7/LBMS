package com.lbms.view;
import com.lbms.controller.LibraryControllerImplementation;

import java.util.*;
public class LibraryFunctionImplementation implements LibraryFunctions{
    Scanner sc=new Scanner(System.in);
    public void innewbook(String book_name,String book_id){

        //call the function in the controller
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.addnewBook(book_name,book_id);
        System.out.println("Book added successfully");
    }

    public void upgradecount(int n,String id){
        //call the function in the controller
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.countupgrade(n,id);
        System.out.println("Count updated successfully");

    }

    public void booksearch(String id){
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        boolean b = lci.searchbook(id);// call the function from controller class
        String word=b?"available":"not avalilable";
        System.out.println("The book is "+word);

    }

    public void showbooks(){
        //call the function from controller
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.showallbooks();
    }

    public void registerstudent(String name,String id){

        //call the function from the controller class
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.addnewStudent(id,name);
        System.out.println("Successfully registered the student");
    }

    public void showstudents(){
        //call the function from the controller class
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.showallstudents();
    }

    public void checkoutbook(){
        System.out.println("Checking out...");
        System.out.print("Enter the book's id:");
        String b_id=sc.next();
        System.out.println("Enter the student's id:");
        String s_id=sc.next();
        //call the function from the controller
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.checkout(b_id,s_id);
        System.out.println("Successfully checked-out");
    }

    public void checkinbook(){
        System.out.println("Checking In...");
        System.out.print("Enter the book's id:");
        String b_id=sc.next();
        System.out.println("Enter the student's id:");
        String s_id=sc.next();
        //call the function from the controller
        LibraryControllerImplementation lci=new LibraryControllerImplementation();
        lci.checkin(b_id,s_id);
        System.out.println("Successfully checked-In");
    }
}
