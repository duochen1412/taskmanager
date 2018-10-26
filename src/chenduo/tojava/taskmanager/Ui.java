package chenduo.tojava.taskmanager;
import java.util.Scanner;
/**
 * To display message and read input
 * @author Chen Duo
 * @since 20.10.2018
 */
public class Ui {
    private Scanner in;
    public Ui() {
        in = new Scanner(System.in);
    }
    public static void showWelcomeMessage(){
        System.out.println("Welcome to TaskManager-Level 10!");
    }
    public String readUserCommand(){
        System.out.print("Your task?");
        return this.in.nextLine().trim();
    }

    public static void printError(String msg){
        System.out.println(msg);
    }
    public static void showToUser(String msg){
        System.out.println(msg);
    }
    public static void printWelcome(){
        System.out.println("Welcome to TaskManager-Level 10!");
    }

}
