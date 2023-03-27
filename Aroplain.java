import java.util.Scanner;

public class Aroplain {


    private String airline_name, origin, destination,airlineUnique_id;
    private int seating_availability, fare;

    Scanner constant = new Scanner(System.in);


    public void setairline_id(String airlineUnique_id)
    {
        this.airlineUnique_id = airlineUnique_id;
    }
    public String getairline_id()
    {
        return airlineUnique_id;
    }


    public void setairline_name(String airline_name)
    {
        this.airline_name = airline_name;
    }
    public String getairline_name()
    {
        return airline_name;
    }


    public void setorigin(String origin)
    {

        this.origin = origin;
    }
    public String getorigin()
    {
        return origin;
    }


    public void setdestination(String destination)
    {
        this.destination = destination;
    }
    public String getdestination()
    {
        return destination;
    }


    public void setseating_availability(int seating_availability)
    {
        this.seating_availability = seating_availability;
    }
    public int getseating_availability()
    {
        return seating_availability;
    }


    public void setfare(int fare)
    {
        this.fare = fare;
    }
    public int getfare()
    {
        return fare;
    }
    public String toString()
    {
        return airline_name+" "+airlineUnique_id+" "+origin+" "+destination+" "+seating_availability+" "+fare;
    }
    public static void checkingCredentials(String admin_name,String admin_password)
    {

        Aroplain airline_newobject=new Aroplain();

        if(admin_name.equals("govindaraj") && admin_password.equals("25@PASSWORD" ))
        {
            System.out.println("\nYOU HAVE SUCCESSFULLY LOGGED IN..\n");

        }
        else
        {
            System.out.println("\nPLEASE CHECK YOUR CREDENTIALS");
            airline_newobject.LoginDetails();
        }
    }
    public void LoginDetails() {


        System.out.println("      WELCOME TO EURO AIRLINES        \n");
        System.out.println("TO LOG IN,GIVE THE NECESSARY DETAILS BELOW\n");

        System.out.print("\nENTER THE ADMIN NAME: ");
        String admin_name = constant.next();

        System.out.print("\nENTER THE ADMIN PASSWORD: ");
        String admin_password = constant.next();

        checkingCredentials(admin_name,admin_password);
    }
    public void toLogOut() {



        System.out.println("Logged out successfully.");

    }
}
