package lesson30.itCompany;


import java.util.Collection;
import java.util.HashSet;

/**
 * Created by MM on 24.12.2017.
 */
public class Controller {

    private DepartmentDAO departmentDAO;
    private EmployeeDAO employeeDAO;
    private FirmDAO firmDAO;
    private ProjectDAO projectDAO;

    public Controller(DepartmentDAO departmentDAO, EmployeeDAO employeeDAO, FirmDAO firmDAO, ProjectDAO projectDAO) {
        this.departmentDAO = departmentDAO;
        this.employeeDAO = employeeDAO;
        this.firmDAO = firmDAO;
        this.projectDAO = projectDAO;
    }

    public Collection<Employee> employeesByProject(String projectName) {  // - список сотрудников, работающих над заданным проектом

    return employeeDAO.employeesByProject(projectName);
    }

    public Collection<Project> projectsByEmployee(Employee employee) { // - список проектов, в которых участвует заданный сотрудник
        Collection<Project> collection = new HashSet<>();
        try {
            collection = employeeDAO.projectsByEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) { // - список сотрудников из заданного отдела, не участвующих ни в одном проекте
        Collection<Employee> collection = new HashSet<>();
        try {
            collection = departmentDAO.employeesWithoutProject(departmentType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;

    }

    public Collection<Employee> employeesWithoutProject(){ // - список сотрудников, не участвующих ни в одном проекте
        return employeeDAO.employeesWithoutProjects();
    }

    public Collection<Employee> employeesByTeamLead(Employee lead){ // - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
        Collection<Employee> collection = new HashSet<>();
        try {
            collection = employeeDAO.employeesByTeamLead(lead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection<Employee> teamLeadsByEmployee(Employee employee){ // - список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        Collection<Employee> collection = new HashSet<>();
        try {
            collection = employeeDAO.teamLeadsByEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection<Employee> employeesByProjectEmployee(Employee employee){ // - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
        Collection<Employee> collection = new HashSet<>();
        try {
            collection = employeeDAO.employeesByProjectEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection<Project> projectsByCustomer(Customer customer){ // - список проектов, выполняемых для заданного заказчика
        Collection<Project> collection = new HashSet<>();
        try {
            collection = projectDAO.projectsByCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection<Employee> employeesByCustomerProjects(Customer customer){ // - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
        Collection<Employee> customerSProjectSEmployees = new HashSet<>();
        for (Project project : projectsByCustomer(customer)){
            customerSProjectSEmployees.addAll(employeesByProject(project.getName()));
        }
        return customerSProjectSEmployees;
    }
}
