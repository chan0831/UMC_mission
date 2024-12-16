package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.util.List;

public class MissionResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionChallengeResultDTO{
        private Long missionId;
        private Long memberId;
        private MissionStatus missionStatus;

    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionDTO{
         Integer reward;
         LocalDate deadline;
         String missionSpec;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionListDTO{
        List<StoreMissionDTO> missionList;
        Integer totalPage;
        Integer listSize;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
