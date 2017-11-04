package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.CourseModel;
import com.example.model.StudentModel;
import com.example.service.StudentService;

@Controller
public class CourseController {
	@Autowired
    StudentService studentDAO;
	
	@RequestMapping("/course/view/{id_course}")
    public String viewPath (Model model,
            @PathVariable(value = "id_course") String id_course)
    {
        CourseModel course = studentDAO.selectCourse (id_course);

        if (course != null) {
            model.addAttribute ("course", course);
            return "view-course";
        } else {
            model.addAttribute ("id_course", id_course);
            return "not-found-course";
        }
    }
}
