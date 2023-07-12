package jp.co.sss.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_user")
public class BookUser {

	@Id
	private int bookUserId;

	@Column
	private String bookUserName;

	@Column
	private String password;

	public int getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(int bookUserId) {
		this.bookUserId = bookUserId;
	}

	public String getBookUserName() {
		return bookUserName;
	}

	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}