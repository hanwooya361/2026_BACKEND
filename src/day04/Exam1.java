package day04;

public class Exam1 {
    public static void main(String[] args) {
        
        // 조건문1 : if(true/false) 실행문;
        int 온도 = 5;
        if(온도 <= 10) System.out.println("외투 입는다");

        // 조건문2 : if(true/false){실행문; 실행문;};
        if(온도 <= 10){
            System.out.println("외투 입는다");
            System.out.println("긴바지 입는다");
        }

        // 조건문3 : if(true/false){실행문;}else{실행문;}
        if(온도 <= 10){
            System.out.println("외투 입는다");
        }else{System.out.println("외투 입지 않는다.");}

        // 조건문4 : if(true/false)[실행문;] else if(true/false){실행문;} else{실행문;}
        if(온도 <= 10){System.out.println("외투를 입는다");}
        else if(온도 <= 15){System.out.println("외투를 입지 않는다");}
        else if(온도 <= 20){System.out.println("asd");}
        else{System.out.println("sda");}

        // 1. 조건문 중첩 : if(){if(){}}
        // 2. 다수 조건에 다수 실행문 : if if if vs 다수 조건에 하나의 실행문 : if else if else if else
        // 3. switch : 값에 따른 흐름 제어 사용(논리 제어x) break : 주로 for/switch 사용하는 탈출 키워드
        char grade = 'b';
        // switch (자료) {case 값1 : 실행문; case 값2 : 실행문; default : 실행문;}
        // 자료에 동일한 값이 case 존재하면 실행문 실행, 단 해당하는 case부터 아래 case 모두 실행
        switch (grade) {
            case 'a': System.out.println("a등급 입니다"); break;
            case 'b': System.out.println("b등급 입니다"); break;
            case 'c': System.out.println("c등급 입니다"); break;
            default : System.out.println("탈락입니다"); 
        }

        // case안에 && || or 이런거 못씀
        switch(grade){
            case 'a' :
            case 'b' : System.out.println("합격"); break;
            case 'c' : 
            default : System.out.println("탈락");
        }

        // switch 중첩문
        int adult = 0;
        switch(grade){  // 복잡한 조건보다는 단일 조건 값에 따른 흐름제어
            case 'a' :
                switch(adult){
                    case 1 : System.out.println("a등급 성인입니다"); break;
                    case 0 : System.out.println("a등급 미성년자입니다"); break;
                }
            case 'b' :
                switch(adult){
                    case 1 : System.out.println("b등급 성인입니다"); break;
                    case 0 : System.out.println("b등급 미성년자입니다"); break;
                }
        }

        // 반복문

        

    }
}
