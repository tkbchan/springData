package ph.globe.com.edo.springData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.globe.com.edo.springData.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
