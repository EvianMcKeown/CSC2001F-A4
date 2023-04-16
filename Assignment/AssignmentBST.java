package Assignment;

import java.util.Scanner;

public class AssignmentBST {
    public static void main(String args[]) {
        dialog1();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        //TreeSet<User> Users = new TreeSet<User>();
        AVLTree<User> Users = new AVLTree<User>();

        switch (s) {
            case "1": // find the profile description for a given account

                break;
            case "2": // list all accounts

                break;
            case "3": // create an account
                String accName = "";
                String accDescription = "";

                // #Check if name is unique
                User newAcc = new User(accName, accDescription);
                boolean accCreated = false;
                while (Users.find(newAcc).data != null || (accName.equals(""))) {
                    System.out.print("Provide a unique account name: ");
                    accName = in.nextLine();
                    newAcc.setName(accName);
                    if (Users.find(newAcc) != null) {
                        System.out.println("This account name is already taken. Please choose a different name.");
                    } else if (!accName.equals("")) {
                        accCreated = true;
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
                
                break;
            case "4": // delete an account
                    System.out.print("Enter the name of the account you would like to delete: ");
                    String delAccName = in.nextLine();
                    User userToDelete = new User(delAccName);
                    if (Users.find(userToDelete) != null) {
                        Users.delete(Users.find(userToDelete).getData());
                        // Gets User and passes it to delete method
                    }
                break;
            case "5": // display all posts for a single account

                break;
            case "6": // add a new post for a single account

                break;
            case "7": // load a file of actions from disk and process this

                break;
            case "8": // quit

                break;
            default:
                break;
        }

        // remember to close scanner
        in.close();
    }

    private static void dialog1() {
        System.out.println("Choose an action from the menu" + System.lineSeparator()
                + "1. Find the profile description for a given account" + System.lineSeparator()
                + "2. List all accounts" + System.lineSeparator() + "3. Create an account" + System.lineSeparator()
                + "4. Delete an account" + System.lineSeparator() + "5. Display all posts for a single account"
                + System.lineSeparator() + "6. Add a new post for a single account" + System.lineSeparator()
                + "7. Load a file of actions from disk and process this" + System.lineSeparator() + "8. Quit");
        System.out.print("Enter your choice: ");
    }
}
