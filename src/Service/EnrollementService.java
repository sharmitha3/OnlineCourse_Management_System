package Service;


import Model.*;
import Repo.Respositorydb;
import java.util.List;

public class EnrollementService {
    private Respositorydb repo;

    public EnrollementService(Respositorydb repo) {
        this.repo = repo;
    }


    public void enrollStudent(Long enrollmentId, Long studentId, Long courseId) {
        Student student = null;
        Course course = null;

        for (Student s : repo.students) if (s.getId().equals(studentId)) student = s;
        for (Course c : repo.courses) if (c.getId().equals(courseId)) course = c;

        if (student != null && course != null) {
            Enrollement e = new Enrollement(enrollmentId, student, course);
            repo.enrollments.add(e);
            System.out.println("Enrollment done! ID: " + enrollmentId);
        } else {
            System.out.println("Student or course not found!");
        }
    }


    public void pay(Long enrollmentId, Long paymentId, double amount) {
        for (Enrollement e : repo.enrollments) {
            if (e.getId().equals(enrollmentId)) {
                e.setPayment(new Payment(paymentId, amount));
                System.out.println("Payment completed for enrollment: " + enrollmentId);
                return;
            }
        }
        System.out.println("Enrollment not found!");
    }


    public void submitAssignment(Long enrollmentId, int assignmentIndex) {
        for (Enrollement e : repo.enrollments) {
            if (e.getId().equals(enrollmentId)) {
                List<Assignment> list = e.getAssignments();
                if (assignmentIndex < 1 || assignmentIndex > list.size()) {
                    System.out.println("Invalid assignment number.");
                    return;
                }
                list.get(assignmentIndex - 1).markCompleted();
                System.out.println("Assignment marked completed: " + list.get(assignmentIndex - 1).getTitle());
                return;
            }
        }
        System.out.println("Enrollment not found!");
    }


    public void gradeAssignment(Long enrollmentId, Long instructorId, int assignmentIndex, int marks) {
        for (Enrollement e : repo.enrollments) {
            if (e.getId().equals(enrollmentId)) {

             
                if (!e.getCourse().getInstructor().getId().equals(instructorId)) {
                    System.out.println("Only the assigned instructor can grade this course!");
                    return;
                }

                List<Assignment> list = e.getAssignments();
                if (assignmentIndex < 1 || assignmentIndex > list.size()) {
                    System.out.println("Invalid assignment number.");
                    return;
                }
                list.get(assignmentIndex - 1).setMarks(marks);
                System.out.println("Assignment graded: " + list.get(assignmentIndex - 1).getTitle());

                if (e.allAssignmentsCompletedAndGraded() && e.getCertificate() == null) {
                    e.setCertificate(new Certification(e.getId(),
                            "CERT-" + e.getCourse().getTitle() + "-" + e.getStudent().getName()));
                    System.out.println("Certificate generated for " + e.getStudent().getName());
                }
                return;
            }
        }
        System.out.println("Enrollment not found!");
    }


    public void viewEnrollments() {
        for (Enrollement e : repo.enrollments) {
            System.out.println(e);
        }
    }
}

