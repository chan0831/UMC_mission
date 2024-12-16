package umc.study.service.missionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;

public interface MissionQueryService {

    Page<Mission> missionList(Long storeId, Integer page);
}
