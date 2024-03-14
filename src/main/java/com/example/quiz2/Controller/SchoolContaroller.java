package com.example.quiz2.Controller;

import com.example.quiz2.Api.ApiResponse;
import com.example.quiz2.Model.Student;
import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/vi/school")
@RestController
@RequiredArgsConstructor
public class SchoolContaroller {

    private final SchoolService schoolService;

    @GetMapping("/get")
    public ResponseEntity get(){
        ArrayList<Student> students = schoolService.get();
        return ResponseEntity.status(200).body(students);

    }
    @PostMapping("/add")
    public ResponseEntity add( @RequestBody @Valid Student student , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        schoolService.add(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));

    }
@PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody @Valid Student student , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
       boolean isUpdated= schoolService.update(id,student);
        if(isUpdated){
        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("Student not updated"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){

        boolean isdeleted= schoolService.delete(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Student not deleted"));

    }

    @GetMapping("/getTeacher")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers = schoolService.getTeachers();
        return ResponseEntity.status(200).body(teachers);

    }
@PostMapping("addTeacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        schoolService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));

    }
@PutMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= schoolService.updateTeacher(id, teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not updated"));

    }
    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){

        boolean isdeleted= schoolService.deleteTeacher(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not deleted"));

    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity Teacher(@PathVariable String id) {
        Teacher teacher = schoolService.Teacher(id);
        if (teacher == null) {
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not found"));
    }
        return ResponseEntity.status(200).body(new ApiResponse("Teacher found"+teacher));
    }

    @GetMapping("/searchSalary/{salary}")
    public ResponseEntity searchSalary(@PathVariable int salary){
        ArrayList<Teacher> teachers1 = schoolService.searchSalary(salary);
        return ResponseEntity.status(200).body(teachers1);

    }

    @GetMapping("/nameStudent/{name}")
    public ResponseEntity nameStudent(@PathVariable String name ){
        Student student = schoolService.nameStudent(name);
        if (student == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Student found"+student));
    }

    @GetMapping("/searchMajor/{major}")
    public ResponseEntity searchMajor (@PathVariable String major){
        ArrayList<Student> student1 = schoolService.searchMajor(major);
        return ResponseEntity.status(200).body(student1);

    }



}
