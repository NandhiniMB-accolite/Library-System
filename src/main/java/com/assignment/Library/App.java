package com.assignment.Library;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Scanner sc = new Scanner(System.in);
        BookManager bm = new BookManager();
        Configuration con = new Configuration().configure().addAnnotatedClass(Book.class);
        SessionFactory sf = con.buildSessionFactory(); //interface
        
        while(true)
        {
        	System.out.println("**************************************************************************************************");
        	System.out.println("1.Add Book\n2.Find All Books\n3.Find Book by Id \n4.Update Book \n5.Delete Book \n6.Get Total Books\nEnter Option");
            int option= sc.nextInt();
        	switch(option) {
        	
        	case 1: {
        		System.out.println("Enter Book Title\n");
        		sc.nextLine();
        		String title=sc.nextLine();
        		System.out.println("Enter Book Author\n");
        	    String author=sc.next();
        	    System.out.println("Enter Book ISBN\n");
        	    String ISBN =sc.next();
        		bm.addBook(sf,title,author,ISBN);		
        		break;
        	}
        	case 2:{
        		bm.showBook(sf);
        		break;	
        	}
        	case 3:{
        		System.out.println("Enter Book ID");
        		int Id=sc.nextInt();
        		bm.findById(sf,Id);
        		break;
        		
        	}
        	case 4:{
        		System.out.println("Enter Book ID");
        		int Id=sc.nextInt();
        		System.out.println("Enter Book title");
        		sc.nextLine();
        		String title=sc.nextLine();
        		bm.updateBook(sf,Id,title);
        		break;
        		
        	}
        	case 5:{
        		System.out.println("Enter Book ID");
        		int Id=sc.nextInt();
        		bm.deleteBook(sf,Id);
        		break;
        	}
        	case 6:{
        		bm.getCount(sf);
        		break;
        	}
        	default:break;
        	
        	}
        }
      
        
      
   
       
      
        
        
        
        
        
        
        
    }
}
