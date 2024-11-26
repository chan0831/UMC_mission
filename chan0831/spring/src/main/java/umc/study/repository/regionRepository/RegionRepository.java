package umc.study.repository.regionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
