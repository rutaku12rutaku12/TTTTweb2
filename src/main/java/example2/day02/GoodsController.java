package example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;
    // 1. 저장
    @PostMapping
    public ResponseEntity<?> goodsSave(
            @RequestBody GoodsDto goodsDto){
        return ResponseEntity.ok(
                goodsService.goodsSave( goodsDto ) );
    }
    // 2. 전체조회
    @GetMapping("/list")
    public ResponseEntity<?> goodsAll(){
        return ResponseEntity.ok(goodsService.goodsAll() );
    }
    // 3. 개별조회
    @GetMapping
    public ResponseEntity<?> goodsGet(@RequestParam int gno){
        // 1. 개별 조회할 gno 의 엔티티 조회한다.
        return ResponseEntity.ok(goodsService.goodsGet(gno));
    }
    // 4. 개별삭제
    @DeleteMapping
    public ResponseEntity<?> goodsDelete(@RequestParam int gno ){
        return ResponseEntity.ok(goodsService.goodsDel(gno));
    }
    // 5. 개별수정
    @PutMapping
    public ResponseEntity<?> goodsUpdate ( @RequestBody GoodsDto goodsDto){
        return ResponseEntity.ok(goodsService.goodsUpdate(goodsDto) );
    }
}
