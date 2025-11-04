package example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService {

    private final GoodsRepository goodsRepository;

    // 1. 저장
    public GoodsDto goodsSave( GoodsDto goodsDto ){
        // 1. 저장할 dto를 매개변수로 받는다
        // 2. 저장할 dto를 entity 변환
        GoodsEntity entity = goodsDto.toEntity();
        // 3. .save() 이용한 앤티티 영속
        GoodsEntity savedEntity = goodsRepository.save(entity);
        // 4. 만약에 pk가 생성 되었으면 생성된 엔티티를 dto로 변환하여 반환
        if( savedEntity.getGno() >= 0 ){return savedEntity.toDto(); }
        return goodsDto;
    }

    // 2. 전체조회
    public List<GoodsDto> goodsAll(){
        // 1. 모든 엔티티 조회
        List<GoodsEntity> goodsEntityList = goodsRepository.findAll();
        // 2. 모든 엔티티를 dto로 변환한다.

        // 방법1
//        List<GoodsDto> goodsDtoList = new ArrayList<>();
//        for( int i = 0; i< goodsDtoList.size() ; i ++ ){
//            // i 번째 엔티티 꺼내서
//            GoodsEntity entity = goodsEntityList.get(i);
//            // 엔티티를 dto로 변환후 리스트에 저장
//            goodsDtoList.add(entity.toDto());
//        }

        // 방법2 : 스트림API
        List<GoodsDto> goodsDtoList = goodsEntityList
                .stream().map(GoodsEntity :: toDto)
                .collect(Collectors.toList() );

        return goodsDtoList; // DTO LIST 변환한다.
    }
    // 3. 개별조회
    public GoodsDto goodsGet( int gno ){
        // 1. 개별 조회할 gno 의 앤티티 조회한다.
        Optional<GoodsEntity> optional = goodsRepository.findById(gno);
        // 2-1. 조회 결과가 있으면
        if( optional.isPresent() ){
            // 3. 앤티티 꺼내기
            GoodsEntity entity = optional.get();
            // 4. 앤티티를 dto로 반환한다.
            return entity.toDto();
        }
        // 2-2. 조회 결과가 없으면
        return null;
    }
    // 4. 개별삭제
    public boolean goodsDel(int gno ){
        if( goodsRepository.existsById(gno)){
            goodsRepository.deleteById(gno);
                return true;
        }
        return false;
    }
    // 5. 개별수정 ( + @Transactional 포함, 클래스 위에 )
    public GoodsDto goodsUpdate( GoodsDto goodsDto ){
        Optional<GoodsEntity> optional =
        // 1. 수정할 엔티티를 조회한다.
        goodsRepository.findById(goodsDto.getGno());
        if( optional.isPresent()){ // 존재하면
            // 영속화된 앤티티 꺼내기
            GoodsEntity entity = optional.get();
                    entity.setGname(goodsDto.getGname());
                    entity.setGprice(goodsDto.getGprice());
                    entity.setGdesc(goodsDto.getGdesc());
                    // commit 되면 자동으로 수정날짜 (JPA Auditing) 자동 변경 : 변경된 값이 존재할 경우
                    // 수정된 엔티티를 dto로 변환후 반환
                    return entity.toDto();
        }
        return goodsDto; // 존재하지 않으면
    }
}
