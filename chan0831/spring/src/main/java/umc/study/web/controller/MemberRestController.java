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
import umc.study.converter.MemberConverter;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.MissionStatus;
import umc.study.service.memberService.MemberCommandService;
import umc.study.service.memberService.MemberQueryService;
import umc.study.service.memberService.MemberQueryServiceImpl;
import umc.study.validation.annotation.ExistPage;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberQueryService memberQueryService;
    private final MemberQueryServiceImpl memberQueryServiceImpl;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);

        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));

    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내 리뷰 목록 조회 API",description = "내 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!")
    })// 원래는 로그인 토큰 값으로 넘겨줄 수 있다는데, 안배워서 일단은 pathVariable로 구현..
    public ApiResponse<ReviewResponseDTO.MyReviewListDTO> myReviewList(@PathVariable(name="memberId")  Long memberId, @RequestParam(name = "page") @ExistPage Integer pages){

        int page = pages - 1 ;
        Page<Review> myReviewList = memberQueryService.getMyReviewList(memberId, page);
        return ApiResponse.onSuccess(ReviewConverter.myReviewListDTO(myReviewList));
    }

    @GetMapping("/{memberId}/missions/{status}")
    @Operation(summary = "나의 진행중인 미션 목록 조회 API",description = "내 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "나의 아이디, path variable 입니다!"),
            @Parameter(name = "status", description = "미션 상태 path variable .")
    })
    public ApiResponse<MemberResponseDTO.MyChallengingMissionListDTO> myMission(@PathVariable(name = "memberId") Long memberId, @PathVariable(name = "status")MissionStatus status, @ExistPage @RequestParam(name = "page") Integer page){

        Page<Mission> myChallengingMissionList = memberQueryService.getMyMissionList(memberId, status, page );

        return ApiResponse.onSuccess(MemberConverter.myChallengingMissionListDTO(myChallengingMissionList));
    }
}
