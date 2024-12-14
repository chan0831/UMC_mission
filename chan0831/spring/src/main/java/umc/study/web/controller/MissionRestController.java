package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/{storeId}/mission/{missionId}")
    public ApiResponse<MissionResponseDTO.MissionChallengeResultDTO> startMission
            (@RequestBody @Valid MissionReqeustDTO.MissionChallengeDTO request,
             @PathVariable("storeId") Long storeId,
             @PathVariable("missionId") Long missionId){
        MemberMission memberMission = missionCommandService.CheckMissionChallenge(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(memberMission) );

    }

    //특정가게 미션 조회
    @GetMapping("/{storeId}/missions")
    public ApiResponse<>

    //특정 가게에 미션 추가?
    //@PostMapping("/{storeId}/missions") {}

}
