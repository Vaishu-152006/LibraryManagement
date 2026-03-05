package librarymanagement.bean;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;

    private List<BorrowRecord> borrowedBooks = new ArrayList<>();
    private int totalBorrowed = 0;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<BorrowRecord> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getTotalBorrowed() {
        return totalBorrowed;
    }

    public void increaseBorrowCount() {
        totalBorrowed++;
    }
}