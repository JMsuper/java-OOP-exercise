package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestPost {
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
}
