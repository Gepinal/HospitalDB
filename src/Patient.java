import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Edward on 3/25/2018.
 */
public class Patient extends User {
    protected String fname,lname;
    protected int ssn;
    protected String address;
    protected int phoneNum;
    protected String insuranceNo;
    protected String birth_date;
    protected String diagnosis;
    protected int roomNum;
    protected String checkin_date;
    protected boolean checkout_status;
    Scanner in;

    public Patient(String username){
        super(username);
        //QUERY PATIENT DATA

        in = new Scanner(System.in);
        System.out.print(">");
        while(true){
            String input = in.nextLine();

            if(input.equals("exit"))
                break;

            if(parse(input) == 0)
                break;
            System.out.print(">");
        }
        System.out.println("Goodbye.");
    }

    @Override
    public int parse(String command) {
        String[] args = command.split(" ");
        if(args[0].equals("diagnosis"))
            return viewDiag(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("checkOut"))
            return checkOut(Arrays.copyOfRange(args, 1, args.length));
        System.out.println(this);
        return 1;
    }

    private int viewDiag(String[] args){
        if(args.length > 0) {
            System.out.println(this);
            return 1;
        }
        System.out.println("You have been diagnosed with: "+ diagnosis);
        return 1;
    }

    private int checkOut(String[] args){
        if(args.length != 1) {
            System.out.println(this);
            return 1;
        }
        System.out.println("Checking Out...");
        //TODO change checkout status of patient in SQL
        System.out.println("Done.");
        return 0;
    }

    @Override
    public String toString() {
        String help = "Commands Help";
        help += "\n=============\n";
        help += "\nhelp \t\t-usage: help\n\tprint this message";
        help += "\ndiagnosis \t- usage: diagnosis\n\t\tshow diagnosis";
        help += "\ncheckOut \t- usage: checkOut <SSN>\n\t\tcheck out";
        return help;
    }
}
