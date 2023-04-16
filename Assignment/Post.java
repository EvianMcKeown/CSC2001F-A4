package Assignment;

import java.util.Date;

public class Post implements Comparable<Post> {
    private String postName;
    private Integer postLikes;
    private Date postDateTime;

    @Override
    public int compareTo(Post iPost) {
        return postName.compareTo(iPost.postName);
        // compare by name
    }

    public Integer getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(Integer postLikes) {
        this.postLikes = postLikes;
    }

    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }
}
