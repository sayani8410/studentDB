package studentDao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import studentDto.Student;
import studentFactory.ConnectionFactory;

public class studentDaoImpl implements StudentDao {

	public String add(Student student) {
		String status = "";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st= con.createStatement();
			Student std = search(student.getSid());
			if(std == null) {
				int rowCount = st.executeUpdate(" insert into Student values('"+student.getSid()+"','"+student.getSname()+"','"+student.getSaddr()+"')");
			    if(rowCount==1)
			    	status = "Success";
			    else
			    	status = "Failure";
			}else 
				status = "Existed";
		}catch(Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from Student where SID = '"+sid+"'");
			boolean b= rs.next();
			if(b==true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			}else {
				student = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	public String update(Student newStudent) {
		String status ="";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st= con.createStatement();
			int rowCount = st.executeUpdate("update Student set SNAME ='"+newStudent.getSname()+"',SADDR='"+newStudent.getSaddr()+"' where SID = '"+newStudent.getSid()+"'");
		    if(rowCount == 1)
		    	status = "Success";
		    else
		    	status = "Failure";
		}catch(Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	public String delete(String sid) {
		String status="";
		try {
			Connection con = ConnectionFactory.getConnection();
			Statement st= con.createStatement();
			Student student = search(sid);
			if(student == null)
				status = "Not Existed";
			else {
				int rowCount = st.executeUpdate("delete from student where SID ='"+sid+"'");
				if(rowCount == 1)
			    	status = "Success";
			    else
			    	status = "Failure";
			}
				
		}catch(Exception e){
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

}
