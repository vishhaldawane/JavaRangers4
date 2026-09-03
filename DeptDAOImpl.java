import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3. Pojo Interface Crud Operation Implementation [ coding ]
public class DeptDAOImpl implements DeptDAOIntf {

    Connection conn; //global connection available for all functions

    public DeptDAOImpl() {
        //1. load the driver
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("driver registered");

            String url = "jdbc:mysql://localhost:3306/mysql";
            String user = "root";
            String password = "root@123";

            //global conn is referred below
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection established " + conn);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createDept(Department deptObj) { //implemented
        try {

            PreparedStatement pst = conn.prepareStatement("INSERT INTO DEPT VALUES (?,?,?)");
            System.out.println("prepared statement established "+pst);

            pst.setInt(1,deptObj.getDepartmentNumber());
            pst.setString(2,deptObj.getDepartmentName());
            pst.setString(3,deptObj.getLocation());

            int rows = pst.executeUpdate();
            System.out.println(rows+ " rows inserted ");


            pst.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department selectDept(int deptNumber) { //implemented

        Department deptObj = null;

        try {

            Statement st = conn.createStatement();
            System.out.println("statement established "+st);

            ResultSet rs = st.executeQuery("select * from dept where deptno="+deptNumber);
            System.out.println("got the result set "+rs);

            if(rs.next()){
                deptObj = new Department();
                deptObj.setDepartmentNumber(rs.getInt(1));
                deptObj.setDepartmentName(rs.getString(2));
                deptObj.setLocation(rs.getString(3));
            }
            else {
                throw new RuntimeException("no row found for dept number "+deptNumber);
            }

            rs.close();
            st.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deptObj;
    }

    @Override
    public List<Department> selectAllDept() { //implemented
        List<Department> deptList = new ArrayList<Department>();;

        Department deptObj = null;

        try {

            Statement st = conn.createStatement();
            System.out.println("statement established "+st);

            ResultSet rs = st.executeQuery("select * from dept");
            System.out.println("got the result set "+rs);

            while(rs.next()){
                //create an empty object if row is found
                deptObj = new Department();//for each row a new object is created

                //fillup value in this object from rs
                deptObj.setDepartmentNumber(rs.getInt(1));
                deptObj.setDepartmentName(rs.getString(2));
                deptObj.setLocation(rs.getString(3));

                //push this object into the list
                deptList.add(deptObj); //add that object in the list
            }


            rs.close();
            st.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deptList;

    }

    @Override
    public void updateDept(Department deptObj) { //implemented
        try {

            PreparedStatement pst = conn.prepareStatement("UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?");
            System.out.println("prepared statement established "+pst);



            pst.setString(1, deptObj.getDepartmentName());
            pst.setString(2,deptObj.getLocation());
            pst.setInt(3,deptObj.getDepartmentNumber());


            int rows = pst.executeUpdate();
            System.out.println(rows+ " rows UPDATED ");


            pst.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteDept(int deptno) { //implemented
        try {

            PreparedStatement pst = conn.prepareStatement("DELETE FROM DEPT WHERE DEPTNO=?");
            System.out.println("prepared statement established "+pst);

            pst.setInt(1,deptno);


            int rows = pst.executeUpdate();
            System.out.println(rows+ " rows DELETED ");


            pst.close();
            conn.close();
            System.out.println("db resources closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
