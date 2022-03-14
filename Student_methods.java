import java.io.IOException;

public interface Student_methods {
	
	// this is an interface class with all the methods for student that is avaialble to student only

    public void view_courses_student_all();
	public void view_open_courses_student();
	public void register_courses_student() throws IOException;
	public void withdraw_courses_student() throws IOException;
	public void view_registered_courses_student();

}
