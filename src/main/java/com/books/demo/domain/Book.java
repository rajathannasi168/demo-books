package com.books.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("bookscatalogs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	@Id
	private Integer id;

	@Column(value = "title")
	@JsonProperty("title")
	private String title;

	@Column(value = "author")
	@JsonProperty("author")
	private String author;

	@Column(value = "coverPhotoURL")
	@JsonProperty("coverPhotoURL")
	private String coverPhotoURL;

	@Column(value = "isbnNumber")
	@JsonProperty("isbnNumber")
	private Long isbnNumber;

	@Column(value = "price")
	@JsonProperty("price")
	private Double price;

	@Column(value = "language")
	@JsonProperty("language")
	private String language;

	@Column(value = "genre")
	@JsonProperty("genre")
	private String genre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCoverPhotoURL() {
		return coverPhotoURL;
	}

	public void setCoverPhotoURL(String coverPhotoURL) {
		this.coverPhotoURL = coverPhotoURL;
	}

	public Long getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(Long isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
