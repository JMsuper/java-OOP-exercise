package org.example;

import java.util.ArrayList;

public class Blog {
    private ArrayList<Post> postList;

    public Blog(){
        this.postList = new ArrayList<>();
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void addPost(Post post){
        postList.add(post);
    }

    public Post getPostOrNull(Post post){
        int index = postList.indexOf(post);
        if ( index < 0){
            return null;
        }
        return postList.get(index);
    }
}
