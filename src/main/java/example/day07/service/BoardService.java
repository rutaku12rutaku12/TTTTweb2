package example.day07.service;

import example.day07.model.dto.BoardDto;
import example.day07.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    // [1] 등록
    public boolean boardWrite(BoardDto boardDto ){
        System.out.println("BoardService.boardWrite");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper.boardWrite( boardDto );
        return result;
    }
    // [2] 전체조회
    public List<BoardDto> boardPrint(){
        System.out.println("BoardService.boardPrint");
        List<BoardDto> result = boardMapper.boardPrint();
        return result;
    }
    // [3] 개별조회
    public BoardDto boardFind( int bno ){
        System.out.println("BoardService.boardFind");
        System.out.println("bno = " + bno);
        BoardDto result = boardMapper.boardFind( bno );
        return result;
    }

    // [4] 개별삭제
    public boolean boardDelete( int bno ){
        System.out.println("BoardService.boardDelete");
        System.out.println("bno = " + bno);
        boolean result = boardMapper.boardDelete( bno );
        return result;
    }

    // [5] 개별수정
    public boolean boardUpdate( BoardDto boardDto  ){
        System.out.println("BoardService.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        boolean result = boardMapper.boardUpdate( boardDto );
        return result;
    }
}