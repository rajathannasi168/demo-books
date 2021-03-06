package com.books.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.books.demo.domain.Book;
import com.books.demo.exception.ResourceNotFoundException;
import com.books.demo.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/books")
//@CrossOrigin(origins="http://localhost:3000")
public class BookResource implements ErrorController {
	private final static String ERROR_PATH = "/error";

	/**
	 * 
	 */
	@Autowired
	private final BookRepository bookRepository;

	/**
	 * @param bookRepository
	 */
	// @Autowired
	public BookResource(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Book> getAllBooks() throws ResourceNotFoundException {
		return bookRepository.findAll();
	}

	/**
	 * @param book
	 * @return
	 */
	@PostMapping(value = "/addbook", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Book> save(@RequestBody Book book) throws ResourceNotFoundException {
		return bookRepository.save(book);
	}

	/**
	 * @param id
	 * @return
	 * @return
	 */

	@PutMapping(value = "/updateBook/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Book> findById(@PathVariable Integer id, @RequestBody Book book) throws ResourceNotFoundException {
		Book lBook = bookRepository.findById(id).block();
		lBook = lBook.toBuilder().title(book.getTitle()).author(book.getAuthor()).coverPhotoURL(book.getCoverPhotoURL())
				.isbnNumber(book.getIsbnNumber()).price(book.getPrice()).language(book.getLanguage())
				.genre(book.getGenre()).build();
		return this.bookRepository.save(lBook);
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/deleteBoook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String delete(@PathVariable Integer id) throws ResourceNotFoundException {
		String response = "Book id " + id + " Deleted...";
		try {
			bookRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 *
	 */
	@Override
	@RequestMapping(ERROR_PATH)
	@ResponseBody
	public String getErrorPath() {
		return ERROR_PATH;
	}

}
