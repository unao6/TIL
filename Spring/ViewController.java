package io.elice.elcademy.subject.controller;

import io.elice.elcademy.subject.entity.Subject;
import io.elice.elcademy.subject.entity.SubjectPatchDto;
import io.elice.elcademy.subject.entity.SubjectPostDto;
import io.elice.elcademy.subject.mapper.SubjectMapper;
import io.elice.elcademy.subject.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
// 핸들러 메서드가 호출되었을 때 뷰가 반환될 수 있도록 하는 어노테이션
@Controller
@RequestMapping("/subjects")
public class SubjectViewController {

    private final SubjectService subjectService;
    private final SubjectMapper mapper;

    public SubjectViewController(SubjectService subjectService, SubjectMapper mapper) {
        this.subjectService = subjectService;
        this.mapper = mapper;
    }

    // 과목 목록 조회. 조회된 과목 목록을 모델에 추가하고 뷰를 반환
    @GetMapping
    public String getSubjects(Model model) {
        List<Subject> subjects = subjectService.findSubjects();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }
    // 특정 과목의 상세 정보 조회 페이지. 조회된 과목을 모델에 추가하고 뷰를 반환
    @GetMapping("/{subjectId}")
    public String getSubjectDetail(@PathVariable long subjectId, Model model) {
        Subject subject = subjectService.findSubject(subjectId);
        model.addAttribute("subject", subject);
        return "subject";
    }

    // 새로운 과목 추가 페이지로 이동
    @GetMapping("/add")
    public String addForm() {
        return "addSubjectForm";
    }
    // 새로운 과목 추가. @ModelAttribute로 요청데이터를 받아와서 Dto객체에 담아서 전달. subjects 뷰로 리다이렉트
    @PostMapping("/add")
    public String addSubject(@ModelAttribute SubjectPostDto subjectPostDto, RedirectAttributes redirectAttributes) {
        Subject subject = subjectPostDto.toEntity();
        Subject createdSubject = subjectService.createSubject(subject);
        redirectAttributes.addAttribute("subjectId", createdSubject.getSubjectId());
        return "redirect:/subjects";
    }

    // 과목 수정 페이지 이동
    @GetMapping("/{subjectId}/edit")
    public String editForm(@PathVariable long subjectId, Model model) {
        Subject subject = subjectService.findSubject(subjectId);
        model.addAttribute("subject", subject);
        return "editSubjectForm";
    }    
    // 과목 수정
    @PostMapping("/{subjectId}/edit")
    public String updateSubject(@PathVariable Long subjectId, @ModelAttribute SubjectPatchDto subjectPatchDto, RedirectAttributes redirectAttributes) {
        subjectPatchDto.setSubjectId(subjectId);
        Subject subject = mapper.subjectPatchDtoToSubject(subjectPatchDto);
        Subject updatedSubject = subjectService.updateSubject(subject);
        redirectAttributes.addAttribute("subjectId", updatedSubject.getSubjectId());
        redirectAttributes.addAttribute("message", "과목이 수정되었습니다.");
        return "redirect:/subjects/{subjectId}";
    }

    // 과목 삭제
    @DeleteMapping("/{subjectId}")
    public String deleteSubject(@PathVariable Long subjectId, RedirectAttributes redirectAttributes) {
        subjectService.deleteSubject(subjectId);
        redirectAttributes.addAttribute("message", "과목이 제거되었습니다.");
        return "redirect:/subjects";
    }
}
