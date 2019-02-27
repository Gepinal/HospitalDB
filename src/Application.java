/**
 * Main Application Class
 * @author: AJ Nagashima
 */
import javax.print.DocFlavor;
import java.util.Scanner;

public class Application {
    Scanner in = new Scanner(System.in);

    static final String LOGIN =
            "*********************\n" +
            "****Kotd Hospital****\n" +
            "*********************\n";
    static final String HELP = "<<add>";
    static final String INVALID_COMMAND = "Invalid command.";
    static final String USER_PROMPT = "Enter Username: ";
    static final String PASSWORD_PROMPT = "Enter Password: ";
    static final String BAD_USER = "!!!BAD USERNAME!!!";
    static final String BAD_PASSWD = "!!!BAD PASSWORD!!!";
    static final String WELCOME = "welcome back ";

    private User user;
    public Application(){
        System.out.println(LOGIN);

        System.out.print(">");
        String command = in.nextLine();
        while(!command.equalsIgnoreCase("login")){
            if(command.equalsIgnoreCase("help"))
                System.out.println(HELP);
            else{
                System.out.println(INVALID_COMMAND);
                System.out.println("Please type login, or help for more options.");
            }
            System.out.print(">");
            command = in.nextLine();
        }
        System.out.print(USER_PROMPT);
        String username = in.nextLine();
        System.out.print(PASSWORD_PROMPT);
        String password = in.nextLine();
        user = validUser(username, password);
        while(user == null){
            System.out.println(BAD_USER);
            System.out.print(USER_PROMPT);
            username = in.nextLine();
            System.out.println(BAD_PASSWD);
            System.out.print(PASSWORD_PROMPT);
            password = in.nextLine();
            user = validUser(username, password);
        }
    }

    private User validUser(String username, String password){
        //SQL QUERY FOR USER DATA
        if(username.equals("clerk"))
            return new Clerk(username);
        if(username.equals("hr"))
            return new Hr(username);
        if(username.equals("nurse"))
            return new Nurse(username);
        if(username.equals("doctor"))
            return new Doctor(username);
        if(username.equals("visitor"))
            return new Visitor(username);
        if(username.equals("patient"))
            return new Patient(username);
        return null;
    }

    public static void main(String args[]){
        new Application();
    }

}
