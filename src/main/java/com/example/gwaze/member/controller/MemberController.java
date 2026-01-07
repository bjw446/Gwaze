package com.example.gwaze.member.controller;

import com.example.gwaze.member.dto.CreateMemberRequest;
import com.example.gwaze.member.dto.CreateMemberResponse;
import com.example.gwaze.member.dto.GetMemberResponse;
import com.example.gwaze.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> createMember (@RequestBody CreateMemberRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(request));
    }

    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getAllMember () {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAllMember());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<GetMemberResponse> getOneMember (@PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOneMember(memberId));
    }
}
