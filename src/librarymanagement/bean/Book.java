package librarymanagement.bean;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    private List<String> borrowedMembers = new ArrayList<>();

    public Book(String bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseCopy() {
        availableCopies--;
    }

    public void increaseCopy() {
        availableCopies++;
    }

    public List<String> getBorrowedMembers() {
        return borrowedMembers;
    }
}