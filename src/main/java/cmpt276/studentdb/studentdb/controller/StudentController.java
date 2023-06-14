package cmpt276.studentdb.studentdb.controller;

import cmpt276.studentdb.studentdb.model.Student;
import cmpt276.studentdb.studentdb.model.StudentRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
    private Student currEditStudent;

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("student/view")
    public String getAllStudents(Model model) {
        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        model.addAttribute("edit", new Student());
        return "student/showStudents";
    }

    @PostMapping("student/view")
    public String processStudent(@RequestParam Map<String, String> newStudent, HttpServletResponse response, Model model) {
        String fullIdeImgPath;

        // Get attributes from form
        String newName = newStudent.get("nameTextBox");
        int newHeight = Integer.parseInt(newStudent.get("heightTextBox"));
        int newWeight = Integer.parseInt(newStudent.get("weightTextBox"));
        String newHairColour = newStudent.get("hairTextBox");
        float newGpa = Float.parseFloat(newStudent.get("gpaTextBox"));
        String newProf = newStudent.get("favProf");
        String newIde = newStudent.get("favIde");

        // Build img resource path for IDE choice
        fullIdeImgPath = Student.IMG_PATH + Student.IDE_STR_TO_IMG_PATH.get(newStudent.get("favIde"));
        String newIdeImgPath = fullIdeImgPath;
        studentRepo.save(new Student(newName, newHeight, newWeight, newHairColour, newGpa, newProf, newIde, newIdeImgPath));
        response.setStatus(201);

        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "redirect:/student/view";
    }

    @PostMapping("student/del")
    public String delStudent(@RequestParam Map<String, String> id, HttpServletResponse response, Model model) {
        System.out.println("GET user: " + id.get("studentId"));
        studentRepo.deleteById(Integer.parseInt(id.get("studentId")));
        response.setStatus(201);

        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "redirect:/student/view";
    }

    @PostMapping("student/edit")
    public String openEditStudent(@RequestParam Map<String, String> id, HttpServletResponse response, Model model) {
        int studentId = Integer.parseInt(id.get("studentId"));
        System.out.println("GET user: " + id.get("studentId"));
        Student student = studentRepo.getById(studentId);
        response.setStatus(201);

        model.addAttribute("edit", student);
        currEditStudent = student;
        return "student/editStudent";
    }

    @PostMapping("student/editStudent")
    public String editStudent(@RequestParam Map<String, String> editStudent, HttpServletResponse response, Model model) {
        String fullIdeImgPath;

        if (currEditStudent != null) {          // Update student attributes
            currEditStudent.setName(editStudent.get("nameTextBox"));
            currEditStudent.setHeight(Integer.parseInt(editStudent.get("heightTextBox")));
            currEditStudent.setWeight(Integer.parseInt(editStudent.get("weightTextBox")));
            currEditStudent.setHair(editStudent.get("hairTextBox"));
            currEditStudent.setGpa(Float.parseFloat(editStudent.get("gpaTextBox")));
            currEditStudent.setFavProf(editStudent.get("favProf"));
            currEditStudent.setFavIde(editStudent.get("favIde"));

            // Build img resource path for IDE choice
            fullIdeImgPath = Student.IMG_PATH + Student.IDE_STR_TO_IMG_PATH.get(editStudent.get("favIde"));
            currEditStudent.setImgIdePath(fullIdeImgPath);
            studentRepo.save(currEditStudent);
            currEditStudent = null;
        }
        response.setStatus(201);

        List<Student> students = studentRepo.findAll();
        model.addAttribute("students", students);
        return "redirect:/student/view";
    }
}
