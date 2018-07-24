package com.booklendingapplication.pojo;

import java.util.Date;

public class Request {
	private String requestId;
	private String userId;
	private String bookId;
	private int reject_accepted;
	private int returned;
	private Date request_date;
	private int withdraw;
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getReject_accepted() {
		return reject_accepted;
	}
	public void setReject_accepted(int reject_accepted) {
		this.reject_accepted = reject_accepted;
	}
	public int getReturned() {
		return returned;
	}
	public void setReturned(int returned) {
		this.returned = returned;
	}
	public Date getRequest_date() {
		return request_date;
	}
	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
}
