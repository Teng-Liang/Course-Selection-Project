import java.io.Serializable;
import java.util.*;
public class Course implements Serializable{
	
	// this class is the course class, contains all the members for the courses which are heaivly used in the whole project
    
    /**
	 * 
	 */
	// private members for the courses
	private static final long serialVersionUID = 1L;
	private String course_name;
    private String course_id;
	private int max_students;
	private int registered_students;
	private ArrayList<Student> student_list;
	private String instructor_name;
	private int section_number;
	private String location;
	// below are constructors for the course class
	public Course() {
		
	}
	
	

	public Course(String course_name, String course_id, int max_students, int registered_students,
			ArrayList<Student> student_list, String instructor_name, int section_number, String location) {
		this.course_name = course_name;
		this.course_id = course_id;
		this.max_students = max_students;
		this.registered_students = registered_students;
		this.student_list = student_list;
		this.instructor_name = instructor_name;
		this.section_number = section_number;
		this.location = location;
	}

	
	// below are the getters and setters for the course class

	public String getCourse_name() {
		return course_name;
	}



	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}



	public String getCourse_id() {
		return course_id;
	}



	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}



	public int getMax_students() {
		return max_students;
	}



	public void setMax_students(int max_students) {
		this.max_students = max_students;
	}



	public int getRegistered_students() {
		return registered_students;
	}



	public void setRegistered_students(int registered_students) {
		this.registered_students = registered_students;
	}



	public ArrayList<Student> getStudent_list() {
		return student_list;
	}



	public void setStudent_list(ArrayList<Student> student_list) {
		this.student_list = student_list;
	}



	public String getInstructor_name() {
		return instructor_name;
	}



	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}



	public int getSection_number() {
		return section_number;
	}



	public void setSection_number(int section_number) {
		this.section_number = section_number;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}
// this is the information class, it prints out all the information through the class members

	public String info_a() {
		String names = "";

			if (student_list != null) {
			for (int i = 0; i < student_list.size(); i++) {
				String addFirst = student_list.get(i).getFirst_name();
				String addLast = student_list.get(i).getLast_name();
				names = names + addFirst + " " + addLast + ", ";
			}
			System.out.println("Course name: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + registered_students
			+ "\n" + "Registered Students: " + names + "\n" + "Instructor: " + instructor_name + "\n" + "Section: " + section_number + "\n" + "Location: " + location);
			System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][]");
			String text1 = "Course: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + registered_students + "\n" + "Registered Students: "
			+ names + "\n" + "Instructor: " + instructor_name + "\n" + "Section: " + section_number + "\n" + "Location: " + location;
			return (text1);
			
		}  else {
			System.out.println("Course name: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + student_list
			+ "\n" + "Registered Students: " + student_list + "\n" + "Instructor: " + instructor_name + "\n"
			+ "Section: " + section_number + "\n" + "Location: " + location);
			System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][]"); }
			String text2 = "Course name: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + registered_students + "\n" + "Registered Students: "
			+ student_list + "\n" + "Instructor: " + instructor_name + "\n" + "Section: " + section_number + "\n"
			+ "Location: " + location;
			return (text2);
		} 
	

	public String info_s() {
		System.out.println("Course name: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + registered_students + "\n" + "Registered Students: "
		+ "\n" + "Instructor: " + instructor_name + "\n" + "Section: " + section_number + "\n" + "Location: "
		+ location);
		System.out.println("[][][][][][][][][][][][][][][][][][][][][][][][][][]");
		String text = "Course name: " + course_name + "\n" + "Course ID Number: " + course_id + "\n" + "Maximum # of Students: " + max_students + "\n" + "Current # of Students: " + registered_students + "\n" + "Registered Students: "
		+ "\n" + "Instructor: " + instructor_name + "\n" + "Section: " + section_number + "\n" + "Location: "
		+ location;
		return (text);
	} 
    
}
