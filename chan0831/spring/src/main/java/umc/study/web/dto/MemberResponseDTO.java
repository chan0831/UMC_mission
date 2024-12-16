package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MyChallengingMissionDTO{

        LocalDate deadline;
        Integer reward;
        String missionSpec;

    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class MyChallengingMissionListDTO{

        List<MyChallengingMissionDTO> myMission;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class CompleteMissionResultDTO{

        Integer reward;
        String missionSpec;
        MissionStatus status;
    }
}
