package com.chen.library.manage.entity;

import java.util.Date;


public class BookEntity {

    private String bookId;
    private String bookName;
    private String bookDescription;
    private String author;
    private String publisher;
    private String isbn;
    private String paperback;
    private String img;
    private int total;
    private int Inventory;
    private String floor;
    private String bookshelf;
    private String classification;
    private Date createDate;
    private int isDelete;

    public BookEntity() {
    }

    public BookEntity(String bookId, String bookName, String bookDescription, String author, String publisher, String isbn, String paperback, String img, int total, int inventory, String floor, String bookshelf, String classification, Date createDate, int isDelete) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.paperback = paperback;
        this.img = img;
        this.total = total;
        Inventory = inventory;
        this.floor = floor;
        this.bookshelf = bookshelf;
        this.classification = classification;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", paperback='" + paperback + '\'' +
                ", img='" + img + '\'' +
                ", total=" + total +
                ", Inventory=" + Inventory +
                ", floor='" + floor + '\'' +
                ", bookshelf='" + bookshelf + '\'' +
                ", classification='" + classification + '\'' +
                ", createDate=" + createDate +
                ", isDelete=" + isDelete +
                '}';
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getBookshelf() {
        return bookshelf;
    }

    public void setBookshelf(String bookshelf) {
        this.bookshelf = bookshelf;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
