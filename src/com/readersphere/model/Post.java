package com.readersphere.model;

public class Post {
  private String username;
  private String content;
  private int likes;
  private int comments;

  public Post(String username, String content, int likes, int comments) {
      this.username = username;
      this.content = content;
      this.likes = likes;
      this.comments = comments;
  }

  public String getUsername() { return username; }
  public String getContent() { return content; }
  public int getLikes() { return likes; }
  public int getComments() { return comments; }
}
