package example.day07.controller;



import example.day07.model.dto.BoardDto;
import example.day07.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board") // + 공통 URL
@RequiredArgsConstructor
// CORS( 서로 다른 서버간의 요청/응답 허용 ) 정책을 설정
@CrossOrigin( value = "http://localhost:5173") // 리액트서버 와 CORS 통신을 허용
public class BoardController {
     private final BoardService boardService;

     // [1] 등록
    @PostMapping
     public ResponseEntity<Boolean> boardWrite(@RequestBody BoardDto boardDto ){
         System.out.println("BoardController.boardWrite");
         System.out.println("boardDto = " + boardDto);
         boolean result = boardService.boardWrite( boardDto ); // 서비스 호출 하고 응답을 반환
         return ResponseEntity.status(200).body(result);
     }

    // [2] 전체조회
    @GetMapping("") // localhost:8080/board
    public ResponseEntity<List<BoardDto>> boardPrint(){
        System.out.println("BoardController.boardPrint");
        List<BoardDto> result = boardService.boardPrint();
        return ResponseEntity.status(200).body(result);
    }

    // [3] 개별조회
    @GetMapping("/find") // localhost:8080/board/find?bno=1
    public ResponseEntity<BoardDto> boardFind( @RequestParam int bno ){
        System.out.println("BoardController.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardService.boardFind( bno );
        return ResponseEntity.status(400).body(result);
    }



    // [4] 개별삭제
    @DeleteMapping("") // localhost:8080/board?bno=3
    public ResponseEntity<Boolean> boardDelete( @RequestParam int bno ){
        System.out.println("BoardController.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardService.boardDelete( bno );
        return ResponseEntity.status(200).body(result);
    }
    // [5] 개별수정
    @PutMapping("") // localhost:8080/board
    public ResponseEntity<Boolean> boardUpdate( @RequestBody BoardDto boardDto ){
        System.out.println("BoardController.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardService.boardUpdate( boardDto );
        return ResponseEntity.status(507).body(result);
    }
}
