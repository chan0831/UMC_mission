package umc.study.service.storeService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Page<Review> getReviewList(Long storeId, Integer page);
}
