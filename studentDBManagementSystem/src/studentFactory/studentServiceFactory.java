package studentFactory;

import studentService.StudentService;
import studentService.studentServiceImpl;

public class studentServiceFactory {
	
	private static StudentService studentService;
	static {
		studentService=new studentServiceImpl();
	}
	
    public static StudentService getStudentService() {
    	return studentService;
    }
}
