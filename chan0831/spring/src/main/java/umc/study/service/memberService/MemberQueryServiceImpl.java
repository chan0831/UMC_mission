package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.reviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<Review> myReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return myReviewPage;
    }
}
