package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .totalPage(reviewList.getTotalPages())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static ReviewResponseDTO.MyReviewDTO myReviewDTO(Review review){

        return ReviewResponseDTO.MyReviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.MyReviewListDTO myReviewListDTO(Page<Review> reviewList){

        List<ReviewResponseDTO.MyReviewDTO> myReviewDTOList = reviewList.stream()
                .map(ReviewConverter::myReviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.MyReviewListDTO.builder()
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .listSize(myReviewDTOList.size())
                .totalElements(reviewList.getTotalElements())
                .totalPage(reviewList.getTotalPages())
                .reviewList(myReviewDTOList)
                .build()    ;
    }
}
