package umc.study.service.memberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;

public interface MemberQueryService {

    Page<Review> getMyReviewList(Long memberId, Integer page);

    Page<Mission> getMyMissionList(Long memberId, MissionStatus status, Integer page);
}
