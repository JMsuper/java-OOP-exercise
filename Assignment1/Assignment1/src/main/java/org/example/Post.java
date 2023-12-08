package org.example;

public class Post {
    private String author;
    private String title;
    private String body;
    public Post(String title){
        this.title = title;
    }

    public Post(String author,String title,String body){
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
