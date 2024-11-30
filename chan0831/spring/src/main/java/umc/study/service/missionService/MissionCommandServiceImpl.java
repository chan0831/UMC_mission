package umc.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.MissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.memberRepository.MemberMissionRepository;
import umc.study.repository.memberRepository.MemberRepository;
import umc.study.repository.missionRepository.MissionRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.MissionReqeustDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Mission addMission(MissionReqeustDTO.AddMissionDTO request) {
        return null;
    }

    @Override
    public MemberMission CheckMissionChallenge(MissionReqeustDTO.MissionChallengeDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        //해당 멤버와 미션이 연결된 멤버미션이 존재한다면 이미 진행중이거나 완료된 미션임.
        boolean missionStatus = memberMissionRepository.existsByMemberIdAndMissionId(member.getId(), mission.getId());

        if (missionStatus){
            throw new GeneralException(ErrorStatus.MISSION_ALREADY_EXISTS);
        }
        MemberMission newMemberMission = MissionConverter.toMemberMission(request, member, mission);

        memberMissionRepository.save(newMemberMission);
        return newMemberMission;
    }

}


