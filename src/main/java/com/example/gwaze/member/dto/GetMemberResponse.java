package com.example.gwaze.member.dto;

import lombok.Getter;

@Getter
public class GetMemberResponse {
    private final Long memberId;
    private final String name;

    public GetMemberResponse(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
