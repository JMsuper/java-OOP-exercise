package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestBlog {

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

        List<Post> postList = blog.getPostList();
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

        List<Post> postList = blog.getPostList();
        assertEquals(post1,postList.get(0));
        assertEquals(post2,postList.get(1));
    }

    @Test
    void testGetPostOrderByTITLE_ACES(){
        Blog blog = new Blog();
        blog.setPostOrder(PostOrderType.TITLE_ACES);
        Post post1 = new Post("hello112","post1","test Body");
        blog.addPost(post1);
        Post post2 = new Post("hello111","post2","test Body");
        blog.addPost(post2);

        List<Post> postList = blog.getPostList();
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

        List<Post> postList = blog.getPostList();
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

        List<Post> postList = blog.getPostList();
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

    @Test
    void testFilter(){
        Blog blog = new Blog();
        Post post1 = new Post("test","Mike","sdf");
        post1.addTag("Hello");
        Post post2 = new Post("test","John","sdf");
        post2.addTag("Hello");
        blog.addPost(post1);
        blog.addPost(post2);
        blog.setTagFilter(new HashSet<>(Arrays.asList("Hello","Hi")));

        HashSet<User> authorFilter = new HashSet<>();
        authorFilter.add(new User("Mike"));
        blog.setAuthorFilter(authorFilter);
        ArrayList<Post> result = new ArrayList<>(blog.filter());
        Post postActual = result.get(0);

        assertSame(postActual, post1);
    }
}
