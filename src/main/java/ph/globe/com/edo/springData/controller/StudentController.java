package ph.globe.com.edo.springData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ph.globe.com.edo.springData.converter.StudentConverter;
import ph.globe.com.edo.springData.dto.StudentDto;
import ph.globe.com.edo.springData.entity.Student;
import ph.globe.com.edo.springData.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/create-student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentConverter converter;

    @GetMapping("/all")
    public List<StudentDto> findAll() {
        List<Student> findAll = studentRepository.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/load/{studNo}")
    public StudentDto findById(@PathVariable(value = "studNo") Long studNo) {
        Student orElse = studentRepository.findById(studNo).orElse(null);
        return converter.entityToDto(orElse);

    }

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto dto) {
        Student student = converter.dtoToEntity(dto);
        student=  studentRepository.save(student);
        return converter.entityToDto(student);
    }

    @PutMapping("/update/{studNo}")
    public StudentDto update(@PathVariable(value = "studNo") Long studNo, @RequestBody Student student) {
        Optional<Student> studentData = studentRepository.findById(studNo);
        Student stud = studentData.get();
        stud.setFullName(student.getFullName());
        stud.setUsername(student.getUsername());
        stud.setPassword(student.getPassword());
        stud.setProgram(student.getProgram());
        stud.setAddress(student.getAddress());
        return converter.entityToDto(studentRepository.save(stud));
    }

    @DeleteMapping("/delete/{studNo}")
    public void deleteById(@PathVariable("studNo") long studNo){
        studentRepository.deleteById(studNo);
    }
}
