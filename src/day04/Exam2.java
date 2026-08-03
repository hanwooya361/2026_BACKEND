package day04;

public class Exam2 {
    public static void main(String[] args) {
        // 1. for(초기값 ; 조건문 ; 증감식){실행문;}
        // 중첩for : for(){for( ){ }}
        for(int 단 = 2; 단 <= 9; 단++){
            for(int 곱 = 1; 곱 <= 9; 곱++){
                System.out.printf("%d x %d = %d \n", 단, 곱, 단*곱);
            }
        }

        // 2. break; 반복문 탈출,  continue; 증감식 이동
        for(int i=1; i<=10; i++){
            if(i==3) continue;  // 만약에 i가 3이면 증감식이동
            if(i==9) break;     // 만약 i가 9면 반복문 탈출
        }

        // 3. 무한루프:
        for(; ;){System.out.println("무한반복"); break;}

        // 4. 초기값; while(조건문){증감식; 실행문;} [vs] for문
        int i=1;    // 초기값
        while(i<=10){ // 조건식
            // 증감식
            i++;
        }

        // 5. 반복문과배열 관계 : 배열내 저장된 자료들을 인덱스(저장된순서번호)로 식별
        int [] ary = {92, 80, 75};  // java 배열 vs javascript 배열
        // * 배열은 인덱스가 0부터 마지막 인덱스까지 순차저장
        for(int j=0; j<ary.length; j++){System.out.println(ary[j]);}
        // * 향상된 for문, for(타입명 변수명 : 배열명){} : 콜론 기준 오른쪽 배열내 요소들을 왼쪽 변수에 하나씩 대입
        for(int data : ary){
            System.out.println(data);   // 인덱스없이 자료(요소) 추출
        }

    }
}
