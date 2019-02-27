/**
 * Created by Arthur on 3/25/2018.
 */
//Staff needs to split/handle requests from all staff member roles
public class Staff extends User{
    protected String fname, lname, role;
    protected int mgr_ssn;
    protected int ssn;
    protected int dept_no;

    public Staff(String username){
        super(username);
        //TODO query staff data
    }

    @Override
    public int parse(String command) {
        //TODO: fill in with actual parsing
        System.out.println("staff received command: "+ command);
        return 1;
    }
}
