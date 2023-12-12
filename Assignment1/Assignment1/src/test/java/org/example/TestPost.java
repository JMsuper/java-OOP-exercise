package org.example;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class TestPost {
    @Test
    void testUpdatePostTitle() throws InterruptedException {
        Post post = new Post("Old Title");
        OffsetDateTime before = post.getEditedTime();
        Thread.sleep(100);
        post.updateTitle("New Title");
        OffsetDateTime after = post.getEditedTime();

        assertEquals("New Title",post.getTitle());
        assertTrue(before.isBefore(after));
    }

    @Test
    void testUpdatePostBody() throws InterruptedException {
        Post post = new Post("title","author","Old Body");
        OffsetDateTime before = post.getEditedTime();
        Thread.sleep(100);
        post.updateBody("New Body");
        OffsetDateTime after = post.getEditedTime();

        assertEquals("New Body",post.getBody());
        assertTrue(before.isBefore(after));
    }

    @Test
    void testAddTag(){
        Post post = new Post("title");
        post.addTag("Tag");
        assertTrue(post.getTags().contains("Tag"));
    }

    @Test
    void testCheckAuthorBySet(){
        Post post = new Post("title","real author","body");

        HashSet<User> usersTrue = new HashSet<>();
        usersTrue.add(new User("real author"));
        HashSet<User> usersFalse = new HashSet<>();
        usersFalse.add(new User("fake author"));

        assertTrue(post.checkAuthor(usersTrue));
        assertFalse(post.checkAuthor(usersFalse));
    }

    @Test
    void testContainsTags(){
        Post post = new Post("title");
        post.addTag("real tag");

        HashSet<String> tagsTrue = new HashSet<>();
        tagsTrue.add("real tag");
        HashSet<String> tagsFalse = new HashSet<>();
        tagsFalse.add("fake tag");

        assertTrue(post.containsAnyTags(tagsTrue));
        assertFalse(post.containsAnyTags(tagsFalse));
    }

    @Test
    void getCommentList(){
        Post post = new Post("title");
        User user = new User("name");

        Comment comment1 = new Comment(user,"hello");
        Comment comment2 = new Comment(user,"world");
        post.addComment(comment1);
        post.addComment(comment2);

        assertTrue(post.getComments().containsAll(Arrays.asList(comment1,comment2)));
    }

    @Test
    void testAddReaction(){
        Post post = new Post("title");
        User greatUser1 = new User("great1");
        User greatUser2 = new User("great2");
        post.addReaction(greatUser1,ReactionType.GREAT);
        post.addReaction(greatUser2,ReactionType.GREAT);
        post.addReaction(greatUser2,ReactionType.GREAT);

        List<User> greatReationUserList = post.getReaction(ReactionType.GREAT);

        assertEquals(2, greatReationUserList.size());
        assertTrue(greatReationUserList.containsAll(Arrays.asList(greatUser1,greatUser2)));
    }

    @Test
    void testRemoveReaction(){
        Post post = new Post("title");
        User greatUser = new User("name");

        post.addReaction(greatUser,ReactionType.GREAT);
        post.removeReaction(greatUser,ReactionType.GREAT);

        List<User> greatReationUserList = post.getReaction(ReactionType.GREAT);
        assertFalse(greatReationUserList.contains(greatUser));
    }
}
