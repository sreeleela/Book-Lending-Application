package com.booklendingapplication.pojo;

import java.util.Date;

public class Book {
	private int bookId;
	private String bookISBN;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private String bookEdition;
	private String bookDescription;
	private String bookOwner;
	private Date bookAvailableFrom;
	private Date bookAvailableTo;
	private User user;
	private int bookHold;
	private int bookAvailable;
	private String bookRequester;
	private String requestId;
	private Date requestDate;
	private int reject_accept;
	private int withdraw;
	private int returned;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookISBN() {
		return bookISBN;
	}
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
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
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getBookEdition() {
		return bookEdition;
	}
	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getBookOwner() {
		return bookOwner;
	}
	public void setBookOwner(String bookOwner) {
		this.bookOwner = bookOwner;
	}
	public Date getBookAvailableFrom() {
		return bookAvailableFrom;
	}
	public void setBookAvailableFrom(Date bookAvailableFrom) {
		this.bookAvailableFrom = bookAvailableFrom;
	}
	public Date getBookAvailableTo() {
		return bookAvailableTo;
	}
	public void setBookAvailableTo(Date bookAvailableTo) {
		this.bookAvailableTo = bookAvailableTo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBookHold() {
		return bookHold;
	}
	public void setBookHold(int bookHold) {
		this.bookHold = bookHold;
	}
	public int getBookAvailable() {
		return bookAvailable;
	}
	public void setBookAvailable(int bookAvailable) {
		this.bookAvailable = bookAvailable;
	}
	public String getBookRequester() {
		return bookRequester;
	}
	public void setBookRequester(String bookRequester) {
		this.bookRequester = bookRequester;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public int getReject_accept() {
		return reject_accept;
	}
	public void setReject_accept(int reject_accept) {
		this.reject_accept = reject_accept;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
}
