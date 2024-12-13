package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import umc.study.validation.annotation.ExistStore;

import java.time.LocalDate;
import java.util.List;

public class ReviewRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class AddReviewDTO {

        @Size(min = 5)
        private String body;

        @Size(min=5)
        private String title;

        @NotNull
        private Float score;

        @NotNull
        @ExistStore
        private Long storeId; // 어느 가게에 추가할지
    }


}



