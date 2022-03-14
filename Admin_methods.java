import java.io.IOException;

public interface Admin_methods {
	
	// this is a interface class for admin methods that the admins use

    public void create_course() throws IOException;
	public void delete_course() throws IOException;
	public void edit_course() throws IOException;
	public void display_course() throws IOException;
	public void register_student() throws IOException;
	public void view_courses();
	public void view_full_courses();
	public void write_full_courses();
	public void view_students_course() throws IOException;
	public void view_courses_student() throws IOException;
	public void sort_courses();
	
	
	
}
