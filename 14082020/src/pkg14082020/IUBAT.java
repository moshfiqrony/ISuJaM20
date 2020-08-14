package pkg14082020;

class User{
    private String name, id;
    
    public void setUser(String name, String id){
           this.name = name;
           this.id = id;
    }
    
    public void getUser(){
        System.out.println("your name is " + name);
        System.out.println("your id is " + id);

    }
}

public class IUBAT {

    public static void main(String[] args) {
        User obj = new User();
        obj.setUser("Rony", "15203012");
        obj.getUser();
    } 
    
}
