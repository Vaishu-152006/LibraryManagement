package librarymanagement.main;

import librarymanagement.service.LibraryService;

import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {

            System.out.println("\n===== Library Management =====");
            System.out.println("1.Add Book");
            System.out.println("2.Register Member");
            System.out.println("3.Borrow Book");
            System.out.println("4.Book Report");
            System.out.println("5.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Copies: ");
                    int copies = sc.nextInt();

                    service.addBook(id, title, author, copies);
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String mid = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    service.registerMember(mid, name);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    mid = sc.nextLine();

                    System.out.print("Book ID: ");
                    id = sc.nextLine();

                    service.borrowBook(mid, id);
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    id = sc.nextLine();

                    service.bookReport(id);
                    break;

                case 5:
                    System.exit(0);
                    sc.close();
            }
        }
    }
}