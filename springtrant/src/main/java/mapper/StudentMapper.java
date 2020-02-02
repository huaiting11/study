package mapper;

import bean.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    public Student findStudentById(int id);
    public int updateAcc(Student student);
}
