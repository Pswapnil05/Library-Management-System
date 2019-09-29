package model.library;

import java.util.Scanner;

public class Book {


  private final Integer ISBN;
  private String title;
  private String author;
  private Category category;

  Scanner sc = new Scanner(System.in);

  // default constructor
  public Book() {
    System.out.println("Enter ISBN number");
    this.ISBN = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter name of book author");
    this.author = sc.nextLine();
    System.out.println("Enter title of the book");
    this.title = sc.nextLine();
    System.out.println("Enter the category");
    System.out.println("Press 0 for Category Mythology");
    System.out.println("Press 1 for Category Technical");
    System.out.println("Press 2 for Category History");
    System.out.println("Press 3 for Category Medical");
    this.category = Category.values()[sc.nextInt()];
  }

  // parameterised constructor
  Book(Integer ISBN, String author, String title, Category category) {
    this.ISBN = ISBN;
    this.title = title;
    this.author = author;
    this.category = category;
  }

  // getter & setter
  public Integer getISBN() {
    return ISBN;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public Category getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Book{" +
        "ISBN=" + ISBN +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", category=" + category +
        '}';
  }
}
