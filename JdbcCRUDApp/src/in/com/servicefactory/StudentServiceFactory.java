package in.com.servicefactory;

import in.com.service.IStudentService;
import in.com.service.StudentServiceImpl;

public class StudentServiceFactory {

	//No one can create object of StudentServiceFactory causes of Private Constructor
	private StudentServiceFactory()
	{
		
	}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService()
	{
		if(studentService == null)
		{
		studentService = new StudentServiceImpl();
		}
		return studentService;
	}
	
}
