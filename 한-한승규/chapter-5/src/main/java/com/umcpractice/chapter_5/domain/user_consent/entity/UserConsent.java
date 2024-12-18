package com.umcpractice.chapter_5.domain.user_consent.entity;

import com.umcpractice.chapter_5.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserConsent {

    @Id
    private Long userId;

    @Column(nullable = false)
    private boolean location;

    @Column(nullable = false)
    private boolean marketing;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}