package mycollegeproject.businesscomponents;

public class FacultyPojo extends UserPojo {

    public FacultyPojo(long id, String firstName, String lastName, boolean superAdmin, boolean faculty, boolean student) {
        super(id, firstName, lastName, superAdmin, faculty, student);
    }

    public FacultyPojo(long id, String firstName, String lastName) {
        super(id, firstName, lastName, false, true, false);
    }
}
