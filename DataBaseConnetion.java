import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseConnetion {

        public static final Scanner scanner_object=new Scanner(System.in);


        public void toaddAirline( Connection connectionData) throws NullPointerException, SQLException {

            PreparedStatement add_state = connectionData.prepareStatement("INSERT INTO AIRLINE_DETAILS VALUES(?,?,?,?,?,?)");
            System.out.println("ENTER THE AIRLINE_ID: ");
            add_state.setString(1,scanner_object.next());
            System.out.println("ENTER THE AIRLINE_NAME: ");
            add_state.setString(2,scanner_object.next());
            System.out.println("ENTER THE AIRLINE_ORIGIN: ");
            add_state.setString(3,scanner_object.next());
            System.out.println("ENTER THE AIRLINE_DESTINATION: ");
            add_state.setString(4,scanner_object.next());
            System.out.println("ENTER THE AIRLINE_SEATING_CAPACITY: ");
            add_state.setInt(5,scanner_object.nextInt());
            System.out.println("ENTER THE AIRLINE_FARE: ");

            add_state.setInt(6,scanner_object.nextInt());

            int airline_add = add_state.executeUpdate();
            System.out.println(airline_add +" added successfully");

        }


        public void todisplayAirline(Connection connectionData) throws NullPointerException,SQLException {
            Statement newState=connectionData.createStatement();
            ResultSet save_result=newState.executeQuery("SELECT * FROM  AIRLINE_DETAILS");

            while(save_result.next())
            {
                System.out.println(save_result.getString(1)+"  "+save_result.getString(2)+"  "+save_result.getString(3)+"  "+save_result.getString(4)+"  "+save_result.getInt(5)+"  "+save_result.getInt(6));

            }
        }

        public void tosearchAirline(Connection connectionData) throws NullPointerException,SQLException {
            PreparedStatement search_state = connectionData.prepareStatement("SELECT * FROM AIRLINE_DETAILS WHERE Airline_id=?");
            System.out.println("Enter the Airline_id: ");
            String display_id =scanner_object.next();
            search_state.setString(1, display_id);
            ResultSet record_result=search_state.executeQuery();
            while(record_result.next()) {
                System.out.println(record_result.getString(1)+" "+record_result.getString(2)+" "+record_result.getString(3)+" "+record_result.getString(4)+" "+record_result.getInt(5)+" "+record_result.getInt(6));
            }
        }


        public void todeleteAirline(Connection connectionData) throws NullPointerException,SQLException {
            PreparedStatement delete_state = connectionData.prepareStatement("DELETE FROM AIRLINE_DETAILS WHERE Airline_id=? ");
            System.out.println("Enter the Airline_id: ");
            String delete_airline =scanner_object.next();
            delete_state.setString(1,delete_airline);
            int airline_delete= delete_state.executeUpdate();
            System.out.println(airline_delete+"deleted");

        }

        public void toupdateAirline(Connection connectionData) throws NullPointerException,SQLException {
            PreparedStatement update_value = connectionData.prepareStatement("UPDATE AIRLINE_DETAILS SET seating_capacity = ? WHERE airline_id = ?");
            System.out.println("ENTER THE AIRLINE ID TO UPDATE : ");
            String airline_id = scanner_object.next();
            System.out.println("ENTER THE SEATING CAPACTIY :");
            int seating_capacity = scanner_object.nextInt();
            update_value.setInt(1,seating_capacity);
            update_value.setString(2,airline_id);
            int airline_update = update_value.executeUpdate();
            System.out.println(airline_update +" updated successfully");

        }

    }

