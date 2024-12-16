package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.missionService.MissionCommandService;
import umc.study.service.missionService.MissionCommandServiceImpl;
import umc.study.service.missionService.MissionQueryService;
import umc.study.validation.annotation.ExistPage;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.MissionReqeustDTO;
import umc.study.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionQueryService missionQueryService;

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
    @Operation(summary = "특정 가게의 미션 목록 조회 API",description = "특정 가게의 미션의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.StoreMissionListDTO> storeMissions(@ExistStore @PathVariable("storeId")Long storeId,
                                                                             @ExistPage @RequestParam(name = "page") Integer page){
        Page<Mission> missionList = missionQueryService.missionList(storeId, page);

        return ApiResponse.onSuccess(MissionConverter.storeMissionListDTO(missionList));
    }

    //특정 가게에 미션 추가?
    //@PostMapping("/{storeId}/missions") {}

}
