import java.util.Arrays;
import java.util.Scanner;

public class Doctor extends Staff{
    Scanner in;
    public Doctor(String username){
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
        System.out.println("Logged out.");
    }

    @Override
    public int parse(String command) {
        String[] args = command.split(" ");
        if(args[0].equals("patInfo"))
            return patInfo(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("prescribe"))
            return prescribe(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("diagnose"))
            return diagnose(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("transPat"))
            return transPat(Arrays.copyOfRange(args, 1, args.length));
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

    private int prescribe(String[] args){
        if (args.length != 2){
            System.out.println(this);
            return 1;
        }
        //Todo query patient name from arg[1] and add it after " to "
        //Todo query medicine from rx number in arg[0] and add after "Prescribing "
        System.out.println("Prescribing "+ " to...");
        //Todo change patient percription in database
        System.out.println("Done");
        return 1;
    }

    private int diagnose(String[] args){
        if (args.length != 2){
            System.out.println(this);
            return 1;
        }
        //Todo query patient name from args[1] and add it after "Diagnosing "
        System.out.println("Diagnosing "+" with "+args[0]);
        //Todo change patient diagnosis in database
        System.out.println("Done.");
        return 1;
    }

    private int transPat(String[] args){
        if (args.length != 2){
            System.out.println(this);
            return 1;
        }
        //Todo query patient name from args[1] and add it after "Diagnosing "
        System.out.println("Moving " + " to " +args[0]);
        //Todo change patient diagnosis in database
        System.out.println("Done.");
        return 1;
    }

    public String toString() {
        String help = "Commands Help";
        help += "\n=============\n";
        help += "\nhelp \t\t-usage: help\n\tprint this message";
        help += "\npatInfo \t- usage: patInfo <patientSSN>\n\t\tPrint a summary of a patient";
        help += "\nprescribe \t- usage: prescribe <RX_no> <patientSSN>\n\t\tPrescribe a patient with a medicine";
        help += "\ndiagnose \t- usage: diagnose <diagnosis> <patientSSN>\n\t\tAdd a diagnosis for a patient";
        help += "\ntransPat \t- usage: transPat <newRoom> <patientSSN>\n\t\tRequest a room change";
        return help;
    }


}
