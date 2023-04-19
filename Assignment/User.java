package Assignment;

/**
 * This class stores info relating to a user for AssignmentBST.
 * 
 * @see Post
 * @see AssignmentBST
 * @author Evian McKeown
 * @version 1.0
 */

public class User implements Comparable<User> {
    private String name;
    private String description;
    private AVLTree<Post> posts = new AVLTree<Post>();

    /**
     * This returns the posts AVLTree for the specific user.
     * 
     * @return posts AVLTree of post objects
     */
    public AVLTree<Post> getPosts() {
        return posts;
    }

    // public void setPosts(AVLTree<Post> posts) {
    // this.posts = posts;
    // }

    /**
     * Constructor for User.
     * 
     * @param name        Username
     * @param description User description
     */
    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Adds a post to the Posts AVLTree.
     * 
     * @param iPost post to add
     */
    public void addPost(Post iPost) {
        this.posts.insert(iPost);
    }

    /**
     * Deletes a given post, if its exists.
     * 
     * @param iPost
     * @return true when post is removed, false when not able to.
     */
    public boolean removePost(Post iPost) {
        if (this.posts.find(iPost) != null) {
            // true is returned when post is found and then deleted
            this.posts.delete(this.posts.find(iPost).data);
            return true;
        } else {
            // false is returned when post is not found (and thus not deleted)
            return false;
        }
    }

    /**
     * Constructor for user - name only version.
     * 
     * @param name Name of this user
     */
    public User(String name) {
        this.name = name;
        this.description = "";
    }

    /**
     * Gets name of user.
     * 
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Set new name for this user.
     * 
     * @param name New name to set to cur user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description of this user.
     * 
     * @return the description of this user
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description for this user.
     * 
     * @param description new Description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        // if (description == null) {
        // if (other.description != null)
        // return false;
        // } else if (!description.equals(other.description))
        // return false;
        return true;
    }

    @Override
    public int compareTo(User iUser) {
        return this.name.compareTo(iUser.name);
        // compares object based on username
    }

    /**
     * Overrides default toString
     * 
     * @return String Human friendly reprisentation of data
     */
    @Override
    public String toString() {
        return ("Name: '" + name + "' Description: '" + description + "'");
    }

}
