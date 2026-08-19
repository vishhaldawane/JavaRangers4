import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//File ->Project Structure
// -> Module -> Dependencies -> Click the + buttom
// add the Jar or directory
public class UpdateTest {

    public static void main(String[] args) {

        try {
            //1. load the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("driver registered");

            String url = "jdbc:mysql://localhost:3306/mysql";
            String user = "root";
            String password = "root@123";


            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("connection established "+conn);

            PreparedStatement pst = conn.prepareStatement("UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?");
            System.out.println("prepared statement established "+pst);

            Scanner sc = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            Scanner sc3 = new Scanner(System.in);

            System.out.println("enter the EXISTING dept number FOR UPDATE ");
            int x = Integer.parseInt(sc.nextLine());

            System.out.println("enter the new dept name FOR THIS RECORD");
            String y = sc2.nextLine();
            System.out.println("enter the new dept location FOR THIS RECORD");
            String z = sc3.nextLine();

            pst.setString(1,y);
            pst.setString(2,z);
            pst.setInt(3,x);


            int rows = pst.executeUpdate();
            System.out.println(rows+ " rows UPDATED ");


            pst.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
