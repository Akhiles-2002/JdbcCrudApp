package in.com.dao;

import in.com.dto.Student;

public interface IStudentDao {
	
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);

}
