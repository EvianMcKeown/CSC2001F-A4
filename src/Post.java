package src;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * This class stores info relating to a post for User.
 * 
 * @see User
 * @author Evian McKeown
 * @version 1.0
 */

public class Post implements Comparable<Post> {
    private String postName;
    private Integer postLikes;
    private String postDescription;
    private LocalDateTime postDateTime;
    final static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Constructor for Post
     * 
     * @param iName        Name of Post
     * @param iLikes       Number of Likes
     * @param iDescription Description of Post
     */
    public Post(String iName, Integer iLikes, String iDescription) {
        this.postName = iName;
        this.postLikes = iLikes;
        this.postDateTime = LocalDateTime.now();
        this.postDescription = iDescription;
    }

    /**
     * Compares post; needed to implement Comparable<Post>
     * 
     * @param iPost Post to compare to
     * @return int
     */
    @Override
    public int compareTo(Post iPost) {
        return postDateTime.compareTo(iPost.postDateTime);
        // compare by date and time
    }

    /**
     * Returns post Likes
     * 
     * @return Integer
     */
    public Integer getPostLikes() {
        return this.postLikes;
    }

    /**
     * Sets Posts Likes
     * 
     * @param postLikes amount of likes
     */
    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    /**
     * gets Post DateTime (Identifier)
     * 
     * @return LocalDateTime
     */
    public LocalDateTime getPostDateTime() {
        return postDateTime;
    }

    /**
     * sets Post DateTime (Identifier)
     * 
     * @param postDateTime date and time of post
     */
    public void setPostDateTime(LocalDateTime postDateTime) {
        this.postDateTime = postDateTime;
    }

    /**
     * gets Post Name
     * 
     * @return String
     */
    public String getPostName() {
        return postName;
    }

    /**
     * sets Post Name
     * 
     * @param postName name of post
     */
    public void setPostName(String postName) {
        this.postName = postName;
    }

    /**
     * gets Post Description
     * 
     * @return String
     */
    public String getPostDescription() {
        return postDescription;
    }

    /**
     * sets Post Description
     * 
     * @param postDescription description of post
     */
    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return ("Name: '" + postName + "' Likes: " + postLikes + " Description: '" + postDescription + "' Date: "
                + postDateTime.format(dateFormat));
    }
}
