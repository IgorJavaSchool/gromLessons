package lesson30.itCompany;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by MM on 25.12.2017.
 */
public class Demo {
    public static void main(String[] args) {
        Customer customerUSA = new Customer("Soros", "USA", 1000000);
        Customer customerUA = new Customer("Kolomoiskyy", "UA", 10000);

        Project projectAmazon = new Project("OnlineStore", customerUSA);
        Project projectMobile = new Project("MobileApp", customerUSA);
        Project projectOLX = new Project("SellApp", customerUA);
        Project projectNP = new Project("NovaPosta", customerUA);
        Project projectEbay = new Project("OnlineAuction", customerUSA);

        Collection<Project> projectsUA = new HashSet<>();
        projectsUA.add(projectNP);
        projectsUA.add(projectOLX);

        Collection<Project> projectsUSA = new HashSet<>();
        projectsUSA.add(projectAmazon);
        projectsUSA.add(projectMobile);
        projectsUSA.add(projectEbay);

        Collection<Project> projectsAll = new HashSet<>();
        projectsAll.addAll(projectsUA);
        projectsAll.addAll(projectsUSA);


        Collection<Employee> employeesManagement = new HashSet<>();
        Collection<Employee> employeesFinance = new HashSet<>();
        Collection<Employee> employeesAnalytics = new HashSet<>();
        Collection<Employee> employeesDesign = new HashSet<>();
        Collection<Employee> employeesDevelopment = new HashSet<>();

        Department depManagement = new Department(DepartmentType.MANAGEMENT, employeesManagement);
        Department depFinance = new Department(DepartmentType.FINANCE, employeesFinance);
        Department depAnalytics = new Department(DepartmentType.ANALITICS, employeesAnalytics);
        Department depDesign = new Department(DepartmentType.DESIGN, employeesDesign);
        Department depDevelopment = new Department(DepartmentType.DEVELOPMENT, employeesDevelopment);

        Employee teamEmployee = new Employee("Ivan", "Ivanov", Position.TEAM_LEAD, depDevelopment, projectsAll);
        Employee analistEmployee = new Employee("Vera", "Brejneva", Position.ANALYST, depAnalytics, projectsUSA);
        Employee designEmployee = new Employee("Slava", "Zaicev", Position.DESIGNER, depDesign, projectsUA);
        Employee developerEmployee = new Employee("Bill", "Gates", Position.DEVELOPER, depDevelopment, projectsUSA);
        Employee financeEmployee = new Employee("Warren", "Buffett", Position.FINANCE, depFinance, projectsAll);
        Employee leadDesignEmployee = new Employee("Karl", "Lagerfeld", Position.LEAD_DESIGNER, depDesign, projectsUA);
        Employee managementEmployee = new Employee("Steve", "Jobs", Position.MANAGER, depManagement, projectsAll);
        Employee managementEmployeeNotProjects = new Employee("Empty", "Projects", Position.MANAGER, depManagement, new HashSet<>());
        Employee teamEmployeeNullProjects = new Employee("Empty", "Projects", Position.TEAM_LEAD, depDevelopment, projectsUA);

        employeesManagement.add(managementEmployeeNotProjects);
        employeesDevelopment.add(teamEmployeeNullProjects);

        employeesManagement.add(managementEmployee);
        employeesAnalytics.add(analistEmployee);
        employeesDesign.add(designEmployee);
        employeesDesign.add(leadDesignEmployee);
        employeesDevelopment.add(teamEmployee);
        employeesDevelopment.add(developerEmployee);
        employeesFinance.add(financeEmployee);

        Collection<Employee> employees = new HashSet<>();
        employees.addAll(employeesManagement);
        employees.addAll(employeesFinance);
        employees.addAll(employeesAnalytics);
        employees.addAll(employeesDesign);
        employees.addAll(employeesDevelopment);

        Collection<Department> departments = new HashSet<>();
        departments.add(depManagement);
        departments.add(depFinance);
        departments.add(depAnalytics);
        departments.add(depDesign);
        departments.add(depDevelopment);

        employeesManagement.add(managementEmployee);
        employeesAnalytics.add(analistEmployee);
        employeesDesign.add(designEmployee);
        employeesDesign.add(leadDesignEmployee);
        employeesDevelopment.add(developerEmployee);
        employeesDevelopment.add(teamEmployee);
        employeesFinance.add(financeEmployee);

        Collection<Customer> customers = new HashSet<>();
        customers.add(customerUSA);
        customers.add(customerUA);

        Firm firm = new Firm(departments, customers);
        Collection<Firm> firms = new HashSet<>();
        firms.add(firm);

        DepartmentDAO departmentDAO = new DepartmentDAO(departments);
        EmployeeDAO employeeDAO = new EmployeeDAO(employees);
        FirmDAO firmDAO = new FirmDAO(firms);
        ProjectDAO projectDAO = new ProjectDAO(projectsAll);


        /**
         * Тестовые данные.
         */
        Controller controller = new Controller(departmentDAO, employeeDAO, firmDAO, projectDAO);

        Collection<Employee> employeesTest;
        Collection<Project> projectsTest;

        /**
         * - список сотрудников, работающих над заданным проектом.
         */
        System.out.println();
        System.out.println("список сотрудников, работающих над заданным проектом.");
        employeesTest = controller.employeesByProject("OnlineStore");
        System.out.println(Arrays.toString(employeesTest.toArray()));

        /**
         * - список проектов, в которых участвует заданный сотрудник.
         */
        System.out.println();
        System.out.println("список проектов, в которых участвует заданный сотрудник.");
        projectsTest = controller.projectsByEmployee(leadDesignEmployee);
        System.out.println(Arrays.toString(projectsTest.toArray()));

        /**
         * - список сотрудников из заданного отдела, не участвующих ни в одном проекте
         */
        System.out.println();
        System.out.println("- список сотрудников из заданного отдела, не участвующих ни в одном проекте");
        employeesTest = controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPMENT);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByDepartmentWithoutProject(DepartmentType.MANAGEMENT);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByDepartmentWithoutProject(DepartmentType.FINANCE);
        System.out.println(Arrays.toString(employeesTest.toArray()));


        /**
         * - список сотрудников, не участвующих ни в одном проекте
         */
        System.out.println();
        System.out.println("- список сотрудников, не участвующих ни в одном проекте");
        employeesTest = controller.employeesWithoutProject();
        System.out.println(Arrays.toString(employeesTest.toArray()));


        /**
         * - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
         */
        System.out.println();
        System.out.println("- список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)");
        employeesTest = controller.employeesByTeamLead(teamEmployee);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByTeamLead(teamEmployeeNullProjects);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByTeamLead(designEmployee);
        System.out.println(Arrays.toString(employeesTest.toArray()));


        /**
         *- список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
         */
        System.out.println();
        System.out.println("- список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)");
        employeesTest = controller.teamLeadsByEmployee(designEmployee);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.teamLeadsByEmployee(managementEmployeeNotProjects);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.teamLeadsByEmployee(teamEmployee);
        System.out.println(Arrays.toString(employeesTest.toArray()));

        /**
         * - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
         */
        System.out.println();
        System.out.println("- список сотрудников, участвующих в тех же проектах, что и заданный сотрудник");
        employeesTest = controller.employeesByProjectEmployee(managementEmployeeNotProjects);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByProjectEmployee(teamEmployeeNullProjects);
        System.out.println(Arrays.toString(employeesTest.toArray()));
        employeesTest = controller.employeesByProjectEmployee(designEmployee);
        System.out.println(Arrays.toString(employeesTest.toArray()));

        /**
         * - список проектов, выполняемых для заданного заказчика
         */
        System.out.println();
        System.out.println("- список проектов, выполняемых для заданного заказчика");
        projectsTest = controller.projectsByCustomer(customerUSA);
        System.out.println(Arrays.toString(projectsTest.toArray()));

        /**
         * - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
         */
        System.out.println();
        System.out.println("- список сотрудников, участвующих в проектах, выполняемых для заданного заказчика");
        employeesTest = controller.employeesByCustomerProjects(customerUA);
        System.out.println(Arrays.toString(employeesTest.toArray()));
    }
}
