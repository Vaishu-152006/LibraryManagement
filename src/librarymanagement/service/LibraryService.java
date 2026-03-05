package librarymanagement.service;

import java.time.LocalDate;
import java.util.*;

import librarymanagement.bean.Book;
import librarymanagement.bean.BorrowRecord;
import librarymanagement.bean.Member;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();
    public void addBook(String id, String title, String author, int copies) {
        if (books.containsKey(id)) {
            System.out.println("Book ID already exists.");
            return;
        }
        books.put(id, new Book(id, title, author, copies));
        System.out.println("Book added successfully.");
    }

    public void registerMember(String id, String name) {

        if (members.containsKey(id)) {
            System.out.println("Member ID already exists.");
            return;
        }

        members.put(id, new Member(id, name));
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(String memberId, String bookId) {

        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member == null || book == null) {
            System.out.println("Invalid Member or Book ID");
            return;
        }

        if (member.getBorrowedBooks().size() >= 3) {
            System.out.println("Member already borrowed 3 books.");
            return;
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("Book not available.");
            return;
        }

        for (BorrowRecord br : member.getBorrowedBooks()) {
            if (br.getBookId().equals(bookId)) {
                System.out.println("Cannot borrow same book twice.");
                return;
            }
        }

        BorrowRecord record = new BorrowRecord(bookId, LocalDate.now());

        member.getBorrowedBooks().add(record);
        member.increaseBorrowCount();

        book.decreaseCopy();
        book.getBorrowedMembers().add(memberId);

        System.out.println("Book borrowed successfully.");
    }

    public void bookReport(String bookId) {

        Book book = books.get(bookId);

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        System.out.println("Available Copies: " + book.getAvailableCopies());

        System.out.println("Borrowed by Members:");

        for (String id : book.getBorrowedMembers()) {
            System.out.println(id);
        }
    }
}