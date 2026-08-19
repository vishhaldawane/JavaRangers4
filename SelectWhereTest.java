import java.sql.*;
import java.util.Scanner;

//File ->Project Structure
// -> Module -> Dependencies -> Click the + buttom
// add the Jar or directory
public class SelectWhereTest {

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

            Statement st = conn.createStatement();
            System.out.println("statement established "+st);

            Scanner scanner=new Scanner(System.in);
            System.out.println("enter a dept number to search : ");
            int dno=Integer.parseInt(scanner.nextLine());

            ResultSet rs = st.executeQuery("select * from dept where deptno="+dno);
            System.out.println("got the result set "+rs);

            if(rs.next()){
                System.out.println("DEPTNO : "+rs.getInt(1));
                System.out.println("DNAME  : "+rs.getString(2));
                System.out.println("LOC    : "+rs.getString(3));
                System.out.println("-------------------");
            }
            else {
                System.out.println("No records found");
            }

            rs.close();
            st.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
