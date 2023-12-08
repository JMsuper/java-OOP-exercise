package org.example;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


}
