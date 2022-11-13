package com.example.hibernatebooks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String booksName;
    private String name;
    private String surname;
    private String middlename;
    private Integer dataRelease;
    private String styleBooks;
    private Integer amountPages;
    private String shortDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Integer getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(Integer dataRelease) {
        this.dataRelease = dataRelease;
    }

    public String getStyleBooks() {
        return styleBooks;
    }

    public void setStyleBooks(String styleBooks) {
        this.styleBooks = styleBooks;
    }

    public Integer getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(Integer amountPages) {
        this.amountPages = amountPages;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Books() {
    }

    public Books(String booksName, String name, String surname, String middlename, Integer dataRelease, String styleBooks, Integer amountPages, String shortDescription) {
        this.booksName = booksName;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.dataRelease = dataRelease;
        this.styleBooks = styleBooks;
        this.amountPages = amountPages;
        this.shortDescription = shortDescription;
    }
}
