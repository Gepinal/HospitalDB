import java.util.Arrays;
import java.util.Scanner;

public class Hr extends Staff{
    Scanner in;
    public Hr(String username){
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
        System.out.println("Logged Out");
    }

    public int parse(String command) {
        String[] args = command.split(" ");
        if(args[0].equals("empInfo"))
            return empInfo(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("delEmp"))
            return delEmp(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("addEmp"))
            return addEmp(Arrays.copyOfRange(args, 1, args.length));
        if(args[0].equals("setPay"))
            return setPay(Arrays.copyOfRange(args, 1, args.length));
        System.out.println(this);
        return 1;
    }

    private int empInfo(String[] args){
        if (args.length != 1){
            System.out.println(this);
            return 1;
        }
        //Todo query doctor from arg[0] and print a summary
        return 1;
    }

    private int delEmp(String[] args){
        if (args.length != 1){
            System.out.println(this);
            return 1;
        }

        //TODO query employee from arg[0] and print name in middle of string
        System.out.println("Deleting "+"...");
        //Todo cascade delete all relevant employee data
        //This should include everytime this employee ssn is in the managerssn attrib
        System.out.println("Done.");
        return 1;
    }

    private int addEmp(String[] args){
        if (args.length != 7){
            System.out.println(this);
            return 1;
        }
        String empFirst = args[0];
        String empLast = args[1];
        int empSSN = Integer.parseInt(args[2]);
        int empDept = Integer.parseInt(args[3]);
        String empRole = args[4];
        int empManager = Integer.parseInt(args[5]);

        System.out.println("Creating new patient: "+ empFirst+" "+empLast);
        //Todo create new patient with information provided
        System.out.println("Done.");
        return 1;
    }

    private int setPay(String[] args){
        if (args.length != 3){
            System.out.println(this);
            return 1;
        }

        int salary = Integer.parseInt(args[1]);
        String cycle = args[2];
        //Todo query employee data (name and pay rate) from ssn stored in args[0]
        System.out.println("Employee :" +
                "\n\tOld Pay: "+
                "\n\tNew Pay: ");

        //Todo change pay rate
        System.out.println("Done.");

        return 1;
    }

    public String toString() {
        String help = "Commands Help";
        help += "\n=============\n";
        help += "\nhelp \t\t-usage: help\n\tprint this message";
        help += "\nempInfo \t- usage: empInfo <employeeSSN>\n\t\tPrint a summary of an employee";
        help += "\ndelEmp   \t- usage: delEmp <employeeSSN>\n\t\tDelete an Employee";
        help += "\naddEmp \t- usage: addEmp <fName> <lName> <empSSN> <deptNo> <empRole> <managerSsn> \n\t\tAdd an employee";
        help += "\nsetPay \t- usage: setPay <empSSN> <payAmount> <payCycle>\n\t\tSet an employee salary";
        return help;
    }
}
