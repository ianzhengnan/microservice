package com.ian.springboottest;

import com.ian.springboottest.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootTestApplication {

	// 注入application.yml里的配置值
	@Value("${book.author}")
	private String bookAuthor;
	@Value("${book.name}")
	private String bookName;

	@Autowired
	private AuthorSettings authorSettings;

	@GetMapping("/book")
	public String showBook(){
		return "Book name is:" + bookName + " and book author is: " + bookAuthor;
	}

	@GetMapping("/author")
	public String getAuthor(){
		return "Author name is: " + authorSettings.getName() + " ,author age is: " + authorSettings.getAge();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}
}
