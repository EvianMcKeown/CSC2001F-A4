package Assignment;

public class User implements Comparable<User> {
    private String name;
    private String description;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

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
        //if (description == null) {
        //    if (other.description != null)
        //        return false;
        //} else if (!description.equals(other.description))
        //    return false;
        return true;
    }

    @Override
    public int compareTo(User iUser) {
        return this.name.compareTo(iUser.name);
        // compares object based on username
    }

}
