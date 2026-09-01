import java.sql.*;
import java.util.List;

//3. Pojo Interface Crud Operation Implementation [ coding ]
public class DeptDAOImpl implements DeptDAOIntf {
    @Override
    public void createDept(Department deptObj) { //implemented

    }

    @Override
    public Department selectDept(int deptNumber) { //implemented

        Department deptObj = null;

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
        return null;
    }

    @Override
    public void updateDept(Department deptObj) { //implemented

    }

    @Override
    public void deleteDept(int deptno) { //implemented

    }
}
