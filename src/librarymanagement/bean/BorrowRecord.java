package librarymanagement.bean;

import java.time.LocalDate;

public class BorrowRecord {

    private String bookId;
    private LocalDate borrowDate;

    public BorrowRecord(String bookId, LocalDate borrowDate) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
}