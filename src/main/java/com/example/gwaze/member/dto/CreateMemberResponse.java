package com.example.gwaze.member.dto;

import lombok.Getter;

@Getter
public class CreateMemberResponse {
    private final Long memberId;
    private final String name;

    public CreateMemberResponse(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
