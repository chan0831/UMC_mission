package umc.study.converter;

import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.StoreResultDTO toStoreResultDTO(Store store){
        return StoreResponseDTO.StoreResultDTO.builder()
                .storeId(store.getId())
                .storeName(store.getName())
                .storeAddress(store.getAddress())
                .regionName(store.getRegion().getName())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreDTO request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
