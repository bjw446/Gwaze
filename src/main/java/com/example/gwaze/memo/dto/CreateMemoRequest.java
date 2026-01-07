package com.example.gwaze.memo.dto;

import lombok.Getter;

@Getter
public class CreateMemoRequest {
    private String content;
    private Long memberId;
}
