package com.lbms.view;
import java.util.*;
public class Main {
    public static void main(String [] args){
        System.out.println("Welcome to our Library management system");
        //starting a do-while loop to take inputs
        int n;
        System.out.print("Enter a number:");
        Scanner sc=new Scanner(System.in);
        System.out.println();
        LibraryFunctionImplementation lfi=new LibraryFunctionImplementation();

        do{
            n=sc.nextInt();
            if(n==0){
                System.out.println("Exiting the application");
                break;
            }
            else if(n==1){
                System.out.println("You have opted to add a new book");
                System.out.print("Enter the book name:");
                String book_name=sc.next();
                System.out.println();
                System.out.print("Enter the book id:");
                String book_id=sc.next();
                //use function to add a new book
                lfi.innewbook(book_name,book_id);

            }
            else if(n==2){
                System.out.println("You are upgrading quantity of the books");
                System.out.print("Enter the count:");
                int count=sc.nextInt();
                System.out.println();
                System.out.print("Enter the id:");
                String id=sc.nextLine();
                //call function to upgrade quantity of books
                lfi.upgradecount(count,id);
            }
            else if(n==3){
                System.out.print("Enter the id of the book:");
                String id=sc.next();
                System.out.println("You are searching a book..");
                //call the function to search a book
                lfi.booksearch(id);

            }
            else if(n==4){
                System.out.println("Displaying all books..");
                //call the function to display all books
                lfi.showbooks();
            }
            else if(n==5){
                System.out.println("Registering a new student");
                System.out.println("Displaying all the registered students");
                //System.out.println("Registering the student...");
                System.out.print("Enter the Student's name:");
                String s_name=sc.next();
                System.out.print("Enter the Student's id:");
                String s_id=sc.next();
                //call function to register a new student
                lfi.registerstudent(s_name,s_id);
            }
            else if(n==6){
                System.out.println("Displaying all the students..");
                //call function to display all the studnets
                lfi.showstudents();
            }
            else if(n==7){
                System.out.println("Checking out book..");
                //call function to check out book
                lfi.checkoutbook();
            }
            else if(n==8){
                System.out.println("Checking in book...");
                //call function to check in book
                lfi.checkinbook();
            }
        }while(n!=0);
    }
}
