package umc.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.repository.missionRepository.MissionRepository;
import umc.study.repository.storeRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<Mission> missionList(Long storeId, Integer pages) {

        Integer page = pages - 1;
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> MissionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));

        return MissionPage;
    }
}
