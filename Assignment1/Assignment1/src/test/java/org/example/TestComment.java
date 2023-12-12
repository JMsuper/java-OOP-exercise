package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestComment {
    @Test
    void testUpdateContent(){
        Comment comment = new Comment(new User("name"),"Old content");
        comment.updateContent("New content");
        Assertions.assertEquals("New content",comment.getBody());
    }

    @Test
    void testAddSubComment(){
        Comment comment = new Comment(new User("name1"),"content");
        Comment subComment = new Comment(new User("name2"),"content");
        comment.addSubComment(subComment);

        Assertions.assertTrue(comment.getSubComments().contains(subComment));
    }

    @Test
    void testAddUpVoter(){
        Comment comment = new Comment(new User("name"),"content");
        User upvoter = new User("upvoter");
        comment.addUpvoter(upvoter);

        Assertions.assertTrue(comment.getUpvoters().contains(upvoter));
    }
}
