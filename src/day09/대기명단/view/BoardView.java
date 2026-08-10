package day09.대기명단.view;

import java.util.ArrayList;
import java.util.Scanner;

import day09.대기명단.controller.BoardController;
import day09.대기명단.model.dto.BoardDto;

public class BoardView {
    private BoardView(){}//[1]
    private static final BoardView instance = new BoardView();//[2]
    public static BoardView getInstance(){//[3]
        return instance;
    }
    private BoardController bc = BoardController.getInstance(); // view에서 controller 싱글톤 호출
    
    private Scanner scan = new Scanner(System.in);  // * 모든 메소드에서 사용 가능한 입력객체

    // [*] 메인 입출력
    public void run(){
        while(true){    // 무한루프
            System.out.println("1.대기명단등록 2.대기명단 전체조회 3.대기명단 수정 4. 대기명단 삭제 : ");
            int ch = scan.nextInt();
            if(ch==1) {save();}
            else if(ch==2) {findAll();}
            else if(ch==3) {Update();}
            else if(ch==4) {Delete();}
           }
    }

    // [1] 게시물쓰기 입출력
    public void save(){
        // 1. 입력받기
        System.out.print("연락처: ");
        String 연락처 = scan.next();
        System.out.print("방문인원수: ");
        int 방문인원수 = scan.nextInt();
        // 2. 객체화
        BoardDto boardDto = new BoardDto(연락처, 방문인원수);
        // 3. 컨트롤러에게 요청하고 응답받기
        boolean result = bc.save(boardDto);
        // 4. 처리
        if(result){System.out.println("등록성공");}
        else{System.out.println("등록실패");}
    }

    // [2] 게시물 전체 조회
    public void findAll(){
        // 1. 컨트롤러로부터 모든 게시물 요청하고 받기
        ArrayList<BoardDto> result = bc.findAll();
        // 2. 컨트롤러로부터 받은 모든 게시물 출력
        for(BoardDto board : result){
            System.out.println(board.getNumber()+":"+board.getPeople());
        }
    }
    public void Update(){
        System.out.print("변경할건의 연락처: ");
        String 연락처 = scan.next();
        System.out.print("변경할 인원수: ");
        int 인원 = scan.nextInt();
        BoardDto boardDto = new BoardDto(연락처, 인원);
        boolean result = bc.Update(boardDto);
        if(result){
            System.out.println("수정완료");
        }else{System.out.println("수정실패");}

        
    }
    public void Delete(){
        System.out.print("삭제할 연락처: ");
        String 연락처 = scan.next();
        BoardDto boardDto = new BoardDto(연락처,0);
        boolean result = bc.Delete(boardDto);
        if(result){
            System.out.println("삭제성공");
        }else{System.out.println("삭제실패");}
    }
}
