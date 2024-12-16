package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MyChallengingMissionDTO myChallengingMissionDTO (Mission mission){

        return MemberResponseDTO.MyChallengingMissionDTO.builder()
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .build();
    }

    public static MemberResponseDTO.MyChallengingMissionListDTO myChallengingMissionListDTO(Page<Mission> missionList){

        List<MemberResponseDTO.MyChallengingMissionDTO> myChallengingMissionDTOList = missionList.stream()
                .map(MemberConverter::myChallengingMissionDTO).collect(Collectors.toList());

        return MemberResponseDTO.MyChallengingMissionListDTO.builder()
                .myMission(myChallengingMissionDTOList)
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .listSize(myChallengingMissionDTOList.size())
                .totalPage(missionList.getTotalPages())
                .build();
    }
}
