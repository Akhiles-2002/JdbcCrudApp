package in.com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.com.dto.Student;
import in.com.service.IStudentService;
import in.com.servicefactory.StudentServiceFactory;

public class MainControllerApp {

	public static void main(String[] args) throws IOException, Exception {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("************* WELCOME TO STUDENT MANAGEMENT APP **************");
		
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = scanner.next();    //br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}

	}
	
	private static void insertOperation() throws IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the student name :: ");
		String sname = br.readLine();
		
		System.out.print("Enter the student age :: ");
		int sage = scanner.nextInt();

		System.out.print("Enter the student address :: ");
		String saddress = br.readLine();

		String status = studentService.addStudent(sname, sage, saddress);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed....");
		}
		
	}
	
	private static void selectOperation()
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the student id ::");
		int sid = scanner.nextInt();
		
		Student student = studentService.searchStudent(sid);
		
		if(student != null)
		{
			System.out.println(student);
		}
		else
		{
			System.out.println("Record not found for given Student id ::"+sid);
		}
	}
	
	private static void deleteOperation()
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the student id ::");
		int sid = scanner.nextInt();
		
		String status = studentService.deleteStudent(sid);
		
		if(status.equalsIgnoreCase("Success")) 
		{
			System.out.println("Record Deleted Successfully...");
		}
		else if (status.equalsIgnoreCase("not found")) 
		{
			System.out.println("record not avilable for the given id ::" + sid);
		}
		else
		{
			System.out.println("Record not Deleted for Given id ::"+sid);
		}
	}
	
	private static void updateOperation() throws IOException
	{
		IStudentService studentService = StudentServiceFactory.getStudentService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the Student id to Updatation ::");
		String sid = br.readLine();
		
		Student student = studentService.searchStudent(Integer.parseInt(sid));
		
		if(student != null)
		{
			Student newStudent = new Student();
			
			System.out.println("Student id is :: " + student.getSid());
			newStudent.setSid(student.getSid());
			
			System.out.print("Student old name is ::"+student.getSname()+"\tEnter New Name ::");
			String newName = br.readLine();
			
			if(newName.equals("")||newName=="")
			{
				newStudent.setSname(student.getSname());
			}
			else
			{
				newStudent.setSname(newName);
			}
			
			System.out.print("Student oldAge is :: " + student.getSage() + "\tEnter newAge :: ");
			String newAge = br.readLine();
			
			if(newAge.equals("") || newAge == "")
			{
				newStudent.setSage(student.getSage());
			}
			else
			{
				newStudent.setSage(Integer.parseInt(newAge));
			}
			
			System.out.print("Student oldAddress is :: " + student.getSaddress() + "\tEnter newAddress :: ");
			String newAddress = br.readLine();
			
			if(newAddress.equals("") || newAddress == null)
			{
				newStudent.setSaddress(student.getSaddress());
			}
			else
			{
				newStudent.setSaddress(newAddress);
			}
			
			System.out.println("New Object Data is ::"+newStudent);
			System.out.println();
			
			String status = studentService.updateStudent(newStudent);
			
			if (status.equalsIgnoreCase("success"))
			{
				System.out.println("record updated succesfully");
			} 
			else 
			{
				System.out.println("record updation failed");
			}

		} 
		else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}
		
		
	}

}
