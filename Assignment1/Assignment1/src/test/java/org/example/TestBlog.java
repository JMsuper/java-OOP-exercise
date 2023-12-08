package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

public class TestBlog {

    @Test
    void testCreateBlog(){
        Blog blog = new Blog();
        assertEquals(Blog.class,blog.getClass());
    }

    @Test
    void testAddPost(){
        Blog blog = new Blog();
        Post post = new Post("testName");
        blog.addPost(post);
        assertTrue(blog.isPostListContain(post));
    }

    @Test
    void testSetPostOrder(){
        Blog blog = new Blog();
        assertEquals(PostOrderType.CREATED_DESC,blog.getPostOrder());
        blog.setPostOrder(PostOrderType.CREATED_ACES);
        assertEquals(PostOrderType.CREATED_ACES,blog.getPostOrder());
    }

    @Test
    void testGetPostOrderByCREATED_DESC() throws InterruptedException {
        Blog blog = new Blog();
        Post post1 = new Post("post1","hello","test Body");
        blog.addPost(post1);
        Thread.sleep(100);
        Post post2 = new Post("post1","hello","test Body");
        blog.addPost(post2);

        ArrayList<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(1));
        assertEquals(post2,postList.get(0));
    }

    @Test
    void testGetPostOrderByCREATED_ASEC() throws InterruptedException {
        Blog blog = new Blog();
        blog.setPostOrder(PostOrderType.CREATED_ACES);
        Post post1 = new Post("post1","hello","test Body");
        blog.addPost(post1);
        Thread.sleep(100);
        Post post2 = new Post("post1","hello","test Body");
        blog.addPost(post2);

        ArrayList<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(0));
        assertEquals(post2,postList.get(1));
    }

    @Test
    void testGetPostOrderByTITLE_ACES(){
        Blog blog = new Blog();
        blog.setPostOrder(PostOrderType.TITLE_ACES);
        Post post1 = new Post("post1","hello112","test Body");
        blog.addPost(post1);
        Post post2 = new Post("post1","hello111","test Body");
        blog.addPost(post2);

        ArrayList<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(1));
        assertEquals(post2,postList.get(0));
    }

    @Test
    void testGetPostOrderByEDITED_ACES() throws InterruptedException {
        Blog blog = new Blog();
        blog.setPostOrder(PostOrderType.EDITED_ACES);
        Post post1 = new Post("post1","hello","test Body");
        blog.addPost(post1);
        Thread.sleep(100);
        Post post2 = new Post("post1","hello","test Body");
        blog.addPost(post2);

        ArrayList<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(0));
        assertEquals(post2,postList.get(1));
    }

    @Test
    void testGetPostOrderByEDITED_DESC() throws InterruptedException {
        Blog blog = new Blog();
        blog.setPostOrder(PostOrderType.EDITED_DESC);
        Post post1 = new Post("post1","hello","test Body");
        blog.addPost(post1);
        Thread.sleep(100);
        Post post2 = new Post("post1","hello","test Body");
        blog.addPost(post2);

        ArrayList<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(1));
        assertEquals(post2,postList.get(0));
    }

    @Test
    void testSetTagFilter(){
        Blog blog = new Blog();
        HashSet<String> tagFilter =  new HashSet<>();
        tagFilter.add("hello");
        tagFilter.add("world");
        blog.setTagFilter(tagFilter);
        assertEquals(tagFilter,blog.getTagFilter());
        assertTrue(blog.getTagFilter().contains("hello"));
        assertTrue(blog.getTagFilter().contains("world"));
    }

    @Test
    void testSetAuthorFilter(){
        Blog blog = new Blog();
        HashSet<User> authorFilter = new HashSet<>();
        User author1 = new User("document");
        User author2 = new User("CS");
        authorFilter.add(author1);
        authorFilter.add(author2);
        blog.setAuthorFilter(authorFilter);
        assertEquals(authorFilter,blog.getAuthorFilter());
        assertTrue(blog.getAuthorFilter().contains(author1));
        assertTrue(blog.getAuthorFilter().contains(author2));
    }

    // todo
    @Test
    void testFilterWithTagAndAuthor(){

    }

}
