package com.example.gwaze.member.service;

import com.example.gwaze.member.dto.CreateMemberRequest;
import com.example.gwaze.member.dto.CreateMemberResponse;
import com.example.gwaze.member.dto.GetMemberResponse;
import com.example.gwaze.member.entity.Member;
import com.example.gwaze.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {
        Member member = new Member(request.getName());
        Member savedMember = memberRepository.save(member);
        return new CreateMemberResponse(
                savedMember.getMemberId(),
                savedMember.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<GetMemberResponse> findAllMember() {
        List<Member> members = memberRepository.findAll();
        List<GetMemberResponse> dtos = new ArrayList<>();

        for (Member member : members) {
            GetMemberResponse dto = new GetMemberResponse(
                    member.getMemberId(),
                    member.getName()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetMemberResponse findOneMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );

        return new GetMemberResponse(
                member.getMemberId(),
                member.getName()
        );
    }
}
