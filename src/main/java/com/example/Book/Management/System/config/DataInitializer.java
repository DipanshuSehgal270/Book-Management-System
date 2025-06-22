package com.example.Book.Management.System.config;

import com.example.Book.Management.System.entity.*;
import com.example.Book.Management.System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create sample authors
        Author author1 = new Author("J.K. Rowling", "jk.rowling@example.com",
                LocalDate.of(1965, 7, 31), "British author, best known for Harry Potter series");
        Author author2 = new Author("George R.R. Martin", "george.martin@example.com",
                LocalDate.of(1948, 9, 20), "American novelist and short story writer");

        authorRepository.save(author1);
        authorRepository.save(author2);

        // Create sample publishers
        Publisher publisher1 = new Publisher("Bloomsbury Publishing", "contact@bloomsbury.com",
                "London, UK", "+44-20-7631-5600");
        Publisher publisher2 = new Publisher("Bantam Spectra", "info@bantam.com",
                "New York, USA", "+1-212-782-9000");

        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        // Create sample users
        User admin = new User("admin", "Admin", "User", "admin@bookmanagement.com",
                "admin123", UserRole.ADMIN);
        User librarian = new User("librarian", "Library", "Manager", "librarian@bookmanagement.com",
                "lib123", UserRole.LIBRARIAN);
        User user1 = new User("johndoe", "John", "Doe", "john.doe@example.com",
                "user123", UserRole.USER);

        userRepository.save(admin);
        userRepository.save(librarian);
        userRepository.save(user1);

        // Create sample books
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "9780747532699",
                "The first book in the Harry Potter series", LocalDate.of(1997, 6, 26),
                223, new BigDecimal("19.99"), author1, publisher1);
        book1.setStatus(BookStatus.AVAILABLE);

        Book book2 = new Book("A Game of Thrones", "9780553103540",
                "The first book in A Song of Ice and Fire series", LocalDate.of(1996, 8, 1),
                694, new BigDecimal("24.99"), author2, publisher2);
        book2.setStatus(BookStatus.AVAILABLE);

        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Sample data initialized successfully!");
    }
}
