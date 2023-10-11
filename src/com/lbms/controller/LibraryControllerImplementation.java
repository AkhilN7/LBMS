package com.lbms.controller;

import com.lbms.model.LibraryData;
import com.lbms.view.Book;
import com.lbms.view.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryControllerImplementation implements LibraryController{

    static Map<String, List<Book>> hm_b=new HashMap<>();

    static List<Book> l_b=new ArrayList<>();

    static Map<String,List<Student>> hm_s=new HashMap<>();
    static List<Student> l_s=new ArrayList<>();

    static Map<String,String> check=new HashMap<>();
    public void addnewBook(String name,String id){
        Book b=new Book(name,id);
        l_b.add(b);
        String b_id=b.getB_id();
//        hm_b.put(id,l_b);
//        System.out.println("Book name:"+ b.getB_name()+" Book Id:"+b.getB_id());
        System.out.println(l_b.size());
//        int count=hm_b.get(b.getB_id()).size();
//        b.setCount(count);
        if(hm_b.containsKey(id)){
            hm_b.get(id).add(b);
        }else{
            List<Book> l=new ArrayList<>();
            l.add(b);
            hm_b.put(id,l);
        }
        int count=hm_b.get(b.getB_id()).size();
        b.setCount(count);
        LibraryData ld=new LibraryData();
        String book_name=b.getB_name();
        String book_id=b.getB_id();
        int book_count=b.getCount();
        ld.bookdata(book_id,book_name,book_count);
        System.out.println("Book name:"+ b.getB_name()+" Book Id:"+b.getB_id()+"Book count:"+b.getCount());

    }

    public int countupgrade(int n,String id){
//
        int count=0;
        for(Map.Entry<String,List<Book>> entry:hm_b.entrySet()){
            String key = entry.getKey();
            List<Book> values = entry.getValue();
            System.out.print("Key: " + key + ", Values: ");
            for (Book value : values) {
                System.out.print(value.getB_id() + " "+ value.getB_name()+" "+value.getCount());
            }
            int num = values.size();
            Book b = values.get(num - 1); // Get the last book in the list
            count = b.getCount();
            count += n;
            b.setCount(count); // Update the count of the last book in the list

//            System.out.println("The updated count is: " + count);
//            System.out.println("The count from map is: " + b.getCount());
        }
        LibraryData ld=new LibraryData();
        ld.countbook(id,count);
        return count;
//
    }

    public boolean searchbook(String id){
        for(Book b:l_b){
            if(b.getB_id().equals(id)){
                return true;
            }
        }
        return false;
    }

    public void showallbooks(){
//        System.out.println("Am i coming till here");
        for(Book b:l_b){
            System.out.println(l_b.size());
            System.out.println("Id:"+b.getB_id()+" "+" Name:"+b.getB_name());
        }
    }

    public void addnewStudent(String id,String name){
        Student s=new Student(name,id);
        l_s.add(s);
        String s_id=s.getS_id();
        hm_s.put(s_id,l_s);
        LibraryData ld=new LibraryData();
        ld.studentdata(id,name);
    }

    public void showallstudents(){
        for(Student s:l_s){
            System.out.println("Id:"+s.getS_id()+" Name:"+s.getS_name());
        }
    }

    public void checkout(String b_id,String s_id){
        int count=hm_b.get(b_id).get(0).getCount();
        if(count<0){
            System.out.println("Book Not Available");
        }
        else{
            count=count-1;
            check.put(b_id,s_id);
            for(Book b:hm_b.get(b_id)){
                if(b.getB_id().equals(b_id)){
                    b.setCount(count);

                }
            }
            System.out.println("Book successfully checked out");
        }
        LibraryData ld=new LibraryData();
        ld.checkoutbook(b_id,s_id);

    }

    public void checkin(String b_id,String s_id){
        int count=hm_b.get(b_id).get(0).getCount();

        count=count+1;
        if(count<0)
            System.out.println("Invalid book id");
        else{
            check.remove(b_id);
            for(Book b:hm_b.get(b_id)){
                if(b.getB_id().equals(b_id)){
                    b.setCount(count);

                }
            }
        }

        System.out.println("Book successfully checked In");
        LibraryData ld=new LibraryData();
        ld.checkinbook(b_id,s_id);

    }

}
