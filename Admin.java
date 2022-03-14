import java.io.*;
import java.util.*;

public class Admin extends User implements Admin_methods {
	// the Admin class used by Admins and uses admin method interface available only to admin

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<Student> student_list = new ArrayList<Student>();
    static ArrayList<Course> course_list = new ArrayList<Course>();
    // constructors below
	public Admin() {
		super();
		this.setUsername("admin");
		this.setPassword("admin001");
	}

	
	
	public static ArrayList<Student> getStudent_list() {
		return student_list;
	}


	public static void setStudent_list(ArrayList<Student> student_list) {
		Admin.student_list = student_list;
	}
	//this checks if a student is in the student list
	public static Boolean student_check(Student student){
		Boolean check=false;
		
		for (Student s : student_list) {
			if(s.getUsername()==(student.getUsername())&& s.getPassword()==(student.getPassword())){
				check=true;
				
		}
		}
		return check;
	} 

    @Override
    // enters course information, then creates new course object with course constructor entering the data from buffered reader
    public void create_course() throws IOException {
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> current_student_list = new ArrayList<Student>();
        
        System.out.println("You have selected to create a new course! Please enter the following information:");

		System.out.println("Course name: ");
		String course_name = in.readLine();
		System.out.println("Course id: ");
		String course_id = in.readLine();
		System.out.println("Max students: ");
		String max = in.readLine();
		int max_students = Integer.parseInt(max);
		System.out.println("Registered students: ");
		String registered = in.readLine();
		int registered_students = Integer.parseInt(registered);
		System.out.println("Instructor name: ");
		String instructor_name = in.readLine();
		System.out.println("Course section number: ");
		String course = in.readLine();
		int course_section_number = Integer.parseInt(course);
		System.out.println("Course location: ");
		String course_location = in.readLine();

		Course new_course = new Course(course_name, course_id, max_students, registered_students, current_student_list, instructor_name,
				course_section_number, course_location);
		Admin.course_list.add(new_course);
		System.out.println("You have created a new course!");
        
    }

    @Override
    // loops through course list to find course name entered and remove it from course list
    public void delete_course() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You have selected to delete an existing course, please follow the directions.");
		System.out.println("Enter the course name to be deleted: ");
		String course_name = in.readLine();
		
		for (Course c : Admin.course_list ) {
			if (c.getCourse_name().equals(course_name)) {
		        Admin.course_list.remove(c);
		        System.out.println("You have removed a course.");
		        break;
		    } 
			else {
				System.out.println("Cannot find the course you were looking for");
				break;
			}
				
		}
    }
	// finds course name, then uses its getters and setters to modify information about the course
    @Override
    public void edit_course() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the course name to edit");
		String course_name = in.readLine();
		
		Boolean valid = true;
		while(valid){
			for (int i = 0; i < Admin.course_list.size(); i++) {
				String j = Admin.course_list.get(i).getCourse_name();
				if (j.contentEquals(course_name)) {
					System.out.println("Course Found");
					valid = false;
					break;
				} else if ((!j.contentEquals(course_name)) && (i == Admin.course_list.size() - 1)) {
					System.out.println("Cannot find course");
					return;
				}
			}
		}
		System.out.println("enter 'max' to change max student number");
		System.out.println("enter  'number' to change section number");
		System.out.println("enter 'instructor' to change instructor");
		System.out.println("enter 'location' to change location");
		String choice = in.readLine();
		//uses two loops, once to parse course list, and the other one sets each instance in the list to a variable and compares them to the one entered to find course name. Then uses setters and getters to modify info.
		if (choice.contentEquals("max")) {
			System.out.println("enter number of max student ");
			String max = in.readLine();
			int max_students = Integer.parseInt(max);
			for (int i = 0; i < Admin.course_list.size(); i++) {
				String j = Admin.course_list.get(i).getCourse_name();
				if (j.contentEquals(course_name)) {
					Admin.course_list.get(i).setMax_students(max_students);
					System.out.println("changed max students to " + max_students);
					System.out.println("");
				}
			}
		}
		//uses two loops, once to parse course list, and the other one sets each instance in the list to a variable and compares them to the one entered to find course name. Then uses setters and getters to modify info.
		else if (choice.contentEquals("number")) {
			System.out.println("enter number of section number ");
			String section = in.readLine();
			int section_number = Integer.parseInt(section);
			for (int i = 0; i < Admin.course_list.size(); i++) {
				String j = Admin.course_list.get(i).getCourse_name();
				if (j.contentEquals(course_name)) {
					Admin.course_list.get(i).setSection_number(section_number);
					System.out.println("changed section number to " + section_number);
					System.out.println("");
				}
			}
		}
		//uses two loops, once to parse course list, and the other one sets each instance in the list to a variable and compares them to the one entered to find course name. Then uses setters and getters to modify info.
		else if (choice.contentEquals("instructor")) {
			System.out.println("enter name ");
			String instructor_name = in.readLine();
			for (int i = 0; i < Admin.course_list.size(); i++) {
				String j = Admin.course_list.get(i).getCourse_name();
				if (j.contentEquals(course_name)) {
					Admin.course_list.get(i).setInstructor_name(instructor_name);
					System.out.println("changed instructor to " + instructor_name);
					System.out.println("");
				}
			}
		//uses two loops, once to parse course list, and the other one sets each instance in the list to a variable and compares them to the one entered to find course name. Then uses setters and getters to modify info.
		} else if (choice.contentEquals("location")) {
			System.out.println("enter location: ");
			String course_location = in.readLine();
			for (int i = 0; i < Admin.course_list.size(); i++) {
				String j = Admin.course_list.get(i).getCourse_name();
				if (j.contentEquals(course_name)) {
					Admin.course_list.get(i).setLocation(course_location);
					System.out.println("changed location to " + course_location);
					System.out.println(" ");
				}
			}
		}
		
		else 
			System.out.print("Wrong entry");
			return;
    }

    @Override
    // uses entered course id, then uses two loops to parse course list, setting j to course id, finding the course id and uses info to print info
    public void display_course() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("enter course id ");
		String id = in.readLine();
		for (int i = 0; i < Admin.course_list.size(); i++) {
			String j = Admin.course_list.get(i).getCourse_id();
			if (j.contentEquals(id)) {
				Admin.course_list.get(i).info_a();
			}
		}
    }

    @Override
    // enters student first and last name, then creates new student object with those parameters and add it to student list.
    public void register_student() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("enter first name ");
		String first = in.readLine();
		System.out.println("enter last name: ");
		String last = in.readLine();

		Student new_student = new Student(first, last);
		Admin.student_list.add(new_student);
		System.out.println("Registration complete");

    }

    @Override
    // calls the info function to print all courses in course list through for loop
    public void view_courses() {
        for (Course courses : course_list) {
			courses.info_a();
		}
    }

    @Override
    // runs through course list with for loop, checks if registered student is equal to max student, if so print the info of courses.
    public void view_full_courses() {
		for (Course courses : course_list) {
			if (courses.getRegistered_students()==courses.getMax_students()) {
				courses.info_a();
			}
		}
    }
    
    @Override
    // simply opens new text and writes the info printed in course list 
    public void write_full_courses() {
        String file = "text.txt";
		Scanner scan = new Scanner(System.in);
	// tries looping through course list and writes the text from info method
		try {
			FileWriter f_writer = new FileWriter(file);
			BufferedWriter b_writer = new BufferedWriter(f_writer);
			for (Course courses : course_list) {
				String text = courses.info_a();
				b_writer.write(text);
				b_writer.newLine();
			}
			b_writer.close();
			scan.close();
		}
	// catches error
		catch (IOException exception) {
			System.out.println("IO Exception Error ");
	
		}
    }
    
    @Override
    // enters student first and last name. Then uses two loops to loop through each course of the list and finds student name, if student name matches what was entered, print out the courses belonging to student
    public void view_courses_student() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please follow the instructions to view the courses of a student");
		System.out.println("Enter first name of student: ");
		String first_name = in.readLine();
		System.out.println("Enter last name of student: ");
		String last_name = in.readLine();

		System.out.println("Classes of" + first_name + "" + last_name);
		for (int i = 0; i < Admin.course_list.size(); i++) {
			for (int j = 0; j < Admin.course_list.get(i).getStudent_list().size(); j++) {
				if (Admin.course_list.get(i).getStudent_list().get(j).getFirst_name() == first_name && Admin.course_list.get(i).getStudent_list().get(j).getLast_name() == last_name) {
					String courses = Admin.course_list.get(i).getCourse_name();
					System.out.println(courses);
				}
			}
		}
    }

    @Override
    // enters the course name, and uses two loops to loop through course list and find the student name from the course object
    public void view_students_course() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please follow the instructions to view the courses of a student");
		System.out.println("Enter the course's name: ");
		String course_name = in.readLine();

		for (int i = 0; i < Admin.course_list.size(); i++) {
			if (Admin.course_list.get(i).getCourse_name() == course_name) {
				for (int j = 0; j < Admin.course_list.get(i).getStudent_list().size(); j++) {
					String first = Admin.course_list.get(i).getStudent_list().get(j).getFirst_name();
					String last = Admin.course_list.get(i).getStudent_list().get(j).getLast_name();
					System.out.println("Student of" + course_name);
					System.out.print(first + " " + last);
				}
			}
		}
    }

   

    @Override
    // uses two loops, i and j, starting from front and back, and checks the registered students, then sorts the courses based on that registered students through for loop
    public void sort_courses() {
        for (int i = 0; i < Admin.course_list.size(); i++) {
			for (int j = Admin.course_list.size() - 1; j > i; j--) {
				if (Admin.course_list.get(i).getRegistered_students() > Admin.course_list.get(j).getRegistered_students()) {
					Course block = Admin.course_list.get(i);
					Admin.course_list.set(i, Admin.course_list.get(j));
					Admin.course_list.set(j, block);
				}

			}

		}
    // this part prints out the sorted course list
		for (Course courses : course_list) {
			courses.info_a();
		}
    }



}





   
    
