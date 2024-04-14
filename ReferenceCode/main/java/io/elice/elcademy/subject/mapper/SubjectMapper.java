package io.elice.elcademy.subject.mapper;

import io.elice.elcademy.subject.entity.Subject;
import io.elice.elcademy.subject.entity.SubjectPatchDto;
import io.elice.elcademy.subject.entity.SubjectResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject subjectPatchDtoToSubject(SubjectPatchDto subjectPatchDto);

    SubjectResponseDto subjectToSubjectResponseDto(Subject subject);
}
