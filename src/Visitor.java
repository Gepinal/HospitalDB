import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by George-Edward on 3/25/2018.
 */
public class Visitor extends User {
    protected String fname, lname;
    protected int phoneNum;
    protected int visitorNum;
    protected int patient_ssn;
    protected String checkin_date;
    protected boolean checkout_status;
    public static final String VISIT_HOURS = "\tNow O'Clock";
    Scanner in;


    public Visitor(String username){
        super(username);
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
    }

    @Override
    public int parse(String command) {
        String[] args = command.split(" ");
        if(args[0].equals("checkHours"))
            return checkHours(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("checkIn"))
            return checkIn(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("checkOut"))
            return checkOut(Arrays.copyOfRange(args, 1, args.length));

        System.out.println(this);
        return 1;
    }

    private int checkHours(String[] args){
        if(args.length > 0) {
            System.out.println(this);
            return 1;
        }
        System.out.println("Visiting Hours: "+ VISIT_HOURS);
        return 0;
    }

    private int checkIn(String[] args){
        if(args.length != 5) {
            System.out.println(this);
            return 1;
        }
        System.out.println("Checking In...");
        //TODO add visitor to system and assign a unique no
        //Also add check to see if information is valid, check if patient exists first
        System.out.println("Visitor Num: "+visitorNum);
        return 0;
    }

    private int checkOut(String[] args){
        if(args.length != 1) {
            System.out.println(this);
            return 1;
        }
        System.out.println("Checking Out...");
        //TODO checkout patient from system
        //If visitor number is invalid, return code 1 and explain failure

        return 0;
    }

    @Override
    public String toString() {
        String help = "Commands Help";
        help += "\n=============\n";
        help += "\nhelp \t\t-usage: help\n\tprint this message";
        help += "\ncheckHours \t- usage: checkhours\n\t\tshow visiting hours";
        help += "\ncheckIn \t- usage: checkIn <firstName> <lastName> <phoneNum> <patientFirst> <patientLast>" +
                "\n\t\tcheck in as a visitor";
        help += "\ncheckOut \t- usage: checkOut <visitorNo>\n\t\tcheck out";
        return help;
    }
}
