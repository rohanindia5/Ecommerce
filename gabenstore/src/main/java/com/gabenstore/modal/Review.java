package com.gabenstore.modal;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Review 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reviewID;
	private int reviewRating;
	private String reviewReview;
	private String reviewName;
	private String reviewEmail;
	private boolean reviewTypeUser;
	@DateTimeFormat(pattern="dd/MM/YYYY")
	@Column(columnDefinition="Date")
	private Date reviewDate;
	private int productID;
	@ManyToOne
	@JoinColumn(name="productID",nullable=false,insertable=false,updatable=false)
	private Product product;
	
	public Review()
	{
		long millis=System.currentTimeMillis(); 
		Date d = new Date(millis);
		reviewDate=d;
	}
	
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public boolean isReviewTypeUser() {
		return reviewTypeUser;
	}
	public void setReviewTypeUser(boolean reviewTypeUser) {
		this.reviewTypeUser = reviewTypeUser;
	}
	
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public int getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getReviewReview() {
		return reviewReview;
	}
	public void setReviewReview(String reviewReview) {
		this.reviewReview = reviewReview;
	}
	public String getReviewName() {
		return reviewName;
	}
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	public String getReviewEmail() {
		return reviewEmail;
	}
	public void setReviewEmail(String reviewEmail) {
		this.reviewEmail = reviewEmail;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
