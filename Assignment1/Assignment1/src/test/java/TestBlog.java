import org.example.Blog;
import org.example.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestBlog {

    @Test
    void testCreateBlog(){
        Blog blog = new Blog();
        Assertions.assertEquals(Blog.class,blog.getClass());
    }

    @Test
    void testAddPostAndGetPost(){
        Blog blog = new Blog();
        Post post = new Post("testName");
        blog.addPost(post);
        Assertions.assertEquals(post,blog.getPostOrNull(post));
    }

    @Test
    void testGetPostList(){
        Blog blog = new Blog();
        Post post = new Post("test");
        blog.addPost(post);
        ArrayList<Post> postList = blog.getPostList();
        Assertions.assertEquals(post,postList.get(0));
    }

}
