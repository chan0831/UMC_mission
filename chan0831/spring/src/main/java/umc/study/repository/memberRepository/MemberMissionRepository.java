package umc.study.repository.memberRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    boolean existsByMemberIdAndMissionId(Long memberId, Long MissionId);

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest request);

    MemberMission findByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus missionStatus);
}
