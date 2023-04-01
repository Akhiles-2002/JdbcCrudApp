package in.com.daofactory;

import in.com.dao.IStudentDao;
import in.com.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	//No one can create object of StudentDaoFactory causes of Private Constructor 
	private StudentDaoFactory()
	{
		
	}
	
	private static IStudentDao studentDao = null;
	
	public static IStudentDao getStudentDao()
	{
		if(studentDao == null)
		{
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
	

}
