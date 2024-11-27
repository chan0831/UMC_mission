package umc.study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO.AddReviewDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()->
                        new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(request, store);
        return reviewRepository.save(newReview);

    }
}
