package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.AddReviewDTO dto, Store store) {
        return Review.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .score(dto.getScore())
                .store(store)
                .build();
    }

    public static ReviewResponseDTO.ReviewResultDTO toResponseDTO(Review review) {
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .body(review.getBody())
                .score(review.getScore())
                .storeName(review.getStore().getName())
                .build();
    }
}
