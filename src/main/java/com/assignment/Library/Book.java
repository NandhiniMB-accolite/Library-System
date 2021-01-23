package com.assignment.Library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
	
@Id
@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
@GenericGenerator(name = "native",strategy = "native")
private int bid;
private String btitle;
private String bauthor;
private String ISBN;

public Book() {}

public Book(String btitle, String bauthor, String ISBN) {
	this.btitle = btitle;
	this.bauthor = bauthor;
	this.ISBN = ISBN;
}


@Override
public String toString() {
	return "Book [bid=" + bid + ", btitle=" + btitle + ", bauthor=" + bauthor + ", ISBN=" + ISBN + "]";
}
public String getBtitle() {
	return btitle;
}
public void setBtitle(String btitle) {
	this.btitle = btitle;
}


}
