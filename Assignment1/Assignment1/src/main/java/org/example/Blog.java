package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Blog {
    private HashSet<Post> posts;
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

    public ArrayList<Post> getPostList() {
        ArrayList postList = new ArrayList(this.posts);
        sortByPostOrder(postList);
        return postList;
    }

    private void sortByPostOrder(ArrayList<Post> postList){
        switch (postOrder){
            case TITLE_ACES:
                Collections.sort(postList, Comparator.comparing(Post::getTitle));
            case CREATED_ACES:
                Collections.sort(postList, Comparator.comparing(Post::getCreatedTime));
                break;
            case CREATED_DESC:
                Collections.sort(postList, Comparator.comparing(Post::getCreatedTime));
                Collections.reverse(postList);
                break;
            case EDITED_ACES:
                Collections.sort(postList, Comparator.comparing(Post::getEditedTime));
                break;
            case EDITED_DESC:
                Collections.sort(postList, Comparator.comparing(Post::getEditedTime));
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
