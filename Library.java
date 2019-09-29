package model.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// singleton class with all library functions and library database
public class Library {
  private static Library lib_instance = null;

  // private constructor
  private Library() {
  }

  // static method to create only one Instance of singleton class
  public static Library getInstance() {
    if (lib_instance == null) {
      lib_instance = new Library();
    }
    return lib_instance;
  }

  // list of books in the library
  List<Book> books = new ArrayList<Book>();

  // books added by passing attributes through parameterised Book constructor
  {
    books.add(new Book(1, "Timothy Fisher", "Java Phrasebook", Category.TECHNICAL));
    books.add(new Book(2, "Mark Twain", "The War Prayer", Category.HISTORY));
    books.add(new Book(3, "Michael James", "Learning Ruby", Category.TECHNICAL));
    books.add(new Book(4, "Michael James", "Ruby Pocket Reference", Category.TECHNICAL));
    books.add(new Book(5, "Michael James", "XML Pocket Reference", Category.TECHNICAL));
    books.add(new Book(6, "John David", "Learning Ruby", Category.TECHNICAL));
    books.add(new Book(7, "Frank Netter", "Atlas of Human Body", Category.MEDICAL));
    books.add(new Book(8, "Devdutt Pattanaik", "7 Secrets of Shiva", Category.MYTHOLOGY));
    books.add(new Book(9, "Atul Gawande", "Being Mortal", Category.MEDICAL));
    books.add(new Book(10, "Neil Gaiman", "Norse Mythology", Category.MYTHOLOGY));
    books.add(new Book(11, "Martin Gilbert", "The Second World War", Category.HISTORY));
  }

  // map collection of users with list of issued books
  static Map<String, List<Integer>> userlist = new HashMap<String, List<Integer>>();
  // list collection of books issued to users
  static List<Integer> akashlist = new ArrayList<Integer>();
  static List<Integer> pankajlist = new ArrayList<Integer>();
  static List<Integer> sachinlist = new ArrayList<Integer>();
  static List<Integer> rohitlist = new ArrayList<Integer>();

  {
    // books issued to users
    akashlist.add(1);
    pankajlist.add(2);
    sachinlist.add(3);
    rohitlist.add(4);

    // add users as key and booklist as values in userlist map
    userlist.put("akash", akashlist);
    userlist.put("pankaj", pankajlist);
    userlist.put("sachin", sachinlist);
    userlist.put("rohit", rohitlist);
  }

  // map collection of ISBN of books and book quantity
  static Map<Integer, Integer> bookQty = new HashMap<Integer, Integer>();

  // add ISBN of books as key and quantity of book as value
  {
    bookQty.put(1, 5);
    bookQty.put(2, 4);
    bookQty.put(3, 2);
    bookQty.put(4, 5);
    bookQty.put(5, 3);
    bookQty.put(6, 2);
    bookQty.put(7, 4);
    bookQty.put(8, 3);
    bookQty.put(9, 5);
    bookQty.put(10, 3);
    bookQty.put(11, 4);
  }

  // function to check whether book is already added or not
  public int compareBookISBN(Book newBook) {
    int x = 0;
    for (Book book : Library.getInstance().books) {
      if (book.getISBN().equals(newBook.getISBN())) x = 1;
    }
    if (x == 1) return 1;
    return 0;
  }

  // function to add new book in library if new book does'nt exist
  public void addBook(Book newBook, Integer quantity) {
    // function call
    if (compareBookISBN(newBook) == 1) System.out.println("Book already exists");
    else {
      books.add(newBook);
      bookQty.put(newBook.getISBN(),quantity);
      System.out.println("New Book Added");
    }
  }
  // function to delete book by ISBN number from library
  public void deleteBook(int delete) {
    books.removeIf(book -> (book.getISBN().equals(delete)));
    System.out.println("Book with ISBN number " + delete + " has been deleted");
    System.out.println("press 0 to exit");
  }

  // function to search book by title
  public void searchTitle(String search) {
    books.forEach(book -> {
      if (book.getTitle().equalsIgnoreCase(search)) System.out.println(book);
    });
    System.out.println("===============================================");
    System.out.println("press 1 to continue to search book by title or");
    System.out.println("press 0 to exit");
  }

  // function to search book by author
  public void searchAuthor(String search) {
    books.forEach(book -> {
      if (book.getAuthor().equalsIgnoreCase(search)) System.out.println(book);
    });
    System.out.println("===============================================");
    System.out.println("press 1 to continue to search book by author or");
    System.out.println("press 0 to exit");
  }

  // function to view books by category
  public void viewBooks(int category) {
    System.out.println("==========================================================");
    books.forEach(book -> {
      if (book.getCategory().equals(Category.values()[category]))
        System.out.println(book);
    });
    System.out.println("==========================================================");
    System.out.println("press 1 to continue to view books by category or");
    System.out.println("press 0 to exit");
  }

  // function to issue book to user by ISBN if book is available and not been issued earlier
  public void issueBook(int isbn, String username) {
    // to check book availibility
    if (Library.bookQty.get(isbn) != 0) {
      for (Map.Entry<String, List<Integer>> entry : Library.userlist.entrySet()) {
        if (entry.getKey().equalsIgnoreCase(username)) {
          // to check whether book is already issued to user
          if (entry.getValue().contains(isbn)) {
            System.out.println("Book with ISBN " + isbn + " is already issued to " + username);
          } else {
            entry.getValue().add(isbn);
            System.out.println("Book with ISBN " + isbn + " issued to " + username);
            // function call to update book quantity after issuing book
            updateQuantity(isbn);
          }
        }
      }
    } else System.out.println("Book with ISBN " + isbn + " is not available");
    System.out.println("==========================================================");
    System.out.println("press 1 to continue to issue book to user or");
    System.out.println("Press 0 to exit");
  }

  // function to update book quantity after issuing book to user
  public void updateQuantity(Integer isbn) {
    Integer value = Library.bookQty.get(isbn);
    value--;
    bookQty.put(isbn, value);
  }

  // function to view list of users
  public void viewUser() {
    System.out.println("username:");
    for (Map.Entry<String, List<Integer>> entry : userlist.entrySet()) {
      String user = entry.getKey();
      System.out.println(user);
    }
  }

  // function to view list of books issued to users
  public void issuedBooks(Integer isbn) {
    books.forEach(book -> {
      if (book.getISBN().equals(isbn)) System.out.println(book);
    });
  }

  // function to view list of books with available quantity by ISBN number
  public void viewBookQuantity(int isbn) {
    books.forEach(book -> {
      if (book.getISBN().equals(isbn))
        System.out.println(book + ", quantity = [" + Library.bookQty.get(isbn) + "]");
    });
    System.out.println("press 1 to continue to view quantity or");
    System.out.println("press 0 to exit");
  }

}
