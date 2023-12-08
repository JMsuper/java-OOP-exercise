package org.example;

import java.time.OffsetDateTime;

public class Post {
    private String author;
    private String title;
    private String body;
    private OffsetDateTime createdTime;
    private OffsetDateTime editedTime;


    public Post(String title){
        this(title,"","");
    }

    public Post(String author,String title,String body){
        this.author = author;
        this.title = title;
        this.body = body;
        this.createdTime = OffsetDateTime.now();
        this.editedTime = OffsetDateTime.now();
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public OffsetDateTime getCreatedTime() {
        return this.createdTime;
    }

    public OffsetDateTime getEditedTime() {
        return editedTime;
    }

    public void updateTitle(String title) {
        this.title = title;
        this.editedTime = OffsetDateTime.now();
    }

    public void updateBody(String body) {
        this.body = body;
        this.editedTime = OffsetDateTime.now();
    }
}
