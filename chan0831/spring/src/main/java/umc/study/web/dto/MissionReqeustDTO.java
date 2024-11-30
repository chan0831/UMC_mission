package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionReqeustDTO {

    @Getter
    public static class AddMissionDTO{
        @NotNull
        private Long memberId;
        @NotNull
        private Long storeId;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;

    }

    @Getter
    public static class MissionChallengeDTO{

        @NotNull
        private Long memberId;

        @NotNull
        private Long missionId;

        @NotNull
        private Long storeId;
    }
}
