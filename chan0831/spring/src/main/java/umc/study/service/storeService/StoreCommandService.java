package umc.study.service.storeService;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO.StoreDTO request);
}
