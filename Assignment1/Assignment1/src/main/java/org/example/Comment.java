package org.example;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    // member variable
    private final User author;
    private String content;
    private final ArrayList<Comment> subComments;
    private final ArrayList<User> upvoters;
    private final ArrayList<User> downvoters;

    // Constructor
    public Comment(User author, String content){
        this.author = author;
        this.content = content;
        this.subComments = new ArrayList<>();
        this.upvoters = new ArrayList<>();
        this.downvoters = new ArrayList<>();
    }

    // Method
    public String getBody() {
        return content;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public List<User> getUpvoters() {
        return upvoters;
    }

    public List<User> getDownvoters() {
        return downvoters;
    }

    public void updateContent(String content){
        this.content = content;
    }

    public void addSubComment(Comment subComment){
        this.subComments.add(subComment);
    }

    public boolean addUpvoter(User upvoter){
        if(upvoters.contains(upvoter)) return false;
        this.upvoters.add(upvoter);
        return true;
    }

    public boolean addDownvoter(User downvoter){
        if(downvoters.contains(downvoter)) return false;
        this.downvoters.add(downvoter);
        return true;
    }
}
