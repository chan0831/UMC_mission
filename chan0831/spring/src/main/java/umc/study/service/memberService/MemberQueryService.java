package umc.study.service.memberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;

public interface MemberQueryService {

    Page<Review> getMyReviewList(Long memberId, Integer page);
}
