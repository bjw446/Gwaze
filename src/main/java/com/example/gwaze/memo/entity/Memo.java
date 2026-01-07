package com.example.gwaze.memo.entity;

import com.example.gwaze.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

@Getter
@Entity
@Table(name = "memos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoId;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Memo (String content, Member member) {
        this.content = content;
        this.member = member;
    }
}
