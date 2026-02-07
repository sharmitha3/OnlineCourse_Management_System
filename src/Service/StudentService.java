package Service;


import Model.Student;
import Repo.Respositorydb;

public class StudentService {
    private Respositorydb repo;

    public StudentService(Respositorydb repo) {
        this.repo = repo;
    }

    public void addStudent(Long id, String name) {
        Student s = new Student(id, name);
        repo.students.add(s);
        System.out.println("Student added: " + s.getName());
    }

    public Student findStudent(Long id) {
        for (Student s : repo.students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }
}
