package isujam080720;
import java.util.Scanner;

class User {
    User(String accNumber, String accName, String userNID, int type){
        this.accNumber = accNumber;
        this.accName = accName;
        this.userNID = userNID;
        this.type = type;
    }
    String accNumber, accName, userNID;
    int type;
}

public class ISuJaM080720 {  
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int status;
        String name, nid;
        int type;
        

        System.out.println("Enter your name:");
        name = scan.nextLine();
        System.out.println("Enter your account type:\n type 1 for Current \n type 2 for savings");
        type = scan.nextInt();
        System.out.println("Enter your NID:");
        nid = scan.nextLine();
        nid = scan.nextLine();

        String number = name+nid+type;
        User user = new User(number, name, nid, type);

        System.out.println("Welcome your account has been created");
        System.out.println("Name "+ user.accName);
        System.out.println("Type "+ user.type);
        System.out.println("NID "+ user.userNID);
        System.out.println("Account " +user.accNumber);
    }
    
}
