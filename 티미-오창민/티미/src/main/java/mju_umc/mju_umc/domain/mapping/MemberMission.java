package mju_umc.mju_umc.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import mju_umc.mju_umc.domain.Member;
import mju_umc.mju_umc.domain.Mission;
import mju_umc.mju_umc.domain.base.BaseEntity;
import mju_umc.mju_umc.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;


    //연관관계 편의 메서드
    public void setMember(Member member) {
        this.member=member;
        member.getMemberMissionList().add(this);
    }

    public void setMission(Mission mission) {
        this.mission =mission;
    }

    public void editStatus(MissionStatus status) {
        this.status = status;
    }
}
