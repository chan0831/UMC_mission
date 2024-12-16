package umc.study.repository.missionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStore(Store store, PageRequest request);

}
