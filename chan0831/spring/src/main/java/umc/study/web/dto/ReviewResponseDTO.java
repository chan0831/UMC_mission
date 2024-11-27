package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReviewResultDTO {
        private Long reviewId;
        private String title;
        private String body;
        private Float score;
        private String storeName;
    }
}
