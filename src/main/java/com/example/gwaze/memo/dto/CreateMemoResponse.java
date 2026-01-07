package com.example.gwaze.memo.dto;

import lombok.Getter;

@Getter
public class CreateMemoResponse {
    private final Long memoId;
    private final String content;

    public CreateMemoResponse(Long memoId, String content) {
        this.memoId = memoId;
        this.content = content;
    }
}
