package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

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
}
