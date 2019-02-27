/**
 * Created by arthu on 3/25/2018.
 */
public abstract class User
{
    private String username;

    public User(String username){
        this.username = username;
        System.out.println("Welcome "+username+"\n");
    }

    public abstract int parse(String command);

    public String toString(){
        return username;
    }
}
