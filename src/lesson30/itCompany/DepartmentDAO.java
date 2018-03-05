package lesson30.itCompany;


import java.util.Collection;
import java.util.HashSet;

/**
 * Created by MM on 27.12.2017.
 */
public class DepartmentDAO extends GeneralDao<Department> {

    public DepartmentDAO(Collection<Department> collection) {
        super(collection);
    }

    public Collection<Employee> employeesWithoutProject(DepartmentType departmentType) throws Exception { // - список сотрудников из заданного отдела, не участвующих ни в одном проекте
        if (departmentType == null){
            throw new Exception("Parameter departmentType can't is null");
        }
        Collection<Employee> departmentSEmployeesNotProject = new HashSet<>();
        for (Department department : getCollection()){
            if (department.getType().equals(departmentType)){
                for (Employee employee: (HashSet<Employee>)department.getEmployees()){
                    if (employee.getProjects() == null || employee.getProjects().isEmpty())
                        departmentSEmployeesNotProject.add(employee);
                }
            }
        }
        return departmentSEmployeesNotProject;
    }
}
