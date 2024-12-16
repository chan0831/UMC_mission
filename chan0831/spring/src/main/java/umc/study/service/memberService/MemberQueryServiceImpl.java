package umc.study.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.memberRepository.MemberMissionRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.missionRepository.MissionRepository;
import umc.study.repository.reviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Review> getMyReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();
        Page<Review> myReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page,10));

        return myReviewPage;
    }

    @Override
    public Page<Mission> getMyMissionList(Long memberId, MissionStatus status, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<MemberMission> missionList = memberMissionRepository.findAllByMemberAndStatus(member, status, PageRequest.of(page-1,10));

        Page<Mission> missionPage = missionList.map(MemberMission::getMission);

        return missionPage;
    }
}
