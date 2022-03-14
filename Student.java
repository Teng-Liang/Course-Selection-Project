import java.io.*;

public class Student extends User implements Student_methods {
	// this class is what the students use, along with using student method interface, availble only to students
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// creates admin object so we can use its methods
	Admin admin = new Admin();
	// this is the constructor part
	public Student(){

	}

	public Student(String username, String password, String first_name, String last_name) {
        super(username, password, first_name, last_name);
        
    }
	
    public Student(String first_name, String last_name) {
        super(first_name, last_name);
    }


    @Override
    // method that prints every item on course list
    public void view_courses_student_all() {
    	for (Course courses : Admin.course_list) {
    		courses.info_a();
    	}
      
    }

    @Override
    //compares registration student number to max student number, if not equal, print the course info
    public void view_open_courses_student() {
    	for (Course courses : Admin.course_list) {
			if (courses.getRegistered_students() != courses.getMax_students()) {
				courses.info_a();
			}
		}
    }

    @Override
    // enter course name along with id, then compare course name and course id from course list and adds student to student list
    public void register_courses_student() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please follow the following instructions to register for a course");
		System.out.println("Enter course name: ");
		String course_name = in.readLine();
		System.out.println("Enter course ID: ");
		String course_id = in.readLine();
		for (Course courses : Admin.course_list) {
			if (courses.getCourse_name().compareTo(course_name)==0 && courses.getCourse_id().compareTo(course_id)==0) {
				Student student = new Student(this.getFirst_name(), this.getLast_name());
				courses.getStudent_list().add(student);
				courses.setRegistered_students(courses.getRegistered_students()+1);
				System.out.println("registration successful");
			}else{
				System.out.println("registration unsuccessful");
			}
		}
    }

    @Override
    // enters course name and finds the student through 2 loops, and then remove the student from student list
    public void withdraw_courses_student() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please follow the following instructions to withdraw from a course");
        System.out.println("Enter course name: ");
		String course_name = in.readLine();

		for (int i = 0; i < Admin.course_list.size(); i++) {
			if (Admin.course_list.get(i).getCourse_name().compareTo(course_name)==0) {
				for(int j=0;j<Admin.course_list.get(i).getStudent_list().size();j++){
					if(Admin.course_list.get(i).getStudent_list().get(j).getFirst_name().compareTo(this.getFirst_name())==0&&Admin.course_list.get(i).getStudent_list().get(j).getLast_name().compareTo(this.getLast_name())==0){
						Admin.course_list.get(i).getStudent_list().remove(j);
						Admin.course_list.get(i).setRegistered_students(Admin.course_list.get(i).getRegistered_students()-1);
						System.out.println("You are removed from course.");
					}
				}
			}else {
				System.out.println("removal unscuessful");
			}
		}
    }

    @Override
    // uses two for loops to get courses from course list of the student name
    public void view_registered_courses_student() {   
        System.out.println("Classes of" + this.getFirst_name() + " " + this.getLast_name());
		for (int i = 0; i < Admin.course_list.size(); i++) {
			for (int j = 0; j < Admin.course_list.get(i).getStudent_list().size(); j++) {
				if (Admin.course_list.get(i).getStudent_list().get(j).getFirst_name().compareTo(getFirst_name())==0 && Admin.course_list.get(i).getStudent_list().get(j).getLast_name().compareTo(getLast_name())==0) {
					String course_name = Admin.course_list.get(i).getCourse_name();
					System.out.println(course_name);
				}
			}
		}
    }
    
}
