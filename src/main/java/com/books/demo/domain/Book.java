package com.books.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author rt3
 *
 */
@Table("bookscatalogs")
@Data
@Builder(toBuilder = true)
@Getter
public class Book{
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
}
