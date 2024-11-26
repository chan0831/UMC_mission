package umc.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.StoreConverter;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.repository.regionRepository.RegionRepository;
import umc.study.repository.storeRepository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO.StoreDTO request) {

        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(()-> //new IllegalArgumentException("지역을 찾을 수 없음."));
                        new GeneralException(ErrorStatus.REGION_NOT_FOUND));
        // 오류를 바꿔서 이제 ExceptionAdvice에서 처리한다.
        // 이거 사용 (ExceptionAdvice 에서 onThrowException(GeneralException generalException, ~~)

        Store newStore = StoreConverter.toStore(request, region);
        return storeRepository.save(newStore);

    }
}
