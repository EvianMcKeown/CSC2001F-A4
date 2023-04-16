package Assignment;

import java.util.Scanner;
import java.util.TreeSet;

public class AssignmentBST {
    public static void main(String args[]) {
        dialog1();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        TreeSet<User> Users = new TreeSet<User>();

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
                while (Users.contains(newAcc) || (accName.equals(""))) {
                    System.out.print("Provide an unique account name: ");
                    accName = in.nextLine();
                    if (Users.contains(newAcc)) {
                        System.out.println("This account name is already taken. Please choose a different name.");
                    }
                    // #DEBUG System.out.println("AccName is '" + accName + "'");
                }

                System.out.print("Provide a description for your account: ");
                accDescription = in.nextLine();

                Users.add(newAcc);
                // #DEBUG System.out.println(Users.contains(newAcc));
                break;
            case "4": // delete an account
                    System.out.print("What account would you like to delete");
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
