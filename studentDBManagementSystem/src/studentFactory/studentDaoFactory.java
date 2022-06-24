package studentFactory;

import studentDao.StudentDao;
import studentDao.studentDaoImpl;

public class studentDaoFactory {
     private static StudentDao studentDao;
     static {
    	 studentDao = new studentDaoImpl();
     }
     public static StudentDao getStudentdao() {
    	 return studentDao;
     }
}
