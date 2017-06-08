package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue
	private int id;
	private String bookName;
	private String bookAuthor;
	private String bookIsbn;
	private double bookPrice;
	private String bookContents;
	private String bookOverview;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookContents() {
		return bookContents;
	}
	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}
	public String getBookOverview() {
		return bookOverview;
	}
	public void setBookOverview(String bookOverview) {
		this.bookOverview = bookOverview;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookIsbn=" + bookIsbn
				+ ", bookPrice=" + bookPrice + ", bookContents=" + bookContents + ", bookOverview=" + bookOverview
				+ "]";
	}
	
	
	

}
