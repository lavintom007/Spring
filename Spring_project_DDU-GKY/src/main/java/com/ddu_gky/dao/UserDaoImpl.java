package com.ddu_gky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ddu_gky.model.Login;
import com.ddu_gky.model.Mark;
import com.ddu_gky.model.Register;
import com.ddu_gky.model.User;


public class UserDaoImpl implements UserDao
{
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public ArrayList<Mark> All(String s)
	{
		String sql="select * from student where stid='"+s+"'";
	List<Mark> mark=jdbcTemplate.query(sql,new ResultMapper());
		return (ArrayList<Mark>) mark;
		
	}
	
	
	public void register(User user)
	{
		String sql="insert into users values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {user.getFirstname(),user.getLastname(),user.getEmail(),user.getPassword()});
	}
	public User validateUser(Login login)
	{
		
		String sql="select * from users where email='"+login.getEmail() +"' and password='" +login.getPassword()+"'";
		List<User> users=jdbcTemplate.query(sql,new UserMapper());
		return users.size() >0 ? users.get(0):null;
	}
	
	public void student(Mark mark)
	{
		String sql="insert into student values(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {mark.getDate(),mark.getStid(),mark.getViva(),mark.getCompletion(),mark.getOverall()});
	}
	public Register validateStudent(Register register)
	{
		String sql="select * from login where stid='"+register.getStid()+"' and password='"+register.getPassword()+"'";
		System.out.println(sql);
		List<Register> register1=jdbcTemplate.query(sql,new RegisterMapper());
		return register1.size() >0 ? register1.get(0):null;
	}
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs,int arg1) throws SQLException {
		User user =new User();
		 
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}
}

class RegisterMapper implements RowMapper<Register> {
	public Register mapRow(ResultSet rs,int  arg1)throws SQLException {
		Register register= new Register();
		
		register.setStid(rs.getString("stid"));
		
		return register;
	}
	}
class ResultMapper implements RowMapper<Mark> {
	public Mark mapRow(ResultSet rs,int  arg1)throws SQLException {
		Mark register= new Mark();
		
		register.setStid(rs.getString("stid"));
		register.setDate(rs.getString("date"));
		register.setViva(rs.getString("viva"));
		register.setCompletion(rs.getString("completion"));
		register.setOverall(rs.getString("overall"));
		
		return register;
	}
	}
