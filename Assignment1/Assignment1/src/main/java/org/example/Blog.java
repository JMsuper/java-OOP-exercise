package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    // member variable
    private final HashSet<Post> posts;
    private HashSet<String> tagFilter;
    private HashSet<User> authorFilter;
    private PostOrderType postOrder;


    // Constructor
    public Blog(){
        this.postOrder = PostOrderType.CREATED_DESC;
        this.posts = new HashSet<>();
    }


    // Methods
    public PostOrderType getPostOrder(){
        return this.postOrder;
    }

    public void setPostOrder(PostOrderType postOrder){
        this.postOrder = postOrder;
    }

    public void setTagFilter(Set<String> tagFilter) {
        this.tagFilter = (HashSet<String>) tagFilter;
    }

    public void setAuthorFilter(Set<User> authorFilter){
        this.authorFilter = (HashSet<User>) authorFilter;
    }

    public Set<String> getTagFilter() {
        return tagFilter;
    }

    public Set<User> getAuthorFilter() {
        return authorFilter;
    }

    public List<Post> getPostList() {
        ArrayList<Post> postList = new ArrayList<>(filter());
        sortByPostOrder(postList);
        return postList;
    }

    public Set<Post> filter(){
        return filterWithTag(filterWithAuthor(this.posts));
    }

    private HashSet<Post> filterWithTag(HashSet<Post> postList){
        if(tagFilter == null || tagFilter.isEmpty()){
            return postList;
        }

        return (HashSet<Post>) postList.stream().filter(post -> post.containsAnyTags(this.tagFilter))
                .collect(Collectors.toSet());
    }

    private HashSet<Post> filterWithAuthor(HashSet<Post> postList){
        if(authorFilter == null || authorFilter.isEmpty()){
            return postList;
        }
        return (HashSet<Post>) postList.stream().filter(post -> post.checkAuthor(this.authorFilter))
                .collect(Collectors.toSet());
    }


    private void sortByPostOrder(ArrayList<Post> postList){
        switch (postOrder){
            case TITLE_ACES:
                postList.sort(Comparator.comparing(Post::getTitle));
                break;
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
