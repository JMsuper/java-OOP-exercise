package org.example;

import org.example.registry.Registry;

public class App {
    public App(Registry registry) {
        // Register like this
        // registry.registerPostAdder("Foo", "bar");

        registry.registerBlogCreator("Blog"); // 블로그를 생성하는 생성자
        registry.registerTagFilterSetter("...","..."); // 태그 필터 설정 메서드
        registry.registerAuthorFilterSetter("...","..."); // 작성자 필터 설정 메서드

        registry.registerPostOrderSetter("Blog","setPostOrder"); // 블로그 글의 정렬 방법 설정 메서드
        registry.registerPostListGetter("Blog","getPostList"); // 블로그 글 목록을 가져오는 메서드
        registry.registerPostAdder("Blog","addPost"); // 블로그 글을 추가하는 메서드

        registry.registerPostTitleUpdater("Post","updateTitle"); // 발행된 블로그 글의 제목을 수정하는 메서드
        registry.registerPostBodyUpdater("Post","updateBody"); // 발행된 블로그 글의 본문을 수정하는 메서드
        registry.registerPostTagAdder("...","..."); // 블로그 글에 태그를 추가하는 메서드
//        registry.registerCommentAdder("...","..."); // 블로그 글에 댓글을 추가하는 메서드
//
//        registry.registerCommentUpdater("...","..."); // 댓글에 내용을 수정하는 메서드
//        registry.registerSubcommentAdder("...","..."); // 댓글에 하위 댓글을 추가하는 메서드
//        registry.registerSubcommentUpdater("...","..."); // 하위 댓글의 내용을 수정하는 메서드
//
//        registry.registerReactionAdder("...","..."); // 블로그 글에 리액션을 추가하는 메서드
//        registry.registerReactionRemover("...","..."); // 블로그 글로부터 리액션을 제거하는 메서드
//
//        registry.registerCommentUpvoter("...","..."); // 댓글에 추천하는 메서드
//        registry.registerCommentDownvoter("...","..."); // 댓글에 비추천하는 메서드
//
//        registry.registerSubcommentUpvoter("...","..."); // 하위 댓글을 추천하는 메서드
//        registry.registerSubcommentDownvoter("...","..."); // 하위 댓글을 비추천하는 메서드
//
//        registry.registerCommentListGetter("...","..."); // 블로그 글에 달린 댓글 리스트를 가져오는 메서드
//        registry.registerSubcommentListGetter("...","..."); // 댓글에 달린 하위 댓글 리스트를 가져오는 메서드
    }
}