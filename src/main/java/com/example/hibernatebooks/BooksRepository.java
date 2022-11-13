package com.example.hibernatebooks;

import com.example.hibernatebooks.entities.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer> {

    Iterable<Books> findBooksByBooksNameContainingIgnoreCase(String booksName);
    Iterable<Books> findBooksByNameContainingIgnoreCaseAndSurnameContainingIgnoreCaseAndMiddlenameContainingIgnoreCase(String name, String surname, String middlename);
    Iterable<Books> findBooksByDataRelease(Integer dataRelease);
    Iterable<Books> findBooksByStyleBooksContainingIgnoreCase(String styleBooks);
    Iterable<Books> findBooksByAmountPages(Integer amountPages);
    Iterable<Books> findBooksByShortDescriptionContainingIgnoreCase(String shortDescription);
}
