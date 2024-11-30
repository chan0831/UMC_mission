package umc.study.service.missionService;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MissionReqeustDTO;

public interface MissionCommandService {

    Mission addMission(MissionReqeustDTO.AddMissionDTO request);
    MemberMission CheckMissionChallenge(MissionReqeustDTO.MissionChallengeDTO request);
}
