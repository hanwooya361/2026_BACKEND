package day12.종합예제.controller;

import java.util.ArrayList;

import day12.종합예제.model.dao.BoardDao;
import day12.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){ return instance; }
    // 싱글톤
    private BoardDao bd = BoardDao.getInstance();

    // [1] 등록 컨트롤러
    public boolean save(BoardDto boardDto){
        boolean result = bd.save(boardDto);
        return result;
    }

    // [2] 전체조회 컨트롤러
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();
        return result;
    }

    // [3] 개별 수정 컨트롤러
    public boolean update(BoardDto boardDto){
        return bd.update(boardDto);
    }
    
    // [3] 개별 삭제 컨트롤러
    public boolean delete(int no){
        return bd.delete(no);
    }
}
