package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private HashSet<Post> posts;
    private HashSet<String> tagFilter;
    private HashSet<User> authorFilter;
    private PostOrderType postOrder;

    public Blog(){
        this.postOrder = PostOrderType.CREATED_DESC;
        this.posts = new HashSet<>();
    }

    public PostOrderType getPostOrder(){
        return this.postOrder;
    }

    public void setPostOrder(PostOrderType postOrder){
        this.postOrder = postOrder;
    }

    public void setTagFilter(HashSet<String> tagFilter) {
        this.tagFilter = tagFilter;
    }

    public void setAuthorFilter(HashSet<User> authorFilter){
        this.authorFilter = authorFilter;
    }

    public HashSet<String> getTagFilter() {
        return tagFilter;
    }

    public HashSet<User> getAuthorFilter() {
        return authorFilter;
    }

    public ArrayList<Post> getPostList() {
        ArrayList<Post> postList = new ArrayList<>(this.posts);
        sortByPostOrder(postList);
        return postList;
    }

    private void sortByPostOrder(ArrayList<Post> postList){
        switch (postOrder){
            case TITLE_ACES:
                postList.sort(Comparator.comparing(Post::getTitle));
            case CREATED_ACES:
                postList.sort(Comparator.comparing(Post::getCreatedTime));
                break;
            case CREATED_DESC:
                postList.sort(Comparator.comparing(Post::getCreatedTime));
                Collections.reverse(postList);
                break;
            case EDITED_ACES:
                postList.sort(Comparator.comparing(Post::getEditedTime));
                break;
            case EDITED_DESC:
                postList.sort(Comparator.comparing(Post::getEditedTime));
                Collections.reverse(postList);
                break;
            default:
                assert false : "Not invalid PostOrderType!";
        }
    }

    public boolean isPostListContain(Post post){
        return posts.contains(post);
    }

    public void addPost(Post post){
        posts.add(post);
    }
}
