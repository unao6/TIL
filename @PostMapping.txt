package io.elice.elcademy.subject.controller;

import io.elice.elcademy.subject.entity.SubjectPatchDto;
import io.elice.elcademy.subject.entity.SubjectPostDto;
import io.elice.elcademy.subject.entity.Subject;
import io.elice.elcademy.subject.mapper.SubjectMapper;
import io.elice.elcademy.subject.service.SubjectService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService, SubjectMapper mapper) {
        this.subjectService = subjectService;
    }
		
	// 특정 과목 생성 
    @PostMapping
    public ResponseEntity postSubject(@RequestBody SubjectPostDto subjectPostDto) {

        Subject subject =  subjectPostDto.toEntity();
        Subject newSubject = subjectService.createSubject(subject);
        
        if(newSubject == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);        //응답코드(404)
        }

        return new ResponseEntity<>(newSubject, HttpStatus.CREATED);  //응답코드(201)
    }
}
