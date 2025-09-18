package example.day08.controller;

import example.day08.model.dto.MemberDto;
import example.day08.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin (value = "http://localhost:5173/")
public class MemberController {

    private final MemberService memberService;

    // [1] 등록
    @PostMapping
    public ResponseEntity<Boolean> memberAdd(@RequestBody MemberDto memberDto){
        boolean result = memberService.memberAdd(memberDto);
        return ResponseEntity.status(200).body(result);
    }

    // [2] 조회
    @GetMapping
    public ResponseEntity<List<MemberDto>> memberPrint(){
        List<MemberDto> result = memberService.memberPrint();
        return ResponseEntity.status(200).body(result);
    }

    // [3] 삭제
    @DeleteMapping
    public ResponseEntity<Boolean> memberDelete(@RequestParam int mno){
        boolean result = memberService.memberDelete(mno);
        return ResponseEntity.status(200).body(result);
    }
}
