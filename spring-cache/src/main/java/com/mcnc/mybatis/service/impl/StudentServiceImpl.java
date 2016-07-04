package com.mcnc.mybatis.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mcnc.mybatis.dao.StudentDAO;
import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.service.StudentService;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDAO dao;
	
	
	@Override
	public boolean create(StudentDTO stud) {
		return dao.create(stud) > 0;
	}
	
	@Override
	public List<StudentDTO> getStudents() {
		return dao.getStudents();
	}

	@Override
	public StudentDTO getStudentById(int id) {
		return dao.getStudentById( id );
	}

	@Override
	public boolean deleteById(int id) {
		return dao.deleteById(id) > 0;
	}
}
