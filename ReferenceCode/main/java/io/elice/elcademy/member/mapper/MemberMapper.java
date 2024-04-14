package io.elice.elcademy.member.mapper;

import io.elice.elcademy.member.entity.Member;
import io.elice.elcademy.member.entity.MemberPostDto;
import io.elice.elcademy.member.entity.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    MemberResponseDto memberToMemberResponseDto(Member member);

}
