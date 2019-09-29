package model.library;

public class DisplayLibrary {

  // function to display menu
  public static void displayMenu() {
    System.out.println("==========================================================");
    System.out.println("Welcome to Library Management System");
    System.out.println("==========================================================");
    System.out.println("Press 1 to add book to library");
    System.out.println("Press 2 to delete book from library");
    System.out.println("Press 3 to search book by title");
    System.out.println("Press 4 to search book by author");
    System.out.println("Press 5 to view book list by Category");
    System.out.println("Press 6 to issue book to user");
    System.out.println("Press 7 to view books issued to user");
    System.out.println("Press 8 to view Quantity of book by ISBN number");
    System.out.println("Press 0 to exit");
    System.out.println("==========================================================");
    System.out.println("Enter your choice");
  }

  // function to display whether to continue to add book or exit
  public static void displayAdd() {
    System.out.println("==============================================");
    System.out.println("press 1 to continue to add new book or");
    System.out.println("press 0 to exit");
  }

  // function to display book category to select category
  public static void displayBook() {
    System.out.println("View book list by Category");
    System.out.println("==========================================================");
    System.out.println("Press 0 to view book list of Category Mythology");
    System.out.println("Press 1 to view book list of Category Technical");
    System.out.println("Press 2 to view book list of Category History");
    System.out.println("Press 3 to view book list of Category Medical");
  }


}
