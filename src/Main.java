
import Repo.Respositorydb;
import Service.*;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



        public class Main {
            public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);
                Respositorydb repo = new Respositorydb();

                StudentService studentService = new StudentService(repo);
                InstructorService instructorService = new InstructorService(repo);
                CourseService courseService = new CourseService(repo);
                EnrollementService enrollmentService = new EnrollementService(repo);

                while (true) {
                    System.out.println("\n===== System Starts =====");
                    System.out.println("1. Add Student");
                    System.out.println("2. Add Instructor");
                    System.out.println("3. Add Course");
                    System.out.println("4. Add Assignment to Course (Instructor only)");
                    System.out.println("5. Enroll Student");
                    System.out.println("6. Payment");
                    System.out.println("7. Submit Assignment");
                    System.out.println("8. Grade Assignment (Instructor)");
                    System.out.println("9. View Enrollments");
                    System.out.println("0. Exit");
                    System.out.print("Enter choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Student ID: ");
                            Long sid = sc.nextLong();
                            System.out.print("Student Name: ");
                            String sname = sc.next();
                            studentService.addStudent(sid, sname);
                            break;

                        case 2:
                            System.out.print("Instructor ID: ");
                            Long iid = sc.nextLong();
                            System.out.print("Instructor Name: ");
                            String iname = sc.next();
                            instructorService.addInstructor(iid, iname);
                            break;

                        case 3:
                            System.out.print("Course ID: ");
                            Long cid = sc.nextLong();
                            System.out.print("Course Title: ");
                            String title = sc.next();
                            System.out.print("Instructor ID: ");
                            Long instId = sc.nextLong();
                            System.out.print("Paid? (true/false): ");
                            boolean paid = sc.nextBoolean();
                            courseService.addCourse(cid, title, instId, paid);
                            break;

                        case 4:
                            System.out.print("Course ID: ");
                            Long courseId = sc.nextLong();
                            System.out.print("Instructor ID: ");
                            Long instrId = sc.nextLong();
                            System.out.print("Assignment Title: ");
                            String assignmentTitle = sc.next();
                            courseService.addAssignmentToCourse(courseId, instrId, assignmentTitle);
                            break;

                        case 5:
                            System.out.print("Enrollment ID: ");
                            Long eid = sc.nextLong();
                            System.out.print("Student ID: ");
                            Long studentId = sc.nextLong();
                            System.out.println("Available courses:");
                            courseService.viewAllCourses();
                            System.out.print("Enter Course ID to enroll: ");
                            Long courseEnrollId = sc.nextLong();
                            enrollmentService.enrollStudent(eid, studentId, courseEnrollId);
                            break;

                        case 6:
                            System.out.print("Enrollment ID: ");
                            Long payEid = sc.nextLong();
                            System.out.print("Payment ID: ");
                            Long payId = sc.nextLong();
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            enrollmentService.pay(payEid, payId, amt);
                            break;

                        case 7:
                            System.out.print("Enrollment ID: ");
                            Long subEid = sc.nextLong();
                            System.out.print("Assignment Number to submit: ");
                            int assignmentIndex = sc.nextInt();
                            enrollmentService.submitAssignment(subEid, assignmentIndex);
                            break;

                        case 8:
                            System.out.print("Enrollment ID: ");
                            Long gradeEid = sc.nextLong();
                            System.out.print("Instructor ID: ");
                            Long instrid = sc.nextLong();
                            System.out.print("Assignment Number to grade: ");
                            int gradeIndex = sc.nextInt();
                            System.out.print("Marks: ");
                            int marks = sc.nextInt();
                            enrollmentService.gradeAssignment(gradeEid,instrid, gradeIndex, marks);
                            break;

                        case 9:
                            enrollmentService.viewEnrollments();
                            break;

                        case 0:
                            System.out.println("Exiting...");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Invalid choice. Try again!");
                    }
                }
            }
        }

