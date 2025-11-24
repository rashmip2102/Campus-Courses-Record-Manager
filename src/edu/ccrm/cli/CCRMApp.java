
package edu.ccrm.cli;

import edu.ccrm.service.*;
import java.util.List;
import java.util.Scanner;

public class CCRMApp {
    private static final Scanner in = new Scanner(System.in);
    
    private static final StudentService studentService = new StudentServiceImpl();
    private static final CourseService courseService = new CourseServiceImpl();
    private static final EnrollmentService enrollmentService = new EnrollmentServiceImpl();
    private static final TranscriptService transcriptService = new TranscriptServiceImpl();

    public static void main(String[] args) throws Exception {
        printWelcomeMessage();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getUserChoice(1, 7);

            switch (choice) {
                case 1: manageStudents(); break;
                case 2: manageCourses(); break;
                case 3: manageEnrollments(); break;
                case 4: viewTranscripts(); break;
                case 5: importExportData(); break;
                case 6: backupData(); break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;
            }
        }
        in.close();
    }
    
    private static void printWelcomeMessage() {
        System.out.println("Welcome to Campus Course Records Manager (CCRM)\n");
    }
    private static void printMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollments");
        System.out.println("4. View Transcripts");
        System.out.println("5. Import/Export Data");
        System.out.println("6. Backup Data");
        System.out.println("7. Exit");
        System.out.print("Enter choice (1-7): ");
    }
    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice < min || choice > max) {
                    System.out.print("Invalid choice. Enter a number between " + min + " and " + max + ": ");
                }
            } else {
                System.out.print("Not a number. Please enter a valid choice: ");
                in.next(); 
            }
        }
        in.nextLine();
        return choice;
    }
    
    private static void manageStudents() {
    	System.out.println("\nManage Students selected.");
        boolean inStudentMenu = true;

        while (inStudentMenu) {
            System.out.println("\nStudent Management:");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Deactivate Student");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice (1-4): ");

            int choice = getUserChoice(1, 4);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    deactivateStudent();
                    break;
                case 4:
                    inStudentMenu = false;
                    break;
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = in.nextLine();

        System.out.print("Enter Registration Number: ");
        String regNo = in.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = in.nextLine();

        System.out.print("Enter Middle Name (or leave blank): ");
        String middleName = in.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = in.nextLine();

        System.out.print("Enter Email: ");
        String email = in.nextLine();

        java.time.LocalDate enrollmentDate= java.time.LocalDate.now();

        java.time.LocalDate dateOfBirth = java.time.LocalDate.now();

        java.util.List<String> enrolledCourses= new java.util.ArrayList<String>();
        edu.ccrm.domain.Name name = new edu.ccrm.domain.Name(firstName, middleName, lastName);
        edu.ccrm.domain.Student student = new edu.ccrm.domain.Student(id, regNo, name, email, dateOfBirth, enrollmentDate, enrolledCourses);

        studentService.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void listStudents() {
        System.out.println("\nListing all students:");
        List<edu.ccrm.domain.Student> students = studentService.listStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (edu.ccrm.domain.Student s : students) {
            System.out.println(s.getRegNo() + ": " + s.getName().getFullName() + " (" + s.getEmail() + ")");
        }
    }

    private static void deactivateStudent() {
        System.out.print("Enter Registration Number of student to deactivate: ");
        String regNo = in.nextLine();
        edu.ccrm.domain.Student student = studentService.findStudentByRegNo(regNo);
        if (student != null) {
            student.setActive(false);
            System.out.println("Student " + regNo + " deactivated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void manageCourses() {
        System.out.println("\nManage Courses selected.");
        boolean inCourseMenu = true;

        while (inCourseMenu) {
            System.out.println("\nCourse Management:");
            System.out.println("1. Add Course");
            System.out.println("2. List Courses");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice (1-3): ");

            int choice = getUserChoice(1, 3);

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    listCourses();
                    break;
                case 3:
                    inCourseMenu = false;
                    break;
            }
        }
    }

    private static void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = in.nextLine();

        System.out.print("Enter Course Title: ");
        String title = in.nextLine();

        System.out.print("Enter Credits: ");
        int credits = Integer.parseInt(in.nextLine());

        System.out.print("Enter Department: ");
        String department = in.nextLine();

        // For prototype, assign a dummy instructor and semester
        edu.ccrm.domain.Instructor instructor = null;
        edu.ccrm.domain.Semester semester = edu.ccrm.domain.Semester.FALL;

        edu.ccrm.domain.Courses course = new edu.ccrm.domain.Courses(code, title, credits, instructor, semester, department);
        courseService.addCourse(course);
        System.out.println("Course added successfully.");
    }

    private static void listCourses() {
        System.out.println("\nListing all courses:");
        List<edu.ccrm.domain.Courses> courses = courseService.listCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        for (edu.ccrm.domain.Courses c : courses) {
            System.out.println(c.getCode() + ": " + c.getTitle() + " (" + c.getCredits() + " credits), Dept: " + c.getDepartment());
        }
    }
    
    private static void manageEnrollments() {
        System.out.println("\nManage Enrollments selected.");
        boolean inEnrollmentMenu = true;

        while (inEnrollmentMenu) {
            System.out.println("\nEnrollment Management:");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. Unenroll Student from Course");
            System.out.println("3. List Enrollments");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice (1-4): ");

            int choice = getUserChoice(1, 4);

            switch (choice) {
                case 1:
                    enrollStudent();
                    break;
                case 2:
                    unenrollStudent();
                    break;
                case 3:
                    listEnrollments();
                    break;
                case 4:
                    inEnrollmentMenu = false;
                    break;
            }
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter Student RegNo: ");
        String regNo = in.nextLine();
        edu.ccrm.domain.Student student = studentService.findStudentByRegNo(regNo);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String code = in.nextLine();
        edu.ccrm.domain.Courses course = courseService.findCourseByCode(code);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        enrollmentService.enrollStudent(student, course);
        System.out.println("Student enrolled successfully.");
    }

    private static void unenrollStudent() {
        System.out.print("Enter Student RegNo: ");
        String regNo = in.nextLine();
        edu.ccrm.domain.Student student = studentService.findStudentByRegNo(regNo);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code: ");
        String code = in.nextLine();
        edu.ccrm.domain.Courses course = courseService.findCourseByCode(code);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        enrollmentService.unenrollStudent(student, course);
        System.out.println("Student unenrolled successfully.");
    }

    private static void listEnrollments() {
        System.out.println("\nListing all enrollments:");
        List<edu.ccrm.domain.Enrollment> enrollments = enrollmentService.listEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }
        for (edu.ccrm.domain.Enrollment e : enrollments) {
            System.out.println(e.getStudent().getRegNo() + " enrolled in " + e.getCourse().getCode());
        }
    }
    private static void viewTranscripts() {
        System.out.println("\nView Transcripts selected.");
        System.out.print("Enter Student RegNo for Transcript: ");
        String regNo = in.nextLine();
        edu.ccrm.domain.Student student = studentService.findStudentByRegNo(regNo);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        List<edu.ccrm.domain.Enrollment> enrollments = enrollmentService.listEnrollments();
        List<edu.ccrm.domain.Enrollment> studentEnrollments = new java.util.ArrayList<>();
        for (edu.ccrm.domain.Enrollment e : enrollments) {
            if (e.getStudent().getRegNo().equals(regNo)) {
                studentEnrollments.add(e);
            }
        }

        String transcript = transcriptService.generateTranscript(student, studentEnrollments);
        System.out.println("\n" + transcript);
    }
    private static void importExportData() throws Exception {
        System.out.println("\nImport/Export Data selected.");
        System.out.println("Service Unavailable");
    }
    private static void backupData() {
        System.out.println("\nBackup Data selected.");
        System.out.println("This is a prototype. Service Unavailable!");
    }
}
