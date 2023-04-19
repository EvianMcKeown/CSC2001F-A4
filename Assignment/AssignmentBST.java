package Assignment;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AssignmentBST {
    public static void main(String args[]) {
        /**
         * Main method, where core functionality is included.
         * 
         * Used 'TreeSet<User> Users = new TreeSet<User>();' initially
         * But this did not allow comparing by the user name exclusively, so custom
         * AVLtree implimentation was required.
         * 
         * @param args
         */
        AVLTree<User> Users = new AVLTree<User>();

        Scanner in = new Scanner(System.in);
        // #DONE Make Decision Loop
        boolean active = true;

        while (active) {
            /** prints main menu, then takes string input */
            dialogMenu();
            String s = in.nextLine();
            switch (s) {
                case "1":
                    /** find the profile description for a given account */
                    System.out.print(System.lineSeparator());
                    System.out.print("Provide the account name: ");
                    String findAccName = in.nextLine();
                    User userToFindDescription = new User(findAccName);

                    if (Users.find(userToFindDescription) != null) {
                        System.out.println("User '" + findAccName + "' has description '"
                                + Users.find(userToFindDescription).data.getDescription() + "'");
                    } else {
                        System.out.println("Specified user does not exist.");
                    }
                    System.out.print(System.lineSeparator());
                    break;
                case "2":
                    /** list all accounts */
                    dialogOrder();
                    String order = in.nextLine();
                    System.out.print(System.lineSeparator());

                    switch (order) {
                        case "1":
                            Users.inOrder();
                            // System.out.print(System.lineSeparator());
                            break;
                        case "2":
                            Users.preOrder();
                            break;
                        case "3":
                            Users.postOrder();
                            break;
                        case "4":
                            Users.levelOrder();
                            break;
                        default:
                            System.out.println(
                                    "Not a valid selection. Defaulting to in-order: " + System.lineSeparator());
                            break;
                    }
                    System.out.print(System.lineSeparator());
                    break;
                case "3":
                    /** create an account */
                    String accName = "";
                    String accDescription = "";

                    /** Check if name is unique */
                    User newAcc = new User(accName, accDescription);
                    boolean accCreated = false;
                    while (Users.find(newAcc) != null || (accName.equals("")) || !isValidName(accName)) {
                        System.out.print(System.lineSeparator() + "Provide a unique account name: ");
                        accName = in.nextLine();
                        if (!isValidName(accName)) {
                            System.out.println("This account name is not valid. Please choose a different name.");
                        } else {
                            newAcc.setName(accName);
                            if (Users.find(newAcc) != null) {
                                System.out
                                        .println("This account name is already taken. Please choose a different name.");
                            } else if (!accName.equals("")) {
                                accCreated = true;
                            }
                        }
                        // #DEBUG System.out.println("AccName is '" + accName + "'");
                    }

                    System.out.print("Provide a description for your account: ");
                    accDescription = in.nextLine();
                    newAcc.setDescription(accDescription);

                    Users.insert(newAcc);
                    // #DEBUG System.out.println(Users.find(newAcc) != null);
                    if (accCreated) {
                        System.out.println("User '" + accName + "' has been created.");
                    }
                    System.out.print(System.lineSeparator());
                    break;
                case "4": // delete an account
                    System.out.print("Provide the name of the account you would like to delete: ");
                    String delAccName = in.nextLine();
                    User userToDelete = new User(delAccName);

                    // #DONE Test Account Deletion
                    if (Users.find(userToDelete) != null) {
                        /* Gets User and passes it to delete method */
                        Users.delete(Users.find(userToDelete).getData());

                        System.out.println(
                                "User '" + userToDelete.getName() + "' has been deleted." + System.lineSeparator());
                    } else {
                        System.out.println("Specified user does not exist.");
                    }
                    break;
                case "5": // display all posts for a single account
                    System.out.print(System.lineSeparator() + "Provide the account name: ");
                    String accountToFindPosts = in.nextLine();
                    User tempUser = new User(accountToFindPosts);
                    if (Users.find(tempUser) != null) {
                        AVLTree<Post> tempPosts = Users.find(tempUser).data.getPosts();
                        dialogOrder();
                        switch (in.nextLine()) {
                            case "1":
                                System.out.println();
                                tempPosts.inOrder();
                                System.out.println();
                                break;
                            case "2":
                                System.out.println();
                                tempPosts.preOrder();
                                System.out.println();
                                break;
                            case "3":
                                System.out.println();
                                tempPosts.postOrder();
                                System.out.println();
                                break;
                            case "4":
                                System.out.println();
                                tempPosts.levelOrder();
                                System.out.println();
                                break;
                            default:
                                System.out.println(
                                        "Not a valid selection. Defaulting to in-order: " + System.lineSeparator());
                                tempPosts.inOrder();
                                break;
                        }
                    } else {
                        System.out.println("Specified user does not exist." + System.lineSeparator());
                    }
                    break;
                case "6": // add a new post for a single account
                    System.out.print(System.lineSeparator() + "Provide the account name: ");
                    String accountToAddPost = in.nextLine();

                    User userAdd = new User(accountToAddPost);
                    if (Users.find(userAdd) != null) {
                        System.out.print("Provide the post name: ");
                        String postName = in.nextLine();

                        if (!postName.equals("") && isValidName(postName)) {
                            /**
                             * If PostName is not empty and has only legal characters, add post to post
                             * AVLtree
                             */
                            Integer postLikes = 0;
                            /** If like string cannot be parsed into int, default to 0 likes */
                            try {
                                System.out.print("Provide number of likes: ");
                                postLikes = Integer.parseInt(in.nextLine());
                            } catch (Exception e) {
                                System.out.println("Defaulting to 0 likes.");
                            }
                            System.out.print("Provide description: ");
                            String postDescription = in.nextLine();
                            Post postAdd = new Post(postName, postLikes, postDescription);
                            Users.find(userAdd).data.addPost(postAdd);
                            System.out.println(
                                    "'" + postName + "' with description '" + postDescription
                                            + "' and " + postLikes + " likes has been added to '" + accountToAddPost
                                            + "'."
                                            + System.lineSeparator());
                        } else if (!postName.equals("") && !isValidName(postName)) {
                            System.out.println("Post name can not contain any spaces." + System.lineSeparator());
                        } else {
                            System.out.println("Post name is required." + System.lineSeparator());
                        }
                    } else {
                        System.out.println("Specified user does not exist." + System.lineSeparator());
                    }
                    break;
                case "7": // load a file of actions from disk and process this
                    System.out.print(System.lineSeparator() + "Provide the filename: ");
                    String fileName = in.nextLine();
                    try {
                        File inputFile = new File(fileName);
                        Scanner fileReader = new Scanner(inputFile);
                        while (fileReader.hasNextLine()) {
                            String curLine = fileReader.nextLine();
                            String[] curLineArr = curLine.split(" ");
                            switch (curLineArr[0]) {
                                case "Add":
                                    try {
                                        String tempUNpost = curLineArr[1];
                                        String tempPostName = curLineArr[2];
                                        Integer tempLikeCount = 0;
                                        try {
                                            tempLikeCount = Integer.parseInt(curLineArr[3]);
                                        } catch (Exception e) {
                                            /** like count not a number - defaults to 0 */
                                        }
                                        String tempPostDescrip = "";
                                        for (int i = 4; i < curLineArr.length; i++) {
                                            if (i == curLineArr.length - 1) {
                                                tempPostDescrip += curLineArr[i];
                                            } else {
                                                tempPostDescrip += curLineArr[i] + " ";
                                            }
                                        }
                                        User tempUserPost = new User(tempUNpost);
                                        BinaryTreeNode<User> tempUserNode = Users.find(tempUserPost);
                                        if (tempUserNode != null) {
                                            if (isValidName(tempUNpost) && !tempUNpost.equals("")) {
                                                Post tempPost = new Post(tempPostName, tempLikeCount, tempPostDescrip);
                                                Users.find(tempUserPost).data.addPost(tempPost);
                                            } else {
                                                /** Post name is not valid */
                                                System.out.println("Post name '" + tempUNpost + "' is not valid.");
                                            }
                                        } else {
                                            System.out.println("User '" + tempUNpost + "' does not exist.");
                                        }
                                    } catch (Exception e) {
                                        /** not enough paramaters */
                                        System.out.println("Warning: Post format is incorrect.");
                                    }
                                    break;
                                case "Create":
                                    String tempUserName = curLineArr[1];
                                    String tempUserDescrip = "";
                                    for (int i = 2; i < curLineArr.length; i++) {
                                        if (i == curLineArr.length - 1) {
                                            tempUserDescrip += curLineArr[i];
                                        } else {
                                            tempUserDescrip += curLineArr[i] + " ";
                                        }
                                    }
                                    if ((!tempUserName.equals("")) && (isValidName(tempUserName))) {
                                        User tempUserFile = new User(tempUserName, tempUserDescrip);
                                        if (Users.find(tempUserFile) == null) {
                                            Users.insert(tempUserFile);
                                        } else {
                                            /** reports if user already exists */
                                            System.out.println("User '" + tempUserName + "' already exists."
                                                    + System.lineSeparator());
                                        }
                                    } else {
                                        /** reports if username is not valid */
                                        System.out.println("'" + tempUserName + "' is not a valid user name.");
                                    }
                                    break;
                                // #TODO: Add delete and remove
                                default:
                                    break;
                            }
                        }
                        System.out.println("File loading complete." + System.lineSeparator());
                        fileReader.close();
                    } catch (FileNotFoundException exception) {
                        // TODO: handle exception
                        System.out.println("File '" + fileName + "' not found." + System.lineSeparator()
                                + "< Remember to include the file extension >" + System.lineSeparator());
                    }
                    break;
                case "8": // quit
                    active = false;
                    System.out.println(System.lineSeparator() + "Exiting...");
                    break;
                default:
                    System.out.println("Not a valid selection." + System.lineSeparator());
                    break;
            }
        }
        // remember to close scanner
        in.close();
    }

    private static void dialogMenu() {
        System.out.println("Choose an action from the menu" + System.lineSeparator()
                + "1. Find the profile description for a given account" + System.lineSeparator()
                + "2. List all accounts" + System.lineSeparator() + "3. Create an account" + System.lineSeparator()
                + "4. Delete an account" + System.lineSeparator() + "5. Display all posts for a single account"
                + System.lineSeparator() + "6. Add a new post for a single account" + System.lineSeparator()
                + "7. Load a file of actions from disk and process this" + System.lineSeparator() + "8. Quit");
        System.out.print("Enter your choice: ");
    }

    private static void dialogOrder() {
        System.out.print(System.lineSeparator() + "Traverse:" + System.lineSeparator() + "1: In-order"
                + System.lineSeparator() + "2: Pre-order" + System.lineSeparator() + "3: Post-order"
                + System.lineSeparator() + "4: Level-order" + System.lineSeparator() + "Enter your choice: ");
    }

    private static Boolean isValidName(String iName) {
        char[] iChar = iName.toCharArray();

        for (int i = 0; i < iChar.length; i++) {
            Integer ascii = (int) iChar[i];
            if (ascii < 33) {
                return false;
            } else if ((ascii < 161) && (ascii > 126)) {
                return false;
            } else if (ascii == 173) {
                return false;
            }
            // return false;
        }
        return true;
    }
}
