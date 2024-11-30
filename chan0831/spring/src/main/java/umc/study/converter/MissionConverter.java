package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionReqeustDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.MissionChallengeResultDTO toMissionResultDTO(MemberMission memberMission){

        return MissionResponseDTO.MissionChallengeResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .missionStatus(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMission toMemberMission(MissionReqeustDTO.MissionChallengeDTO request, Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
