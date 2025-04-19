package com.readersphere.model;

public class Book {
  private String title;
  private String author;
  private double rating;

  public Book(String title, String author, double rating) {
    this.title = title;
    this.author = author;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public double getRating() {
    return rating;
  }
}
