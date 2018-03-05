package lesson30.itCompany;

import java.util.Collection;
import java.util.Date;

/**
 * Created by MM on 24.12.2017.
 */
public class Firm {
    private Date dateFounded;
    private Collection departments;
    private Collection customers;

    public Firm(Collection departments, Collection customers) {
        this.dateFounded = new Date();
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public Collection getDepartments() {
        return departments;
    }

    public Collection getCustomers() {
        return customers;
    }
}
