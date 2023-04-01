package in.com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.com.dto.Student;
import in.com.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		
		String sqlInsertQuerty = "insert into student(`name`,`age`,`address`) values(?,?,?)";
		
		try{
			
			connection = JdbcUtil.getJdbcConnction();
			
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(sqlInsertQuerty);
			}
			
			if(preparedStatement != null)
			{
				preparedStatement.setString(1, sname);
				preparedStatement.setInt(2, sage);
				preparedStatement.setString(3, saddress);
				
				int rowAffected = preparedStatement.executeUpdate();
				
				if(rowAffected == 1)
				{
					return "Success";
				}
			}			
		}catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer sid) {
		
		String sqlSelectQuery = "select id,name,age,address from student where id = ?";
		Student student = null;
		
		try {
			connection = JdbcUtil.getJdbcConnction();
			
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(sqlSelectQuery);
			}
			if(preparedStatement != null)
			{
				preparedStatement.setInt(1, sid);
			}
			if(preparedStatement != null)
			{
				resultSet = preparedStatement.executeQuery();			
			}			
			
			if(resultSet != null)
			{
				if(resultSet.next())
				{
					student = new Student();
					
					// copy resultSet data to student object
					student.setSid(resultSet.getInt(1));
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));
					student.setSaddress(resultSet.getString(4));
					
					return student;
					
				}
			}
		}
		catch(SQLException | IOException e)
		{
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		
		String sqlUpdateQuery = "update student set name=?, age=?, address=? where id=?";
		
		try {
			
			connection = JdbcUtil.getJdbcConnction();
			
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			}
			if(preparedStatement != null)
			{
				preparedStatement.setString(1, student.getSname());
				preparedStatement.setInt(2, student.getSage());
				preparedStatement.setString(3, student.getSaddress());
				preparedStatement.setInt(4, student.getSid());
				
				int rowAffected = preparedStatement.executeUpdate();
				
				if(rowAffected == 1)
				{
					return "Success";
				}
				else
				{
					return "failure";
				}
				
			}
			
		}catch(SQLException | IOException se)
		{
			se.printStackTrace();
		}
		
		return "failure";
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery = "delete from student where id = ?";
		
		try
		{
			connection = JdbcUtil.getJdbcConnction();
			
			if(connection != null)
			{
				preparedStatement = connection.prepareStatement(sqlDeleteQuery);
			}
			if(preparedStatement != null)
			{
				preparedStatement.setInt(1, sid);
				
				int rowAffected = preparedStatement.executeUpdate();
				
				if(rowAffected == 1)
				{
					return "success";
				}
				else
				{
					return "not found";
				}
			}
		}
			catch(SQLException | IOException se){
				se.printStackTrace();
				
				return "failure";
			}
			
			
		return "failure";
	}

}
