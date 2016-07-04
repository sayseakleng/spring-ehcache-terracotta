package com.mcnc.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mcnc.mybatis.dto.StudentDTO;
@Repository
public interface StudentDAO {
	int create(StudentDTO stud);
	List< StudentDTO > getStudents();
	StudentDTO getStudentById(int id);
	int deleteById(int id);
}
