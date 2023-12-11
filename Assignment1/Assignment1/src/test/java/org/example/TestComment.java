package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class TestComment {
    @Test
    void testUpdateContent(){
        Comment comment = new Comment(new User("test"),"test");
        comment.updateContent("hello");
        Assertions.assertEquals("hello",comment.getBody());
    }

    @Test
    void testAddSubComment(){
        Comment comment = new Comment(new User("test"),"test");
        Comment subComment = new Comment(new User("test2"),"subComment");
        comment.addSubComment(subComment);
        List<Comment> subCommentList = comment.getSubComments();
        Assertions.assertEquals("subComment",subCommentList.get(0).getBody());
    }

    @Test
    void testAddUpVoter(){
        Comment comment = new Comment(new User("test"),"test");
        User upvoter = new User("upvoter");
        comment.addUpvoter(upvoter);
        List<User> upvoters = comment.getUpvoters();
        Assertions.assertEquals(upvoter,upvoters.get(0));
    }

}
