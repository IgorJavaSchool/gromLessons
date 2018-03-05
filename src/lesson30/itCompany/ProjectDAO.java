package lesson30.itCompany;

import java.util.Collection;
import java.util.HashSet;


/**
 * Created by MM on 27.12.2017.
 */
public class ProjectDAO extends GeneralDao<Project> {

    public ProjectDAO(Collection collection) {
        super(collection);
    }

    public Collection<Project> projectsByCustomer(Customer customer) throws Exception { // - список проектов, выполняемых для заданного заказчика
        if (customer == null){
            throw new Exception("Parameter customer can't is null");
        }
        Collection<Project> customerSProjects = new HashSet<>();

        for (Project project : getCollection()){
            if (project != null) {
                if (project.getCustomer().equals(customer))
                    customerSProjects.add(project);
            }
        }
        return customerSProjects;
    }

}
