package com.cttic.service.inter;

import java.util.List;

import com.cttic.service.domain.primary.Teacher1;

public interface TeacherServiceRepo {
	void createTeacher(Teacher1 teacher);

	List<Teacher1> getTeacher();

	List<Teacher1> getPageContent(int page, int size);

	List<Teacher1> getNamePageContent(int page, int size, String name);

	List<Teacher1> findByName(String name);

}
