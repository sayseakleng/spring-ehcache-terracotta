package com.mcnc.mybatis.service;

import java.util.List;

import com.mcnc.mybatis.dto.StudentDTO;

public interface StudentService {
	
	boolean create(StudentDTO stud);
	
	List< StudentDTO > getStudents();
	
	StudentDTO getStudentById(int id);
	
	boolean deleteById(int id);
	
}
