package lesson10.abstractbigexample;

/**
 * Created by MM on 12.12.2017.
 */
public class EmployeeController {
    private Employee[] employees = new Employee[100];

    void paySalaryToEmployess(){
        for (Employee employee : employees){
            if (employee instanceof DeveloperEmployee){

            }
            employee.paySalary();
            System.out.println("Salary was pay successfully to " + employee.getName() + " employee");
        }
    }
}
