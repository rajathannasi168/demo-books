package com.books.demo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Table("bookscatalogs")
@Data
@Builder
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(value = "title")
	@JsonProperty("title")
	public	String title;

	@Column(value = "author")
	@JsonProperty("author")
	public String author;

	@Column(value = "coverPhotoURL")
	@JsonProperty("coverPhotoURL")
	public String coverPhotoURL;

	@Column(value = "isbnNumber")
	@JsonProperty("isbnNumber")
	public Long isbnNumber;

	@Column(value = "price")
	@JsonProperty("price")
	public Double price;

	@Column(value = "language")
	@JsonProperty("language")
	public String language;

	@Column(value = "genre")
	@JsonProperty("genre")
	public String genre;
	
	Book(String title, String author, String coverPhotoURL, Long isbnNumber, Double price, String language,
			String genre) {
		super();
		this.title = title;
		this.author = author;
		this.coverPhotoURL = coverPhotoURL;
		this.isbnNumber = isbnNumber;
		this.price = price;
		this.language = language;
		this.genre = genre;
	}
		@Builder
	    public static Book updateBuilder(String title, String author, String coverPhotoURL, Long isbnNumber, Double price, String language,
				String genre) {
	        return new Book(title, author, coverPhotoURL, isbnNumber,price,language,genre);
	    }
}
