import java.util.*;
import java.io.*;
public class Management {
    @SuppressWarnings({ })
  
  // this is the managemnet class, contains everything that runs the program + the main class
   
    
   //this is serialization, serializes objects in student list and course list
    public static void serialization() {
    	
    	String file1 = "Data1";
    	String file2 = "Data2";
    	
		try {
			FileOutputStream fos = new FileOutputStream(file1);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Admin.student_list);
			oos.close();
			fos.close();
			System.out.println("Serialized");
		} 
		catch (IOException exception) {
			System.out.println("Exception found");
		}
		try {
			FileOutputStream fos = new FileOutputStream(file2);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Admin.course_list);
			oos.close();
			fos.close();
			System.out.println("Serialized");
		} catch (IOException exception) {
			System.out.println("IO Exception found");
		} 
	}

	@SuppressWarnings("unchecked")
	// this is deserialization which deserializes student list and course list
	public static void deSerialization() {
		
		String file1 = "Data1";
    	String file2 = "Data2";	
    	
    	try {
			FileInputStream fis = new FileInputStream(file1);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Admin.student_list = (ArrayList<Student>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Deserialized");
		} catch (IOException exception) {
			System.out.println("IO Exception found");
		} catch (ClassNotFoundException c) {
			System.out.println("IO Exception found");
		}
    	
		try {
			FileInputStream fis = new FileInputStream(file2);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Admin.course_list = (ArrayList<Course>) ois.readObject();
			ois.close();
			fis.close();
			System.out.println("Deserialized");
		} catch (IOException exception) {
			System.out.println("IO Exception found");
		} catch (ClassNotFoundException exception) {
			System.out.println("CNF Exception found");
			
		}
		
	}

	
	

// this is the main which runs the program
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("Data2");
		if (!file.exists()) {
			file = new File("/Users/tengliang/eclipse-workspace/Course_selection_project/src/MyUniversityCourses.csv");

	
			try {
				
				FileReader f_reader = new FileReader(file);
				BufferedReader b_reader = new BufferedReader(f_reader);
				b_reader.close();
			}
	
			catch (FileNotFoundException exception) {
				System.out.println("cannot open file");
	
			}

			catch (IOException exception) {
				System.out.println("cannot read file");
		
			}

	
			Scanner in=new Scanner(file);
			String input = in.useDelimiter("\\A").next();
			StringTokenizer String = new StringTokenizer(input, ",\n");

			int count = 0;
			while (String.hasMoreTokens()) {
				if (count > 7) {
					String course_name = String.nextToken();
					String course_id = String.nextToken();
					String test = String.nextToken();
					String new_test = test.replace(" ", "");
					int max_students = Integer.parseInt(new_test);
					String test1 = String.nextToken();
					String new_test1 = test1.replace(" ", "");
					int registered_students = Integer.parseInt(new_test1);
					String.nextToken();
					String instructor_name = String.nextToken();
					String test2 = String.nextToken();
					String new_test2 = test2.replace(" ", "");
					int section_number = Integer.parseInt(new_test2);
					String course_location = String.nextToken();
					ArrayList<Student> student_list=new ArrayList<Student>();
					
					Course course = new Course(course_name, course_id, max_students, registered_students,student_list, instructor_name,
							section_number, course_location);
					Admin.course_list.add(course);
					count++;
				} else {
					String.nextToken();
					count++;
				}
			}
			in.close();
		} else {
			deSerialization();
		}
		Admin admin = new Admin();
// Selection to login as admin or student, login page
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("This is the course selection program");
		System.out.println("Type 'admin' to login");
		System.out.println("Type 'student' to login");
		String option = in.readLine();

    // catches wrong login
		if (!option.contentEquals("admin") && !option.contentEquals("student")) {
			System.out.println("Wrong selection");
			return;
		}

		if (option.contentEquals("admin")) {
			System.out.println("Follow these instructions to login as admin");
			System.out.println("Enter username:");
			String username = in.readLine();
			System.out.println("Enter password:");
			String password = in.readLine();

      // catches wrong login
			if (!username.contentEquals("admin") || !password.contentEquals("admin001")) {
				System.out.println("Wrong selection");
				return;
			}

			System.out.println("You have logged in");
			boolean logout=false;
			while (logout==false) {
				System.out.println("You now have access to admin operations");
				System.out.println("Type 'courses' for course managment");
				System.out.println("Type 'reports' for reports");
				String choice2 = in.readLine();
				if (choice2.contentEquals("courses")) {
					while(true){
						System.out.println("You have selected course managment");
						System.out.println("Enter 'new' to create course");
						System.out.println("Enter 'old' to delete course");
						System.out.println("Enter 'edit' to edit course");
						System.out.println("Enter 'display' to display information on a course");
						System.out.println("Enter 'register' to register student");
						String choice3 = in.readLine();
					
	
						if (choice3.contentEquals("new")) {
							admin.create_course();
							} 
						else if (choice3.contentEquals("old")) {
							admin.delete_course();
							} 
						else if (choice3.contentEquals("edit")) {
							admin.edit_course();
							} 
						else if (choice3.contentEquals("display")) {
							admin.display_course();
							} 
						else if (choice3.contentEquals("register")) {
							admin.register_student();
						} 
						
						else {
							logout = true;
							serialization();
							System.exit(0);
						}
					}

				} 
				
				else if (choice2.contentEquals("reports")) {
					while(true){
						System.out.println("You have selected reports");
						System.out.println("Enter 'all' to display all courses");
						System.out.println("Enter 'full' to display all full courses");
						System.out.println("Enter 'write' to write file to full courses");
						System.out.println("Enter 'student' to view the students of a course");
						System.out.println("Enter 'courses' to view the courses of a student");
						System.out.println("Enter 'sort' to sort courses");
						String choice3 = in.readLine();
						
	
						if (choice3.contentEquals("all")) {
							admin.view_courses();
							} 
						else if (choice3.contentEquals("full")) {
							admin.view_full_courses();
							} 
						else if (choice3.contentEquals("write")) {
							admin.write_full_courses();
							} 
						else if (choice3.contentEquals("student")) {
							admin.view_students_course();
							} 
						else if (choice3.contentEquals("courses")) {
							admin.view_courses_student();
							} 
						else if (choice3.contentEquals("sort")) {
							admin.sort_courses();
							} 
						else {
							logout = true;
							serialization();
							System.exit(0);
						}
					}

				} 
				
				else {
					System.out.println("You are exiting");
					logout = true;
					serialization();	
				}
			}

		} 
		else if (option.contentEquals("student")) {
			System.out.println("You have selected student: follow the instructions");
			System.out.println("Enter first name:");
			String first = in.readLine();
			System.out.println("Enter last name:");
			String last = in.readLine();

			Student verification = new Student(first, last);
			// System.out.println(Admin.registerationManager);
			for (int i = 0; i < Admin.student_list.size(); i++) {
				if(Admin.student_list.get(i).getFirst_name().compareTo(first)==0&&Admin.student_list.get(i).getLast_name().compareTo(last)==0){
					verification.setUsername(Admin.student_list.get(i).getUsername());
					verification.setPassword(Admin.student_list.get(i).getPassword());
					System.out.println("You are in system");
					break;
				}else {
					System.out.println("You are not in the system");
					System.exit(0); 
				}
			}

			if ((verification.getUsername() == null) || (verification.getPassword() == null)) {
				System.out.println("You are in system");
				System.out.println("Please follow the instructions to setup account");
				System.out.println("enter a username ");
				String username = in.readLine();
				System.out.println("enter a password");
				String password = in.readLine();
				for (int i = 0; i < Admin.student_list.size(); i++) {
					if ((Admin.student_list.get(i).getFirst_name().equals(first)) && (Admin.student_list.get(i).getLast_name().equals(last))) {
						Admin.student_list.get(i).setUsername(username);
						Admin.student_list.get(i).setPassword(password);
						System.out.println("You have made an account");
					}
				}
			}

			Student student = new Student();
			boolean check = true;
			while (check) {
				System.out.println("You have selected student, enter the following information");
				System.out.println("Enter username");
				String user = in.readLine();
				System.out.println("Enter password:");
				String pass = in.readLine();
				student.setUsername(user);
				student.setPassword(pass);
				if (Admin.student_check(student)) {
					check = false;
				} else {
					System.out.println("Incorrect");
				}
			}
			
			while(true){
				System.out.println("You have logged in.");
				System.out.println("Type 'all' to see all courses");
				System.out.println("Type 'available' to see only avaiable courses");
				System.out.println("Type 'register' to register for course");
				System.out.println("Type 'withdraw' to withdraw from course");
				System.out.println("Type 'view' view the courses that you registered");
				String choice3 = in.readLine();

				if (choice3.contentEquals("all")) {
					student.view_courses_student_all();
					} 
				else if (choice3.contentEquals("available")) {
					student.view_open_courses_student();
					} 
				else if (choice3.contentEquals("register")) {
					student.register_courses_student();
					} 
				else if (choice3.contentEquals("withdraw")) {
					student.withdraw_courses_student();
					} 
				else if (choice3.contentEquals("view")) {
					student.view_registered_courses_student();
					} 
				else {
					serialization();
					break;
				}
			}
			

		} else {
			serialization();
		}

	}
}
