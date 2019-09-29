package model.library;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      DisplayLibrary.displayMenu(); // display menu for library operations
      int choice = sc.nextInt();

      switch (choice) {
        // to add book to library
        case 1:
          do {
            System.out.println("Add new Book");
            System.out.println("==============================================");
            Book newBook = new Book(); // // add new book through Book constructor
            Library.getInstance().addBook(newBook); // call fucntion from Library
            DisplayLibrary.displayAdd(); // display to continue or exit
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;
        // to delete book from library by unique ISBN number
        case 2:
          do {
            System.out.println("Enter the ISBN number to delete book from library");
            int delete = sc.nextInt();
            Library.getInstance().deleteBook(delete); // function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        // to search book by title
        case 3:
          do {
            System.out.println("Enter the Title of the book ");
            sc.nextLine();
            String search = sc.nextLine();
            Library.getInstance().searchTitle(search);// function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        // to search book by author
        case 4:
          do {
            System.out.println("Enter the name of the author");
            sc.nextLine();
            String search = sc.nextLine();
            Library.getInstance().searchAuthor(search); // function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        //  to view book list by Category
        case 5:
          do {
            DisplayLibrary.displayBook();  // display category to select category
            int category = sc.nextInt();
            Library.getInstance().viewBooks(category);  // function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        // to issue book to user
        case 6:
          do {
            Library.getInstance().viewUser(); // function call from library
            System.out.println("Enter the username to issue book");
            sc.nextLine();
            String username = sc.nextLine();
            System.out.println("Enter the ISBN number to issue book to " + username);
            int isbn = sc.nextInt();
            Library.getInstance().issueBook(isbn, username); // function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        // to view books issued to user by username
        case 7:
          do {
            List<Integer> values = null;
            Library.getInstance().viewUser();  // function call from library
            System.out.println("Enter the username to view issued books ");
            sc.nextLine();
            String username = sc.nextLine();
            // to get list of books issued to user
            for (Map.Entry<String, List<Integer>> entry : Library.userlist.entrySet()) {
              if (entry.getKey().equalsIgnoreCase(username)) {
                values = entry.getValue();
              }
            }
            // function call from library to display book issued to user
            values.forEach(integer -> Library.getInstance().issuedBooks(integer));
            System.out.println("press 0 to exit");
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        // to view Quantity of book by ISBN number
        case 8:
          do {
            System.out.println("Enter the ISBN number to view its Quantity");
            int isbn = sc.nextInt();
            Library.getInstance().viewBookQuantity(isbn);  // function call from library
            choice = sc.nextInt();
          }
          while (choice != 0);
          break;

        case 0:
          System.out.println("Exit");
          System.exit(0);
          break;

        default:
          System.out.println("Please select correct choice");
      }
    }
  }

}
