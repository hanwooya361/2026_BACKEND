package day12.종합예제.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day12.종합예제.controller.BoardController;
import day12.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView(){} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance( ){ return instance; } // 3. 

    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private BoardController bc = BoardController.getInstance();
    // [*] 입력객체
    private Scanner scan = new Scanner(System.in);
    // [*] 최초 루프/화면
    public void run(){
        while(true){
            try{
                System.out.print("1.등록 2.전체조회 3.개별수정 4.개별삭제 선택:");
                int ch = scan.nextInt();
                if(ch==1){save();}
                else if(ch==2){findAll();}
                else if(ch==3){update();}
                else if(ch==4){delete();}
            }catch(InputMismatchException e){
                // 입력(성공) 했찌만 타입에서 예외 이므로 입력객체 초기화
                scan = new Scanner(System.in);  
                System.out.println("[다시입력]"+e);
            }
        }
    }
    
    // [1] 등록 view
    public void save(){
        // 1-1. 입력받기
        System.out.print("내용"); 
        String 내용 = scan.next();
        System.out.print("작성자");
        String 작성자 = scan.next();
        // 1-2. 자료 객체화하기, no(아무거나/사용x)
        BoardDto boardDto = new BoardDto(0, 내용, 작성자);  
        // 1-3 컨트롤러에게 전달(dto)해 응답(boolean)받기
        boolean result = bc.save(boardDto);
        // 1-4 응답받은 결과로 출력
        if(result){System.out.println("등록성공");}
        else{System.out.println("등록실패");}
    }

    // [2] 전체조회 view
    public void findAll(){
        // 1. 컨트롤러에게 모든 게시물 정보들을 요청하고 받기
        ArrayList<BoardDto> result = bc.findAll();
        // 2. 반복문 이용해 게시물정보들 출력
        for(BoardDto dto : result){
            System.out.println(dto.getNo()+"/"+dto.getWriter()+"/"+dto.getContent());
        }
    }

    // [3] 개별 수정 view 
    public void update(){
        System.out.print("수정할번호: ");
        int 수정할번호 = scan.nextInt();
        System.out.print("수정할내용: ");
        String 수정할내용 = scan.next();
        BoardDto boardDto = new BoardDto(수정할번호, 수정할내용, null); // writer 사용안함 null
        boolean result = bc.update(boardDto);
        if(result){System.out.println("수정성공");}
        else{System.out.println("수정실패");}
    }
    // [4] 개별 삭제 view
     public void delete(){
        System.out.print("삭제할번호: ");
        int 삭제할번호 = scan.nextInt();
        // 매개변수가 1개이므로 dto 없이
        boolean result = bc.delete(삭제할번호);
        if(result){System.out.println("삭제성공");}
        else{System.out.println("삭제실패");}
    }
}