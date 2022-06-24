package studentService;

import studentDto.Student;

public interface StudentService {
      public String addStudent(Student student);
      public Student searchStudent(String sid);
      public String updateStudent(Student newStudent);
      public String deleteStudent(String sid);
}
