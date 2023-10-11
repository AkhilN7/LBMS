package com.lbms.model;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

public class LibraryData {
//    String jdbcURL = "jdbc:mysql://localhost:3306/mydb";
//    String username = "root";
//    String password = "N@mbiarsn6";
    Connection con;

    public void get_Connection(){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lib", "root", "N@mbiarsn6");
            System.out.println("Database connected successfully");

        } catch (ClassNotFoundException exobj) {
            System.out.println("Driver could not be loaded");
            exobj.printStackTrace();
        } catch (SQLException exob2) {
            System.out.println("Connection not happened");
            exob2.printStackTrace();
        }
    }

    public void bookdata(String b_id,String b_name,int b_count)  {
        //get_Connection();
        //System.out.println("Callig from add book");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lib", "root", "N@mbiarsn6");
            System.out.println("Database connected successfully");

        } catch (ClassNotFoundException exobj) {
            System.out.println("Driver could not be loaded");
            exobj.printStackTrace();
        } catch (SQLException exob2) {
            System.out.println("Connection not happened");
            exob2.printStackTrace();
        }
        String ins="INSERT INTO Book (bookid,bookname,bookcount) VALUES (?,?,?)";
        try{
            PreparedStatement preparedStmt = con.prepareStatement(ins);
            preparedStmt.setString(1,b_id);
            preparedStmt.setString(2,b_name);
            preparedStmt.setInt(3,b_count);
            //preparedStmt.execute();
            preparedStmt.executeUpdate();
            //con.commit();
            con.close();
        }catch(SQLException ob3) {
        }
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }




    }

    public void studentdata(String s_id,String s_name){
        get_Connection();
        String ins="INSERT INTO Student (studentid,studentname) VALUES (?,?)";
        try{
            PreparedStatement preparedStmt=con.prepareStatement(ins);
            preparedStmt.setString(1,s_id);
            preparedStmt.setString(2,s_name);
            preparedStmt.execute();
            con.commit();
            //con.close();

        }catch(SQLException ob3) {
        }
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void countbook(String b_id,int b_count){
        get_Connection();
        String ins="UPDATE Book SET bookcount=? WHERE bookid=?";
        try{
            PreparedStatement preparedStmt=con.prepareStatement(ins);
            preparedStmt.setInt(1,b_count);
            preparedStmt.setString(2,b_id);
            preparedStmt.executeUpdate();
            con.commit();
            //con.close();
        }catch(SQLException ob3) {
        }
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void checkoutbook(String b_id,String s_id){
        get_Connection();
        String ins="INSERT INTO Lending (b_id,s_id) VALUES (?,?)";
        try{
            PreparedStatement preparedStmt=con.prepareStatement(ins);
            preparedStmt.setString(1,b_id);
            preparedStmt.setString(2,s_id);
            preparedStmt.execute();
            con.commit();


        }catch(SQLException ob3) {
        }
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public void checkinbook(String b_id,String s_id){
        get_Connection();
        String ins="DELETE FROM Lending WHERE b_id=? AND s_id=?";
        try{
            PreparedStatement preparedStmt=con.prepareStatement(ins);
            preparedStmt.setString(1,b_id);
            preparedStmt.setString(2,s_id);
            preparedStmt.execute();
            con.commit();
            //con.close();

        }catch(SQLException ob3) {
        }
        try {
            con.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
}

