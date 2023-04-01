package in.com.service;

import in.com.dao.IStudentDao;
import in.com.daofactory.StudentDaoFactory;
import in.com.dto.Student;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao= null;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		return studentDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		return studentDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sid) {
		
		studentDao = StudentDaoFactory.getStudentDao();
		
		return studentDao.deleteStudent(sid);
	}

}
