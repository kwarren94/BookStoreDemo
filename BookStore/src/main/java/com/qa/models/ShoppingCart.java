package com.qa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue
	private int id;
	private String bookName;
	private String bookAuthor;
	private String bookIsbn;
	private double bookPrice;
	private String bookContents;
	private String bookOverview;
	private int bookQuantity;
	private int customerId;
	
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
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
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookIsbn="
				+ bookIsbn + ", bookPrice=" + bookPrice + ", bookContents=" + bookContents + ", bookOverview="
				+ bookOverview + ", bookQuantity=" + bookQuantity + ", customerId=" + customerId + "]";
	}
	
	

}
