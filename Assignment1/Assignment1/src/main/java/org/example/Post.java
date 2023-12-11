package org.example;

import java.time.OffsetDateTime;
import java.util.*;

public class Post {
    // member variable
    private final User author;
    private String title;
    private String body;
    private final OffsetDateTime createdTime;
    private OffsetDateTime editedTime;
    private final HashSet<String> tags;
    private final ArrayList<Comment> comments;
    private final EnumMap<ReactionType,HashSet<User>> reactionMap;

    // Constructor
    public Post(String title){
        this(title,"","");
    }

    public Post(String title,String author,String body){
        this.author = new User(author);
        this.title = title;
        this.body = body;
        this.createdTime = OffsetDateTime.now();
        this.editedTime = OffsetDateTime.now();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
        this.reactionMap = new EnumMap<>(ReactionType.class);
        Arrays.stream(ReactionType.values())
                .forEach(reactionType ->  reactionMap.put(reactionType,new HashSet<>()));
    }


    // Method
    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public Set<String> getTags() {
        return tags;
    }

    public OffsetDateTime getCreatedTime() {
        return this.createdTime;
    }

    public OffsetDateTime getEditedTime() {
        return editedTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<User> getReaction(ReactionType reactionType) {
        return new ArrayList<>(this.reactionMap.get(reactionType));
    }

    public void addTag(String tag){
        this.tags.add(tag);
    }

    public void updateTitle(String title) {
        this.title = title;
        this.editedTime = OffsetDateTime.now();
    }

    public void updateBody(String body) {
        this.body = body;
        this.editedTime = OffsetDateTime.now();
    }

    public boolean checkAuthor(Set<User> users){
        return users.contains(this.author);
    }

    public boolean containsAnyTags(Set<String> tags){
        return this.tags.stream().anyMatch(tags::contains);
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public boolean addReaction(User user, ReactionType reactionType){
        HashSet<User> reactionSet = this.reactionMap.get(reactionType);
        if (reactionSet.contains(user)) return false;
        reactionSet.add(user);
        return true;
    }

    public boolean removeReaction(User user, ReactionType reactionType){
        HashSet<User> reactionSet = this.reactionMap.get(reactionType);
        if (!reactionSet.contains(user)) return false;
        reactionSet.remove(user);
        return true;
    }
}
