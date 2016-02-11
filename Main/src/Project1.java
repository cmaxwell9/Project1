/**
 * Created by MM12222 on 2/11/2016.
 * Project 1 should make use of topics covered during weeks one though three.
 *
 * Create a program that allows a user to add, remove, edit, and list to-do
 * items by presenting the user with a menu similar to the following:
 *
 * Please choose an option:
 * (1) Add a task.
 * (2) Remove a task.
 * (3) Update a task.
 * (4) List all tasks.
 * (0) Exit.
 *
 * If the user chooses to add a task, the program should prompt for a description
 * of the task and add it to the collection of tasks. If the user chooses to
 * remove a task, the program should ask the user which item to remove and remove
 * it from the collection of tasks. If the user chooses to update a task, the
 * program should ask which task will be updated and for a new description of the
 * task.  The program should loop until the user chooses to exit.
 *
 * The program should include methods dedicated to adding, removing, and updating
 * tasks.
 *
 * A runnable version of the program is attached. One way to run this program
 * is by downloading the file and running the following from a command prompt
 * or terminal:
 *
 * java -jar Project1.jar
 *
 * Be sure to commit your code and push it to GitHub.
 */
import java.util.ArrayList;

public class Project1 {

    static String add(ArrayList<String> TDL){
        System.out.println("Enter a description of the new task.");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();
        TDL.add(userInput);
        System.out.println("****** added ******");
        return "add";
    }
    static String remove(ArrayList<String> TDL){
        System.out.println("Enter the index of the task to remove.");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();

        try { int x = ((int) Double.parseDouble(userInput));}
        catch(NumberFormatException nfe){
            System.out.println(" invalid index ");
            return "remove";}
        try {  TDL.remove((int) Double.parseDouble(userInput)-1);}
        catch(IndexOutOfBoundsException IOOBE){
            System.out.println(" invalid index / out of bounds");
            return "remove";}


        System.out.println("****** removed ******");
        return "remove";
    }
    static String update(ArrayList<String> TDL){
        System.out.println("Enter the index of the task to update.");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String userInput;
        userInput = scanner.nextLine();
        try { int x = ((int) Double.parseDouble(userInput)-1);}
        catch(NumberFormatException nfe){
            System.out.println(" invalid index ");
            return "update";}
        int x = ((int) Double.parseDouble(userInput)-1);
        System.out.println("Enter the new description of the task.");
        java.util.Scanner scanner2 = new java.util.Scanner(System.in);
        userInput = scanner.nextLine();

        try {TDL.set(x,userInput);}
        catch(IndexOutOfBoundsException IOOBE){
            System.out.println(" invalid index / out of bounds");
            return "update";}
        System.out.println("****** updated ******");
        return "update";
    }
    static String list(ArrayList<String> TDL){
        for (int x = 0; x< 100; x++) {

            if (x < TDL.size()) {
                String pr = TDL.get(x);
                System.out.println((x + 1) + ". " + pr);}
            else
            {break;
            }
        }
        System.out.println("****** listed ******");
        return "list";
    }

    public static void main(String[] args) {
        ArrayList<String> TDL = new ArrayList<String>();
        String userInput;
        userInput = "6";
        while (((int) Double.parseDouble(userInput)) != 0) {
            System.out.println("Please choose an option:");
            System.out.println("(1) Add a task.");
            System.out.println("(2) Remove a task.");
            System.out.println("(3) Update a task.");
            System.out.println("(4) List a task.");
            System.out.println("(0) Exit.");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            userInput = scanner.nextLine();

            try { int x = ((int) Double.parseDouble(userInput));}
            catch(NumberFormatException nfe){userInput = "6";};

            switch ((int) Double.parseDouble(userInput)) {
                case 1:
                    add( TDL);
                    break;
                case 2:
                    remove(TDL);
                    break;
                case 3:
                    update(TDL);
                    break;
                case 4:
                    list(TDL);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Entry, Please try again...");
                    break;
            }
        }
    }
}

