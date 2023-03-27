
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

    public class AirlineMain {

        public static Connection createConnection() {
            Connection connection=null;
            try {
                String userName = "root";
                String passWord = "root";

                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline",userName,passWord);
            }
            catch(Exception obj) {
                System.out.println(obj);
            }
            return connection;
        }
        public static void main(String[] args)throws SQLException {

            DataBaseConnetion object = new DataBaseConnetion();

            Connection connectionData = createConnection() ;
            Scanner scan=new Scanner(System.in);

            Aroplain airline_newobject=new Aroplain();

            airline_newobject.LoginDetails();

            System.out.println("\n..........| WELCOME TO EURO AIRLINES |..........\n");

            System.out.println(" * TO ADD AN AIRLINE      --> PRESS 1");
            System.out.println(" * TO DISPLAY THE AIRLINE --> PRESS 2");
            System.out.println(" * TO SEARCH AN AIRLINE   --> PRESS 3");
            System.out.println(" * TO DELETE AN AIRLINE   --> PRESS 4");
            System.out.println(" * TO UPDATE AN AIRLINE   --> PRESS 5");
            System.out.println(" * TO LOGOUT              --> PRESS 6");

            byte adminChoice;
            do {
                adminChoice = scan.nextByte();

                switch(adminChoice) {
                    case 1:
                        object.toaddAirline(connectionData);
                        break;
                    case 2:
                        object.todisplayAirline(connectionData);
                        break;
                    case 3:
                        object.tosearchAirline(connectionData);
                        break;
                    case 4:
                        object.todeleteAirline(connectionData);
                        break;
                    case 5:
                        object.toupdateAirline(connectionData);
                        break;
                    case 6:
                        airline_newobject.toLogOut();
                    default :
                        System.out.println("check the option");

                }
            }while(adminChoice!=6);

            scan.close();
            connectionData.close();
        }
    }
