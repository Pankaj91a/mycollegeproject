package mycollegeproject.businesscomponents;

public class AdminPojo extends UserPojo {

    public AdminPojo(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public AdminPojo(long id, String firstName, String lastName) {
        super(id, firstName, lastName, true, false, false);
    }
}
