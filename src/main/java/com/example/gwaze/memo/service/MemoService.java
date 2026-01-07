package com.example.gwaze.memo.service;

import com.example.gwaze.member.entity.Member;
import com.example.gwaze.member.repository.MemberRepository;
import com.example.gwaze.memo.dto.CreateMemoRequest;
import com.example.gwaze.memo.dto.CreateMemoResponse;
import com.example.gwaze.memo.dto.GetMemoResponse;
import com.example.gwaze.memo.entity.Memo;
import com.example.gwaze.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemoResponse createMemo(CreateMemoRequest request) {
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        Memo memo = new Memo(request.getContent(), member);
        Memo savedMemo = memoRepository.save(memo);
        return new CreateMemoResponse(savedMemo.getMemoId(), savedMemo.getContent());
    }

    @Transactional(readOnly = true)
    public List<GetMemoResponse> findAllMemo() {
        List<Memo> memos = memoRepository.findAll();
        List<GetMemoResponse> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            GetMemoResponse dto = new GetMemoResponse(
                    memo.getMemoId(),
                    memo.getContent(),
                    memo.getMember().getMemberId(),
                    memo.getMember().getName()
                    );
            dtos.add(dto);
        }
        return dtos;
    }

    public GetMemoResponse findOneMemo(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("없는 메모 입니다.")
        );
        System.out.println("========구분선========");
        Member member = memo.getMember();
        return new GetMemoResponse(
                memo.getMemoId(),
                memo.getContent(),
                member.getMemberId(),
                member.getName()
        );
    }
}
