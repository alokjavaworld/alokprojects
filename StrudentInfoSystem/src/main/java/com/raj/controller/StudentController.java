package com.raj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.raj.dto.StudentDTO;
import com.raj.model.Student;
import com.raj.servcie.IStudentService;

@Controller
public class StudentController {
	@Autowired
	private IStudentService service;

	@GetMapping(value = "/welcome")
	public String showHome() {
		return "home";
	}

	@GetMapping(value = "/studentinfo")
	public String showStudent(Map<String, Object> map) {
		List<StudentDTO> listdto = null;
		listdto = service.fetchStudent();
		map.put("studentinfo", listdto);
		return "StudentPage";
	}

	@GetMapping("/editStudent")
	public String editStudent(@RequestParam int rollNo, Map<String , Object>  map,@ModelAttribute Student student) {
		  StudentDTO dto=null;
		  //invoke method
		  dto=service.fetchStudentByRoll(rollNo);
		  //convert dto student
		  BeanUtils.copyProperties(dto, student);
		  return "editStudent";

     }
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student,RedirectAttributes redirect) {
		StudentDTO dto=new StudentDTO();
		 //convert student to dto
		BeanUtils.copyProperties(student, dto);
		//invoke method
		String result=service.updateStudent(dto);
		redirect.addFlashAttribute("result", result);
		return "redirect:studentinfo";
		
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam int rollNo,RedirectAttributes redirect) {
		 String result=service.deleteStudent(rollNo);
		 redirect.addFlashAttribute("result", result);
			return "redirect:studentinfo";
	}
   
	@GetMapping("/addStudent")
   public String addtudent(@ModelAttribute Student student) {
		student.setSname("ALOK");
	return "addStudent";
		
	}
 
	@PostMapping("/addStudent")
	public String registerStuddent(@ModelAttribute Student student , RedirectAttributes redirect) {
		
	StudentDTO dto =new StudentDTO();
	//convert student to dto
	dto.setSname(student.getSname());
	dto.setSadd(student.getSadd());
	dto.setMobile(student.getMobile());
	dto.setAadhar(student.getAadhar());
	dto.setFname(student.getFname());
	dto.setStd(student.getStd());
	//invoke method
	String result=service.insertStudent(dto);
	//add result in flash attributr 
	redirect.addFlashAttribute("result",result);
	return "redirect:studentinfo";
	}

	@PostMapping("/searchStudent")
public String searchStudent(@RequestParam String roll,Map<String,Object> map, @ModelAttribute Student student) {
	    int stuRoll= Integer.parseInt(roll);
	    System.out.println(stuRoll);
	    StudentDTO dto=service.fetchStudentByRoll(stuRoll);
	    BeanUtils.copyProperties(dto, student);
	    System.out.println(dto);
	    map.put("searchResult", dto);
		return "search";
}





}//class