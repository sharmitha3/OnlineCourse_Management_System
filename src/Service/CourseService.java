package Service;

import Model.Course;
import Model.Instructor;
import Repo.Respositorydb;

public class CourseService {
    private Respositorydb repo;

    public CourseService(Respositorydb repo) {
        this.repo = repo;
    }


    public void addCourse(Long courseId, String title, Long instructorId, boolean paid) {
        Instructor instructor = null;
        for (Instructor i : repo.instructors) {
            if (i.getId().equals(instructorId)) {
                instructor = i;
                break;
            }
        }

        if (instructor != null) {
            Course c = new Course(courseId, title, instructor, paid);
            repo.courses.add(c);
            System.out.println("Course added: " + title + " by Instructor: " + instructor.getName());
        } else {
            System.out.println("Instructor not found!");
        }
    }


    public void addAssignmentToCourse(Long courseId, Long instructorId, String assignmentTitle) {
        for (Course c : repo.courses) {
            if (c.getId().equals(courseId)) {
                if (c.getInstructor().getId().equals(instructorId)) {
                    c.addAssignment(assignmentTitle);
                    System.out.println("Assignment added: " + assignmentTitle);
                } else {
                    System.out.println("Only the instructor can add assignments to this course.");
                }
                return;
            }
        }
        System.out.println("Course not found!");
    }


    public Course findCourse(Long id) {
        for (Course c : repo.courses) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }


    public void viewAllCourses() {
        if (repo.courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        System.out.println("Available courses:");
        for (Course c : repo.courses) {
            System.out.println(c);
        }
    }
}
