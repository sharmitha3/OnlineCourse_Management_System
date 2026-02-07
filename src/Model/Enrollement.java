package Model;

import java.util.ArrayList;
import java.util.List;

public class Enrollement {
    private Long id;
    private Student student;
    private Course course;
    private boolean paid;
    private Payment payment;
    private Certification certificate;
    private List<Assignment> assignments = new ArrayList<>();

    public Enrollement(Long id, Student student, Course course){
        this.id = id;
        this.student = student;
        this.course = course;
        this.paid = !course.isPaid();


        for(String a : course.getAssignments()){
            assignments.add(new Assignment(a));
        }
    }

    public Long getId(){
        return id;
    }
    public Student getStudent(){
        return student;
    }
    public Course getCourse(){
        return course;
    }
    public boolean isPaid(){
        return paid;
    }

    public void setPayment(Payment payment){
        this.payment = payment;
        this.paid = true;
    }

    public void setCertificate(Certification certificate){
        this.certificate = certificate;
    }

    public Certification getCertificate(){
        return certificate;
    }
    public List<Assignment> getAssignments(){
        return assignments;
    }

    public boolean allAssignmentsCompletedAndGraded(){
        for(Assignment a : assignments){
            if(!a.isCompleted() || a.getMarks() == null) return false;
        }
        return true;
    }

    public String toString(){
        return id + " " + student.getName() +
                " Course:" + course.getTitle() +
                " Paid:" + paid +
                " Certificate:" + (certificate != null ? certificate.getCode() : "None");
    }
}
