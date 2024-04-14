package io.elice.elcademy.subject.controller;

import io.elice.elcademy.subject.entity.Subject;
import io.elice.elcademy.subject.entity.SubjectPatchDto;
import io.elice.elcademy.subject.entity.SubjectPostDto;
import io.elice.elcademy.subject.mapper.SubjectMapper;
import io.elice.elcademy.subject.service.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/subjects")
public class SubjectViewController {

    private final SubjectService subjectService;
    private final SubjectMapper mapper;

    public SubjectViewController(SubjectService subjectService, SubjectMapper mapper) {
        this.subjectService = subjectService;
        this.mapper = mapper;
    }

    @GetMapping
    public String getSubjects(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Subject> subjectPage = subjectService.findSubjects(pageable);
        model.addAttribute("subjectPage", subjectPage);
        return "subjects";
    }

    @GetMapping("/sorted/asc")
    public String getSubjectsOrderedByPriceAsc(Model model,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Subject> subjectPage = subjectService.findAllSubjectsOrderedByPriceAsc(pageable);
        model.addAttribute("subjectPage", subjectPage);
        return "subjects";
    }

    @GetMapping("/sorted/desc")
    public String getSubjectsOrderedByPriceDesc(Model model,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "5") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Subject> subjectPage = subjectService.findAllSubjectsOrderedByPriceDesc(pageable);
        model.addAttribute("subjectPage", subjectPage);
        return "subjects";
    }

    @GetMapping("/add")
    public String addForm() {
        return "addSubjectForm";
    }

    @GetMapping("/{subjectId}")
    public String getSubjectDetail(@PathVariable long subjectId, Model model) {
        Subject subject = subjectService.findSubject(subjectId);
        model.addAttribute("subject", subject);
        return "subject";
    }

    @PostMapping("/add")
    public String addSubject(@ModelAttribute SubjectPostDto subjectPostDto, RedirectAttributes redirectAttributes) {
        Subject subject = subjectPostDto.toEntity();

        Subject createdSubject = subjectService.createSubject(subject);
        redirectAttributes.addAttribute("subjectId", createdSubject.getSubjectId());
        return "redirect:/subjects";
    }


    @GetMapping("/{subjectId}/edit")
    public String editForm(@PathVariable long subjectId, Model model) {
        Subject subject = subjectService.findSubject(subjectId);
        model.addAttribute("subject", subject);
        return "editSubjectForm";
    }

    @PostMapping("/{subjectId}/edit")
    public String updateSubject(@ModelAttribute SubjectPatchDto subjectPatchDto,
                                RedirectAttributes redirectAttributes) {
        Subject subject = mapper.subjectPatchDtoToSubject(subjectPatchDto);
        Subject updatedSubject = subjectService.updateSubject(subject);

        redirectAttributes.addAttribute("subjectId", updatedSubject.getSubjectId());
        redirectAttributes.addFlashAttribute("message", "과목이 수정되었습니다.");
        return "redirect:/subjects/{subjectId}";
    }


    @DeleteMapping("/{subjectId}")
    public String deleteSubject(@PathVariable long subjectId, RedirectAttributes redirectAttributes) {
        subjectService.deleteSubject(subjectId);
        redirectAttributes.addFlashAttribute("message", "과목이 제거되었습니다.");
        return "redirect:/subjects";
    }
}
