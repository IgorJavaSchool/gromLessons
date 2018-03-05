package lesson30.itCompany;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by MM on 24.12.2017.
 */
public class EmployeeDAO extends GeneralDao<Employee> {

    public EmployeeDAO(Collection<Employee> collection) {
        super(collection);
    }

    public Collection<Employee> employeesWithoutProjects() { // - список сотрудников, не участвующих ни в одном проекте
        Collection<Employee> employeesNotProjects = new HashSet<>();
        for (Employee employee : getCollection()) {
            if (employee != null) {
                if (employee.getProjects() == null || employee.getProjects().isEmpty())
                    employeesNotProjects.add(employee);
            }
        }
        return employeesNotProjects;
    }

    public Collection<Employee> employeesByProject(String projectName) {  // - список сотрудников, работающих над заданным проектом
        Collection<Employee> employeesIntoProject = new HashSet<>();
        for (Employee employee : getCollection()) {
            if (employee == null || employee.getProjects() == null)
                continue;
            for (Project project : (Collection<Project>) employee.getProjects()) {
                if (project == null)
                    continue;
                if (project.getName().equals(projectName))
                    employeesIntoProject.add(employee);
            }
        }
        return employeesIntoProject;
    }

    public Collection<Project> projectsByEmployee(Employee employee) throws Exception { // - список проектов, в которых участвует заданный сотрудник
        if (employee == null){
            throw new Exception("Parameter employee can't is null");
        }
        Collection<Project> employeeSProject = new HashSet<>();

        if (employee == null || employee.getProjects() == null)
            return employeeSProject;
        for (Project project : (HashSet<Project>)employee.getProjects()){
            if (project != null)
                employeeSProject.add(project);
        }
        return employeeSProject;
    }

    public Collection<Employee> employeesByTeamLead(Employee lead) throws Exception { // - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
        if (lead == null){
            throw new Exception("Parameter employee can't is null");
        }

        Collection<Employee> leaderSSubject = new HashSet<>();


        for (Project project : projectsByEmployee(lead)){
            for (Employee employee : employeesByProject(project.getName())){
                if (!employee.equals(lead)){
                    leaderSSubject.add(employee);
                }
            }
        }
        return leaderSSubject;
    }

    public Collection<Employee> teamLeadsByEmployee(Employee employee) throws Exception { // - список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
        if (employee == null){
            throw new Exception("Parameter employee can't is null");
        }
        Collection<Employee> subjectSLeaders = new HashSet<>();

        for (Project project : projectsByEmployee(employee)){
            for (Employee employeeInProject : employeesByProject(project.getName())){
                if (employeeInProject.getPosition() == Position.TEAM_LEAD)
                    subjectSLeaders.add(employeeInProject);
            }
        }
        return subjectSLeaders;
    }

    public Collection<Employee> employeesByProjectEmployee(Employee employee) throws Exception { // - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
        if (employee == null){
            throw new Exception("Parameter employee can't is null");
        }
        Collection<Employee> colleagues = new HashSet<>();
        for (Employee employeeOne : getCollection()){
            if (employee.equals(employeeOne))
                continue;

            if (!Collections.disjoint(employee.getProjects(), employeeOne.getProjects())){
                colleagues.add(employeeOne);
            }
        }
        return colleagues;
    }

}
