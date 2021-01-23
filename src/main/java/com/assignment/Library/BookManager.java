package com.assignment.Library;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookManager {

	
 public void addBook(SessionFactory sf,String title, String author,String ISBN) {
	 Book book = new Book(title,author,ISBN);
	 Session session= sf.openSession(); //interface
     Transaction tx = session.beginTransaction(); //ACID
     session.save(book);
     tx.commit();
 }
	
public void showBook(SessionFactory sf)
{
	 Session session= sf.openSession(); //interface
     Transaction tx = session.beginTransaction(); //ACID
     List<Book> bookList = session.createQuery("FROM Book").list();
     for(Book result:bookList)
    	 System.out.println(result+"\n");
     tx.commit();
     
  
}
public void findById(SessionFactory sf,int id)
{
	 Session session= sf.openSession(); //interface
     Transaction tx = session.beginTransaction(); //ACID
     
     try {
    	   Book book = session.get(Book.class, id);
    	  if(book == null)
    		  throw new Exception("Book Unavailable");
     }
     catch(Exception e) {
    	 System.out.println(e);
     }
   
     
     tx.commit();
     
  
}

public void updateBook(SessionFactory sf,int id, String Title) {
	 Session session= sf.openSession(); //interface
     Transaction tx = session.beginTransaction(); //ACID
     Book book = session.get(Book.class,id);
     book.setBtitle(Title);
     session.update(book);
     System.out.println(book);
     tx.commit();
}
public void deleteBook(SessionFactory sf,int id) {
	Session session= sf.openSession(); //interface
    Transaction tx = session.beginTransaction(); //ACID
    Book book = session.get(Book.class,id);
    session.remove(book);
    tx.commit();
}

public void getCount(SessionFactory sf)
{
	 Session session= sf.openSession(); //interface
     Transaction tx = session.beginTransaction(); //ACID
     List<Book> bookList = session.createQuery("FROM Book").list();
    System.out.println("Total Availble books = "+bookList.size()+"\n");
     tx.commit();
     
  
}
}
