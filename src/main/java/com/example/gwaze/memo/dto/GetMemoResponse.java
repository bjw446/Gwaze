package com.example.gwaze.memo.dto;

import lombok.Getter;

@Getter
public class GetMemoResponse {
    private final Long memoId;
    private final String content;
    private final Long memberId;
    private final String memberName;

    public GetMemoResponse(Long memoId, String content, Long memberId, String memberName) {
        this.memoId = memoId;
        this.content = content;
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
