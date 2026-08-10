package day09.대기명단.controller;

import java.util.ArrayList;

import day09.대기명단.model.dao.BoardDao;
import day09.대기명단.model.dto.BoardDto;

public class BoardController {
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    private BoardDao bd = BoardDao.getInstance();   // controller 에서 dao 싱글톤 호출

    // [1] 게시물 작성 컨트롤러
    public boolean save(BoardDto boardDto){
        // 1. view로 부터 저장할 정보 객체로 받기
        // * 유효성검사/타입변환 등등
        // 2. DAO에게 요청하고 응답받기
        boolean result = bd.save(boardDto);
        // 3. DAO에게 받은 결과를 view에게 응답하기
        return result;
    }

    // [2] 게시물 전체 조회
    public ArrayList<BoardDto> findAll(){
        // 1. view에게 매개변수 받기. 현재는 없음
        // 2. DAO에게 요청하고 응답받기
        ArrayList<BoardDto> result =  bd.findAll();
        // 3. DAO에게 받은 결과를 VIEW에게 반환
        return result;
    }

    // 수정
    public boolean Update(BoardDto boardDto){
        boolean result = bd.Update(boardDto);
        return result;
    }

    // 삭제
    public boolean Delete(BoardDto boardDto){
        boolean result = bd.Update(boardDto);
        return result;
    }
}
