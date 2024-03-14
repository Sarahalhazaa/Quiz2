package com.example.quiz2.Service;

import com.example.quiz2.Model.Student;
import com.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Service
public class SchoolService {
    ArrayList<Student>students= new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Student> get(){
        return students;
    }

    public void add(Student student){
        students.add(student);
    }

    public boolean update(String id , Student student) {

      for (int i = 0 ; i < students.size();i++){
            if (students.get(i).getId().equalsIgnoreCase(id)){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id){
        for (int i = 0 ; i < students.size();i++){
            if (students.get(i).getId().equalsIgnoreCase(id)){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }
    public void addTeacher(Teacher teacher){
       teachers.add(teacher);
    }

    public boolean updateTeacher(String id , Teacher teacher) {

        for (int i = 0 ; i < teachers.size();i++){
            if (teachers.get(i).getId().equalsIgnoreCase(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id){
        for (int i = 0 ; i < teachers.size();i++){
            if (teachers.get(i).getId().equalsIgnoreCase(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public Teacher Teacher(String id){
        for (int i = 0 ; i < teachers.size();i++){
            if (teachers.get(i).getId().equalsIgnoreCase(id)){
                return teachers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Teacher> searchSalary(int salary){
        ArrayList<Teacher> teachers1 = new ArrayList<>();
        for (int i = 0 ; i < teachers.size();i++){
            if (teachers.get(i).getSalary()>= salary){
               teachers1.add(teachers.get(i));
            }
        }
        return teachers1;
    }

    public Student nameStudent(String name){
        for (int i = 0 ; i < students.size();i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> searchMajor (String major){
        ArrayList<Student> students1 = new ArrayList<>();
        for (int i = 0 ; i < students.size();i++){
            if (students.get(i).getMajor().equalsIgnoreCase(major)){
                students1.add(students.get(i));
            }
        }
        return students1;
    }



}
