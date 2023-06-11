package cmpt276.studentdb.studentdb.controller;

import cmpt276.studentdb.studentdb.model.Student;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    
    @GetMapping("student/view")
    public String getAllStudents(Model model) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Moo", 100, 200, "brown"));
        students.add(new Student("Bob", 176, 310, "black"));
        students.add(new Student("George", 123, 230, "brown"));
        students.add(new Student("Mary", 134, 100, "blonde"));

        model.addAttribute("students", students);
        return "student/showStudents";
    }
    

    @PostMapping("student/add")
    public String processStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response, Model model) {
        List<Student> students = new ArrayList<Student>();
        String newName = newStudent.get("name");
        int newHeight = Integer.parseInt(newStudent.get("height"));
        int newWeight = Integer.parseInt(newStudent.get("weight"));
        String newHairColour = newStudent.get("hair");
        int newGpa = Integer.parseInt(newStudent.get("gpa"));
        students.add(new Student(newName, newHeight, newWeight, newHairColour));
        response.setStatus(201);
        model.addAttribute("students", students);
        return "student/showStudents";
    }
    


}
