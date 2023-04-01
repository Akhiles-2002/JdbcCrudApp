package in.com.service;

import in.com.dto.Student;

public interface IStudentService {
	
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);

}
