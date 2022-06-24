package studentService;

import studentDao.StudentDao;
import studentDto.Student;
import studentFactory.studentDaoFactory;

public class studentServiceImpl implements StudentService {

	public String addStudent(Student student) {
		StudentDao studentDao=studentDaoFactory.getStudentdao();
		String status=studentDao.add(student);
		return status;
	}

	public Student searchStudent(String sid) {
		StudentDao studentDao=studentDaoFactory.getStudentdao();
		Student student = studentDao.search(sid);
		return student;
	}

	public String updateStudent(Student newStudent) {
		StudentDao studentDao = studentDaoFactory.getStudentdao();
		String status = studentDao.update(newStudent);
		return status;
	}

	public String deleteStudent(String sid) {
		StudentDao studentDao = studentDaoFactory.getStudentdao();
		String status = studentDao.delete(sid);
		return status;
	}
}
