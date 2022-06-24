package studentController;

import java.io.*;

import studentDto.Student;
import studentFactory.studentServiceFactory;
import studentService.StudentService;

public class StudentMain {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String sid = "",sname = "",saddr = "";
			String status = "";
			Student student = null;
			StudentService studentService = studentServiceFactory.getStudentService();

			while(true) {
				System.out.println();
				System.out.println("1. ADD STUDENT ");
				System.out.println("2. SEARCH STUDENT ");
				System.out.println("3. UPDATE STUDENT ");
				System.out.println("4. DELETE STUDENT ");
				System.out.println("5. EXIT ");
				
				System.out.print(" Your Choice : ");
				int opt= Integer.parseInt(br.readLine());
				
				System.out.println();
				
				switch(opt) {
				     case 1:
				    	 System.out.println(" ADD STUDENT ");
				    	 System.out.print(" Student ID - ");
				    	 sid=br.readLine();
				    	 System.out.print(" Student Name - ");
				    	 sname=br.readLine();
				    	 System.out.print(" Student Address - ");
				    	 saddr=br.readLine();
				    	 
				    	 student = new Student();
				    	 student.setSid(sid);
				    	 student.setSname(sname);
				    	 student.setSaddr(saddr);
				    	 
				    	 status = studentService.addStudent(student);
				    	 
				    	 if(status.equalsIgnoreCase("Success"))
				    		 System.out.println(" Student Added Successfully ");
				    	 if(status.equalsIgnoreCase("Existed"))
				    		 System.out.println(" Student Existed Already ");
				    	 if(status.equalsIgnoreCase("Failure"))
				    		 System.out.println(" Student Insertion Failure ");
				    	 
				    	 break;
				    	 
				     case 2:
				    	 System.out.println(" SEARCH STUDENT ");
				    	 System.out.print(" Student ID - ");
				    	 sid=br.readLine();
				    	 
				    	 student = studentService.searchStudent(sid);
				    	 if(student==null)
				    		 System.out.println(" Student not Existed ");
				    	 else {
				    		 System.out.println(" Student Existed ");
				    		 System.out.println(" STUDENT DETAILS ");
				    		 System.out.println("----------------------------");
				    		 System.out.println("Student ID - "+student.getSid());
				    		 System.out.println("Student NAME - "+student.getSname());
				    	 }
				    		 break;
				    		 
				     case 3:
				    	 System.out.println(" UPDATE STUDENT ");
				    	 System.out.print(" Student ID - ");
				    	 sid=br.readLine();
				    	 student = studentService.searchStudent(sid);
				    	 if(student==null)
				    		 System.out.println(" Student not Existed ");
				    	 else {
				    		 System.out.print("Student Name [Old : "+student.getSname()+" ] New : ");
				    		 sname=br.readLine();
				    		 System.out.print("Student Address [Old : "+student.getSaddr()+" ] New : ");
                             saddr = br.readLine();
                             
                             Student newStudent = new Student();
                             
                             newStudent.setSid(sid);
                             newStudent.setSname(sname);
                             newStudent.setSaddr(saddr);
                             
                             status = studentService.updateStudent(newStudent);
                             
                             if(status.equalsIgnoreCase("Success"))
    				    		 System.out.println(" Student Updated Successfully ");
                             if(status.equalsIgnoreCase("Failure"))
    				    		 System.out.println(" Student Updation Failure ");                             
				    	 }
				    	 break;
				     case 4:
				    	 System.out.println(" DELETE STUDENT ");
				    	 System.out.print(" Student ID - ");
				    	 sid=br.readLine();
				    	 
				    	 status = studentService.deleteStudent(sid);
				    	 
				    	 if(status.equalsIgnoreCase("Success"))
				    		 System.out.println(" Student Deleted Successfully ");
				    	 if(status.equalsIgnoreCase("Not Existed"))
				    		 System.out.println(" Student not Existed ");
                         if(status.equalsIgnoreCase("Failure"))
				    		 System.out.println(" Student Deletion Failure ");
				    	 break;
				     case 5:
				    	 System.out.println(" EXIT ");
				    	 
				    	 System.exit(0);
				    	 break;
				     default:
				    	 System.out.println(" Wrong choice selected ");
				    	 break;
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
