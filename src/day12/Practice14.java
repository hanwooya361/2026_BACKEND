package day12;

public class Practice14 {
    public static void main(String[] args) {
        
        // 1.
        try{
            int result = 10/0;
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다" +e);
        }

        // 2.
        try{
            String text = null;
            System.out.println("글자 수"+text.toUpperCase());
        }catch(NullPointerException e){
            System.out.println("객체가 초기화되지않았습니다"+e);
        }

        // 3.
        try{
            System.out.println("DB연결을 시작합니다");
        }finally{
            System.out.println("DB연결을 종료합니다");
        }

        // 4.
        try{
            int result2 = 5/0;
            String text = null; text.length();
        }catch(ArithmeticException e){
            System.out.println("0으로 나눔 발생"+e);
        }catch(NullPointerException e){
            System.out.println("npm발생"+e);
        }catch(Exception e){
            System.out.println("그 외 알 수 없는 예외 발생"+e);
        }
        // Exception이 예외처리중에서 가장 상위 처리이기때문에 먼저 선언이 되버리면 
        // 본인만 선언하고 끝나버리기때문에 
 
        // 5.
        try{pauseOneSound();}
        catch(InterruptedException e){System.out.println("반환"+e);}
    } // main end
        // 5.
        public static void pauseOneSound()throws InterruptedException{
            Thread.sleep(1000);
        }
}// c end
