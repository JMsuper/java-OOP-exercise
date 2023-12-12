package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestBlog {
    Blog blog;

    @BeforeEach
    void initialize(){
        this.blog = new Blog();
    }

    @Test
    void testCreateBlog(){
        assertEquals(Blog.class,blog.getClass());
    }

    @Test
    void testAddPost(){
        Post post = new Post("title");
        blog.addPost(post);
        assertTrue(blog.isPostListContains(post));
    }

    @Test
    void testSetPostOrder(){
        blog.setPostOrder(PostOrderType.CREATED_ACES);
        assertEquals(PostOrderType.CREATED_ACES,blog.getPostOrder());
    }

    @Test
    void testGetPostOrderByCREATED_DESC() throws InterruptedException {
        blog.setPostOrder(PostOrderType.CREATED_DESC);
        Post beforePost = new Post("beforePost");
        Thread.sleep(10); // created date 를 다르게 하기 위함
        Post afterPost = new Post("afterPost");
        blog.addPost(beforePost);
        blog.addPost(afterPost);

        List<Post> postList = blog.getPostList();
        assertTrue(postList.indexOf(afterPost) < postList.indexOf(beforePost));
    }

    @Test
    void testGetPostOrderByCREATED_ASEC() throws InterruptedException {
        blog.setPostOrder(PostOrderType.CREATED_ACES);
        Post beforePost = new Post("beforePost");
        Thread.sleep(10); // created date 를 다르게 하기 위함
        Post afterPost = new Post("afterPost");
        blog.addPost(beforePost);
        blog.addPost(afterPost);

        List<Post> postList = blog.getPostList();
        assertTrue(postList.indexOf(beforePost) < postList.indexOf(afterPost));
    }

    @Test
    void testGetPostOrderByTITLE_ACES(){
        blog.setPostOrder(PostOrderType.TITLE_ACES);
        Post ZZZ_Title = new Post("ZZZ_Title");
        Post AAA_Title = new Post("AAA_Title");
        blog.addPost(ZZZ_Title);
        blog.addPost(AAA_Title);

        List<Post> postList = blog.getPostList();
        assertTrue(postList.indexOf(AAA_Title) < postList.indexOf(ZZZ_Title));
    }

    @Test
    void testGetPostOrderByEDITED_ACES() throws InterruptedException {
        blog.setPostOrder(PostOrderType.EDITED_ACES);
        Post notEdited = new Post("NotEdited");
        Post edited = new Post("NotEdited");
        blog.addPost(notEdited);
        blog.addPost(edited);
        Thread.sleep(10); // edited date 를 다르게 하기 위함
        edited.updateTitle("Edited");

        List<Post> postList = blog.getPostList();
        assertTrue(postList.indexOf(notEdited) < postList.indexOf(edited));
    }

    @Test
    void testGetPostOrderByEDITED_DESC() throws InterruptedException {
        blog.setPostOrder(PostOrderType.EDITED_DESC);
        Post notEdited = new Post("NotEdited");
        Post edited = new Post("NotEdited");
        blog.addPost(notEdited);
        blog.addPost(edited);
        Thread.sleep(10); // edited date 를 다르게 하기 위함
        edited.updateTitle("Edited");

        List<Post> postList = blog.getPostList();
        assertTrue(postList.indexOf(edited) < postList.indexOf(notEdited));
    }

    @Test
    void testSetTagFilter(){
        HashSet<String> tagFilter =  new HashSet<>();
        tagFilter.add("hello");
        blog.setTagFilter(tagFilter);

        assertEquals(tagFilter,blog.getTagFilter());
        assertTrue(blog.getTagFilter().contains("hello"));
    }

    @Test
    void testSetAuthorFilter(){
        HashSet<User> authorFilter = new HashSet<>();
        User author = new User("name");
        authorFilter.add(author);
        blog.setAuthorFilter(authorFilter);

        assertEquals(authorFilter,blog.getAuthorFilter());
        assertTrue(blog.getAuthorFilter().contains(author));
    }

    @Test
    void testFilter(){
        Post filterdPost = new Post("title","Mike","body");
        filterdPost.addTag("realTag");
        Post notFilteredPost = new Post("title","John","body");
        notFilteredPost.addTag("realTag");

        blog.addPost(filterdPost);
        blog.addPost(notFilteredPost);
        blog.setTagFilter(new HashSet<>(Arrays.asList("realTag")));
        blog.setAuthorFilter(new HashSet<>(Arrays.asList(new User("Mike"))));

        Set<Post> filtered =  blog.filter();
        assertTrue(filtered.contains(filterdPost));
        assertFalse(filtered.contains(notFilteredPost));
    }
}
