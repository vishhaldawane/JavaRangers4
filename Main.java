import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DeptDAOIntf intf = new DeptDAOImpl();

        /*Department dept = intf.selectDept(40);
        System.out.println("Department Number    : "+dept.getDepartmentNumber());
        System.out.println("Department Name      : "+dept.getDepartmentName());
        System.out.println("Departmenet location : "+dept.getLocation());

    */
     /*   List<Department> listOfDept = intf.selectAllDept();
        for(Department dept:listOfDept){
            System.out.println("Department Number    : "+dept.getDepartmentNumber());
            System.out.println("Department Name      : "+dept.getDepartmentName());
            System.out.println("Department location : "+dept.getLocation());

        }*/

      /*  Department deptObj = new Department();
        deptObj.setDepartmentNumber(100);
        deptObj.setDepartmentName("TRG");
        deptObj.setLocation("KOP");

        intf.updateDept(deptObj);*/

        intf.deleteDept(100);
    }
}