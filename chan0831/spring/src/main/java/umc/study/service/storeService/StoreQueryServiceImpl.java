package umc.study.service.storeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.repository.reviewRepository.ReviewRepository;
import umc.study.repository.storeRepository.StoreRepository;

import java.util.List;

//import umc.study.domain.Store;
//import umc.study.repository.storeRepository.StoreRepository;
//
//import java.util.List;
//import java.util.Optional;
//
@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService{
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();


        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page,10));
        return  StorePage;
    }


//    private final StoreRepository storeRepository;
//
//    @Override
//    public Optional<Store> findStore(Long id){
//        return storeRepository.findById(id);
//    }
//
//    @Override
//    public List<Store> findStoresByNameAndScore(String name, Float score){
//        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);
//
//        filteredStores.forEach(store -> System.out.println("Store : " + store));
//
//        return filteredStores;
//    }
}
