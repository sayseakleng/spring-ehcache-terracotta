package com.mcnc.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcnc.mybatis.dto.StudentDTO;
import com.mcnc.mybatis.service.StudentService;

import net.sf.ehcache.Element;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CacheManager cacheManager;
	
	@RequestMapping("/cache/refresh")
	public boolean refreshCacheData() {
		Cache cache = cacheManager.getCache("cluster-students");
		cache.clear();
		
		List<StudentDTO> students = studentService.getStudents();
		return students.size() > 0;
	}
	
	@RequestMapping("/cache/data")
	public Object  getCacheData() {
		Object objectValue = null;
		
		try {
			Cache cache = cacheManager.getCache("cluster-students");
			net.sf.ehcache.Cache ehCache = (net.sf.ehcache.Cache) cache.getNativeCache();
			List<?> keysWithExpiryCheck = ehCache.getKeysWithExpiryCheck();
			if(keysWithExpiryCheck.size() > 0) {
				Element element = ehCache.get(keysWithExpiryCheck.get(0));
				objectValue = element.getObjectValue();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectValue;
	}
}
