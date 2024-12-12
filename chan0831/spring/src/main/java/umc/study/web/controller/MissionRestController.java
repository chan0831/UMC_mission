package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.missionService.MissionCommandService;
import umc.study.service.missionService.MissionCommandServiceImpl;
import umc.study.web.dto.MissionReqeustDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/startMission")
    public ApiResponse<MissionResponseDTO.MissionChallengeResultDTO> startMission
            (@RequestBody @Valid MissionReqeustDTO.MissionChallengeDTO request){
        MemberMission memberMission = missionCommandService.CheckMissionChallenge(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(memberMission) );

    }
}
