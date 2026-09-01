import java.util.List;
//2. Pojo Interface for CRUD operation
public interface DeptDAOIntf {
    public void createDept(Department dept); //declared
    public Department selectDept(int deptNumber); //declared
    public List<Department> selectAllDept(); //declared
    public void updateDept(Department deptObj); //declared
    public void deleteDept(int deptNumber); //declared
}
