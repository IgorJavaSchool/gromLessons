package lesson30.itCompany;

import java.util.Collection;

/**
 * Created by MM on 24.12.2017.
 */
public class Department {
    private DepartmentType type;
    private Collection employees;

    public Department(DepartmentType type, Collection employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (!employees.equals(that.employees)) return false;
        if (type != that.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + employees.hashCode();
        return result;
    }

    @Override
    public String toString() {
        if (this == null)
            return "Null";
        return "Department{" +
                "type=" + type.toString() +
                ", employees=" + employees.toString() +
                '}';
    }
}
