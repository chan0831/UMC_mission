package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionReqeustDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.StoreMissionDTO storeMissionDTO(Mission mission){

        return MissionResponseDTO.StoreMissionDTO.builder()
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MissionResponseDTO.StoreMissionListDTO storeMissionListDTO(Page<Mission> missionList){

        List<MissionResponseDTO.StoreMissionDTO> storeMissionDTOList = missionList.stream()
                .map(MissionConverter::storeMissionDTO).collect(Collectors.toList());

        return MissionResponseDTO.StoreMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .listSize(storeMissionDTOList.size())
                .missionList(storeMissionDTOList)
                .build();
    }
}
