package mycollegeproject.businesscomponents;

public class StudentPojo extends UserPojo {

    public StudentPojo(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public StudentPojo(long id, String firstName, String lastName) {
        super(id, firstName, lastName, false, false, true);
    }
}
