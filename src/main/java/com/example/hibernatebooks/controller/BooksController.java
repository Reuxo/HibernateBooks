package com.example.hibernatebooks.controller;

import com.example.hibernatebooks.BooksRepository;
import com.example.hibernatebooks.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/books")
public class BooksController {

    @Autowired
    private BooksRepository booksRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBooks(@RequestParam String booksName,
                                            @RequestParam String name,
                                            @RequestParam String surname,
                                            @RequestParam String middlename,
                                            @RequestParam Integer dataRelease,
                                            @RequestParam String styleBooks,
                                            @RequestParam Integer amountPages,
                                            @RequestParam String shortDescription) {

        Books books = new Books(booksName, name, surname, middlename, dataRelease, styleBooks, amountPages, shortDescription);
        booksRepository.save(books);

        return "Books " + booksName + " saved";
    }

    ;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Books> all() {
        return booksRepository.findAll();
    }

    @GetMapping(path = "/delete")
    public @ResponseBody String delete(@RequestParam Integer id) {
        booksRepository.deleteById(id);
        return "Books " + id + " delete";
    }

    @GetMapping(path = "/update")
    public @ResponseBody String update(@RequestParam Integer id,
                                       @RequestParam(required = false) String booksName,
                                       @RequestParam(required = false) String name,
                                       @RequestParam(required = false) String surname,
                                       @RequestParam(required = false) String middlename,
                                       @RequestParam(required = false) Integer dataRelease,
                                       @RequestParam(required = false) String styleBooks,
                                       @RequestParam(required = false) Integer amountPages,
                                       @RequestParam(required = false) String shortDescription) {

        Books books = booksRepository.findById(id).get();
        if (booksName != null) {
            books.setBooksName(booksName);
        }
        if (name != null) {
            books.setName(name);
        }
        if (surname != null) {
            books.setSurname(surname);
        }
        if (middlename != null) {
            books.setMiddlename(middlename);
        }
        if (dataRelease != null) {
            books.setDataRelease(dataRelease);
        }
        if (styleBooks != null) {
            books.setStyleBooks(styleBooks);
        }
        if (amountPages != null) {
            books.setAmountPages(amountPages);
        }
        if (shortDescription != null) {
            books.setShortDescription(shortDescription);
        }

        booksRepository.save(books);
        return "Книга изменена " + booksName;
    }

    @GetMapping(path = "/findByName")
    public @ResponseBody Iterable<Books> findByName(@RequestParam String booksName) {
        return booksRepository.findBooksByBooksNameContainingIgnoreCase(booksName);
    }

    @GetMapping(path = "/findByFIO")
    public @ResponseBody Iterable<Books> findByFIO(@RequestParam String name,
                                                   @RequestParam String surname,
                                                   @RequestParam String middlename){
        return booksRepository.findBooksByNameContainingIgnoreCaseAndSurnameContainingIgnoreCaseAndMiddlenameContainingIgnoreCase(name, surname, middlename);
    }

    @GetMapping(path = "/findByDataRelease")
    public @ResponseBody Iterable<Books> findByDataRelease(@RequestParam Integer dataRelease) {
        return booksRepository.findBooksByDataRelease(dataRelease);
    }

    @GetMapping(path = "/findByStyleBook")
    public @ResponseBody Iterable<Books> findByStyleBook(@RequestParam String styleBooks) {
        return booksRepository.findBooksByStyleBooksContainingIgnoreCase(styleBooks);
    }

    @GetMapping(path = "/findByAmountPages")
    public @ResponseBody Iterable<Books> findByAmountPages(@RequestParam Integer amountPages){
        return booksRepository.findBooksByAmountPages(amountPages);
    }

    @GetMapping(path = "/findByShortDescription")
    public @ResponseBody Iterable<Books> findByShortDescription(@RequestParam String shortDescription){
        return booksRepository.findBooksByShortDescriptionContainingIgnoreCase(shortDescription);
    }

}
