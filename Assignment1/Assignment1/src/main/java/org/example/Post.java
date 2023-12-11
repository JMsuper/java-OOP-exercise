package org.example;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;

public class Post {
    private User author;
    private String title;
    private String body;
    private OffsetDateTime createdTime;
    private OffsetDateTime editedTime;
    private HashSet<String> tags;

    public Post(String title){
        this(title,"","");
    }

    public Post(String title,String author,String body){
        this.author = new User(author);
        this.title = title;
        this.body = body;
        this.createdTime = OffsetDateTime.now();
        this.editedTime = OffsetDateTime.now();
        this.tags = new HashSet<>();
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public OffsetDateTime getCreatedTime() {
        return this.createdTime;
    }

    public OffsetDateTime getEditedTime() {
        return editedTime;
    }


    public void addTag(String tag){
        this.tags.add(tag);
    }

    public void updateTitle(String title) {
        this.title = title;
        this.editedTime = OffsetDateTime.now();
    }

    public void updateBody(String body) {
        this.body = body;
        this.editedTime = OffsetDateTime.now();
    }

    public boolean checkAuthor(HashSet<User> users){
        return users.contains(this.author);
    }

    public boolean containsAnyTags(HashSet<String> tags){
        return this.tags.stream().anyMatch(tags::contains);
    }
}
