import java.util.Arrays;
import java.util.Scanner;

public class Clerk extends Staff{
    Scanner in;
    public Clerk(String username){
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
        System.out.println("Logged out");
    }

    public int parse(String command) {
        String[] args = command.split(" ");
        if(args[0].equals("patInfo"))
            return patInfo(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("delpat"))
            return delPat(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("addPat"))
            return addPat(Arrays.copyOfRange(args, 1, args.length));
        System.out.println(this);
        return 1;
    }

    private int patInfo(String[] args){
        if (args.length != 1){
            System.out.println(this);
            return 1;
        }
        //Todo query patient from arg[0] and print a summary
        return 1;
    }

    private int delPat(String[] args){
        if (args.length != 1){
            System.out.println(this);
            return 1;
        }

        //TODO query patient from arg[0] and print name in middle of string
        System.out.println("Deleting "+"...");
        //Todo cascade delete all relevant patient data
        System.out.println("Done.");
        return 1;
    }

    private int addPat(String[] args){
        if (args.length != 7){
            System.out.println(this);
            return 1;
        }
        String patientFirst = args[0];
        String patientLast = args[1];
        int patientSSN = Integer.parseInt(args[2]);
        String patientAddr = args[3];
        int patientPhone = Integer.parseInt(args[4]);
        String patientInsurance = args[5];
        String patientBirth = args[6];

        System.out.println("Creating new patient: "+ patientFirst+" "+patientLast);
        //Todo create new patient with information provided
        System.out.println("Done.");
        return 1;
    }

    public String toString() {
        String help = "Commands Help";
        help += "\n=============\n";
        help += "\nhelp \t\t-usage: help\n\tprint this message";
        help += "\npatInfo  \t- usage: patInfo <patientSSN>\n\t\tPrint a summary of a patient";
        help += "\ndelPat   \t- usage: delPat <patientSSN>\n\t\tDelete a patient";
        help += "\naddPat   \t- usage: addPat <fName> <lName> <patientSSN> <Address> <phone no> <insuranceNo> <bdate>\n\t\tAdd a patient";
        return help;
    }
}
