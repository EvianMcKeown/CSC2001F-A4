package Assignment;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Post implements Comparable<Post> {
    private String postName;
    private Integer postLikes;
    private String postDescription;
    private LocalDateTime postDateTime;
    final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Post(String iName, Integer iLikes, String iDescription) {
        this.postName = iName;
        this.postLikes = iLikes;
        this.postDateTime = LocalDateTime.now();
        this.postDescription = iDescription;
    }

    @Override
    public int compareTo(Post iPost) {
        return postDateTime.compareTo(iPost.postDateTime);
        // compare by date and time
    }

    public Integer getPostLikes() {
        return this.postLikes;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    @Override
    public String toString() {
        return ("Name: '" + postName + "' Likes: " + postLikes + " Description: '" + postDescription + "' Date: "
                + postDateTime.format(dateFormat));
    }
}
