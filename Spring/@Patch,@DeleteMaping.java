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
    private final SubjectMapper mapper;

    public SubjectController(SubjectService subjectService, SubjectMapper mapper) {
        this.subjectService = subjectService;
        this.mapper = mapper;
    }
		
	  // 과목 수정
    @PatchMapping("/{subjectId}")
    public ResponseEntity<Subject> patchSubject(@RequestBody SubjectPatchDto subjectPatchDto, @PathVariable Long subjectId) {
        subjectPatchDto.setSubjectId(subjectId);
        Subject subject = mapper.subjectPatchDtoToSubject(subjectPatchDto);       //mapper를 사용하여 DTO 객체를 엔티티 객체로 매핑
        return new ResponseEntity<>(subjectService.updateSubject(subject), HttpStatus.OK);        
    }
    // 과목 삭제
    @DeleteMapping("/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
