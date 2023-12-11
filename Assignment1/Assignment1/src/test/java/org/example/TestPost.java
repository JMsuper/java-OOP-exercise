package org.example;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class TestPost {
    @Test
    void testUpdatePostTitle() throws InterruptedException {
        Post post = new Post("mike","hello","world");
        OffsetDateTime before = post.getEditedTime();
        Thread.sleep(100);
        post.updateTitle("hi");
        OffsetDateTime after = post.getEditedTime();
        assertEquals("hi",post.getTitle());
        assertTrue(before.isBefore(after));
    }

    @Test
    void testUpdatePostBody() throws InterruptedException {
        Post post = new Post("mike","hello","world");
        OffsetDateTime before = post.getEditedTime();
        Thread.sleep(100);
        post.updateBody("ohio");
        OffsetDateTime after = post.getEditedTime();
        assertEquals("ohio",post.getBody());
        assertTrue(before.isBefore(after));
    }

    @Test
    void testAddTag(){
        Post post = new Post("123","!@3","!23");
        post.addTag("hello");
        assertTrue(post.getTags().contains("hello"));
    }

    @Test
    void testCheckAuthorBySet(){
        Post post = new Post("123","mike","123");
        HashSet<User> usersTrue = new HashSet<>();
        usersTrue.add(new User("mike"));
        HashSet<User> usersFalse = new HashSet<>();
        usersFalse.add(new User("John"));
        assertTrue(post.checkAuthor(usersTrue));
        assertFalse(post.checkAuthor(usersFalse));
    }

    @Test
    void testContainsTags(){
        Post post = new Post("test");
        post.addTag("tag1");
        post.addTag("tag2");

        HashSet<String> tagsTrue = new HashSet<>();
        tagsTrue.add("tag1");
        tagsTrue.add("tag3");
        HashSet<String> tagsFalse = new HashSet<>();
        tagsFalse.add("tag4");
        assertTrue(post.containsAnyTags(tagsTrue));
        assertFalse(post.containsAnyTags(tagsFalse));
    }

    @Test
    void getCommentList(){
        Post post = new Post("test");
        User user = new User("author1");
        Comment comment1 = new Comment(user,"hello");
        Comment comment2 = new Comment(user,"world");
        post.addComment(comment1);
        post.addComment(comment2);
        List<Comment> commentList = post.getComments();
        assertEquals(comment1,commentList.get(0));
        assertEquals(comment2,commentList.get(1));
    }

    @Test
    void testAddReaction(){
        Post post = new Post("test");
        User greatUser1 = new User("great1");
        User greatUser2 = new User("great2");
        post.addReaction(greatUser1,ReactionType.GREAT);
        post.addReaction(greatUser2,ReactionType.GREAT);
        post.addReaction(greatUser2,ReactionType.GREAT);

        List<User> greatReationUserList = post.getReaction(ReactionType.GREAT);
        assertEquals(2, greatReationUserList.size());
        assertTrue(greatReationUserList.contains(greatUser1));
        assertTrue(greatReationUserList.contains(greatUser2));
    }

    @Test
    void testRemoveReaction(){
        Post post = new Post("test");
        User greatUser1 = new User("great1");
        User greatUser2 = new User("great2");
        post.addReaction(greatUser1,ReactionType.GREAT);
        post.addReaction(greatUser2,ReactionType.GREAT);

        post.removeReaction(greatUser1,ReactionType.GREAT);

        List<User> greatReationUserList = post.getReaction(ReactionType.GREAT);
        assertEquals(1, greatReationUserList.size());
        assertFalse(greatReationUserList.contains(greatUser1));
        assertTrue(greatReationUserList.contains(greatUser2));
    }
}
