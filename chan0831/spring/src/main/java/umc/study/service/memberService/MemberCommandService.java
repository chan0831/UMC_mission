package umc.study.service.memberService;

import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MissionResponseDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberResponseDTO.CompleteMissionResultDTO completeMission(Long memberId, Long missionId);
}
