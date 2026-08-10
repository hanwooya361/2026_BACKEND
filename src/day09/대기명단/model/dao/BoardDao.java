package day09.대기명단.model.dao;

import java.util.ArrayList;

import day09.대기명단.model.dto.BoardDto;

public class BoardDao {
    private BoardDao(){}
    private static  final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    // 추후에 MYSQL 서버와 연동     // DB 대신 ArrayList사용
    private final ArrayList<BoardDto> boardList = new ArrayList<>();

    // [1] 게시물 작성 로직
    public boolean save(BoardDto boardDto){
        // 1. 컨트롤러로부터 저장할 정보 객체 받기
        // * 추후에 insert 이용한 DB에 저장
        // 2. 리스트에 저장
        boardList.add(boardDto);
        // 3. 성공반환
        return true;
    }

    // [2] 게시물 전체 조회 로직
    public ArrayList<BoardDto> findAll(){
        // 1. 컨트롤러에게 매개변수 받기. 현재는 없음
        // * 추후에 select 이용한 DB 조회
        // 2. 리스트 전체 반환
        return boardList;
    }

    // 수정
    public boolean Update(BoardDto boardDto){
        for(BoardDto dt : boardList){
            if(dt.getNumber().equals(boardDto.getNumber())){
                dt.setPeople(boardDto.getPeople());
                return true;
            }
        }
        return false;
    }

    // 삭제
    public boolean Delete(BoardDto boardDto){
        BoardDto deletedt = null;
        for(BoardDto dt : boardList){
            if(dt.getNumber().equals(boardDto.getNumber())){
                deletedt = dt;
                break;
            }
        }
        if(deletedt != null){
            boardList.remove(deletedt);
            return true;
        }
        return false;
    }
}
