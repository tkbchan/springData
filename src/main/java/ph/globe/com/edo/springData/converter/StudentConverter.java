package ph.globe.com.edo.springData.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ph.globe.com.edo.springData.dto.StudentDto;
import ph.globe.com.edo.springData.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentConverter {
    public StudentDto entityToDto(Student student){
        ModelMapper mapper = new ModelMapper();
        StudentDto map = mapper.map(student, StudentDto.class);
        return map;
    }

    public List<StudentDto> entityToDto(List<Student> student) {
        return student.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Student dtoToEntity(StudentDto dto){
        ModelMapper mapper = new ModelMapper();
        Student map = mapper.map(dto, Student.class);
        return map;
    }

    public List<Student> dtoToEntity(List<StudentDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
