package com.example.gwaze.memo.controller;

import com.example.gwaze.memo.dto.CreateMemoRequest;
import com.example.gwaze.memo.dto.CreateMemoResponse;
import com.example.gwaze.memo.dto.GetMemoResponse;
import com.example.gwaze.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping("/memos")
    public ResponseEntity<CreateMemoResponse> createMemo (@RequestBody CreateMemoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memoService.createMemo(request));
    }

    @GetMapping("/memos")
    public ResponseEntity<List<GetMemoResponse>> getAllMemo () {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findAllMemo());
    }

    @GetMapping("/memos/{memoId}")
    public ResponseEntity<GetMemoResponse> getOneMemo (@PathVariable Long memoId) {
        return ResponseEntity.status(HttpStatus.OK).body(memoService.findOneMemo(memoId));
    }
}
