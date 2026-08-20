package day13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class asfd {
    public static void main(String[] args) {
        // [1] 차량 2대(\n 기준) 3,211가6231,202608190930  452하1234,202608171227
        // 차량의 속성 3개(,기준)   3   /   211기6231   /   202608190930
        String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";
        Scanner scan = new Scanner(System.in);
        
        while (true) {
            String [] parkingAry = carParkingList.split("\n"); // \n을 기준으로 차량들 나누기
            System.out.print("1.위치찾기 2.입차 3.출차 선택:");
            int ch = scan.nextInt();
            if( ch == 1 ){ // 위치찾기 구현 
                
                System.out.print("차량 번호"); String carNumber = scan.next(); // 차량번호 입력 받기
                boolean test = false;
                for(int i = 0; i < parkingAry.length; i++){
                    String [] result = parkingAry[i].split(",");
                    if( result[1].contains(carNumber) ){
                        System.out.println("주차 위치번호: "+ result[0]);
                        test = true;
                        break;
                        
                    }
                }
                if(test == false){System.out.println("미등록 차량"); }
            } 
            if( ch == 2 ){ // 입차 구현
                System.out.println("위치번호,차량번호,입차일시를 입력해주세요");
                System.out.print("예) 3,211가6231,202608190930 >");
                String newcar = scan.next(); // 새로운 차 정보 입력 받기
                String [] newcarAry = newcar.split(",");
                for(int i = 0; i < parkingAry.length; i++){
                    String [] result = parkingAry[i].split(",");
                    if(result[0].contains(newcarAry[0]) ){
                        System.out.println("중복주차 불가능");
                    }
                    else {
                        carParkingList = carParkingList.concat("\n");
                        carParkingList = carParkingList.concat(newcar); // 기존 배열에 추가
                        System.out.println(carParkingList); // 확인
                        break;
                    }
                }
            }  
            if( ch == 3 ){ // 출차 구현
                System.out.print("출차할 차량번호");
                String carNumber = scan.next();
                for(int i = 0; i < parkingAry.length; i++){
                    String [] result = parkingAry[i].split(",");
                    if( result[1].contains(carNumber) ){
                        int year = Integer.parseInt(result[2].substring(0,4));
                        int month = Integer.parseInt(result[2].substring(4,6));
                        int day = Integer.parseInt(result[2].substring(6,8));
                        int hour = Integer.parseInt(result[2].substring(8,10) );
                        int min = Integer.parseInt(result[2].substring(10) );

                        LocalDateTime outTime = LocalDateTime.of( year, month, day, hour, min); // 출차시간

                        LocalDateTime current = LocalDateTime.now(); // 현재시간
                        int currentDay = current.getDayOfYear();
                        int currentHour = current.getHour();
                        int currentMin = current.getMinute();
                        
                        int price1;
                        int price2;
                        if ( currentDay - outTime.getDayOfYear() > 0 && currentHour < outTime.getHour() ) {
                            price1 = (currentDay - outTime.getDayOfYear() - 1) * 20000;
                            price2 =( ( ((currentHour + 24) * 60) + currentMin) - (outTime.getHour() * 60 + outTime.getMinute() ) ) /10 * 1000;
                        }
                        else {
                            price1 = ( currentDay - outTime.getDayOfYear() ) * 20000;
                            price2 = ( ( currentHour * 60 + currentMin) - (outTime.getHour() * 60 + outTime.getMinute() ) ) /10 * 1000;
                        }
                        
                        if( price2 > 20000 ) { price2 = 20000;}
                        int price3 = price1 + price2;
                        System.out.println("요금은: "+price3 );



                        carParkingList = carParkingList.replace(parkingAry[i]+"\n","" ); // 삭제
                        System.out.println(carParkingList);
                        break;
                        
                    }
                }
            } 


        }
    }
}



/* static String carParkingList = "3,211가6231,202608190930\n8,452하1234,202608171227";

        public static void main(String[] args) {
            System.out.println(carParkingList);
            Scanner scan = new Scanner(System.in);

            while (true) {
                System.out.print("1.위치찾기 2.입차 3.출차 선택:");
                int ch = scan.nextInt();
                if( ch == 1 ){
                    System.out.print("차량번호 입력:");
                    String carNumber = scan.next();
                    String result = findCarLocation(carNumber);
                    System.out.println(result);
                } 
                if( ch == 2 ){ 
                    System.out.print("위치번호 입력:");
                    String location = scan.next();
                    System.out.print("차량번호 입력:");
                    String carNumber = scan.next();
                    System.out.print("입차일시 입력:");
                    int dateTime = scan.nextInt();
                    String result2 = incar(location, carNumber, dateTime);
                    System.out.println(result2);
                }  
                if( ch == 3 ){ 
                    System.out.print("차량번호 입력:");
                    String carNumber = scan.next();
                    String result3 = outcar(carNumber);
                    System.out.println(result3);
                } 
            }
        }
        

        public static String findCarLocation(String carNumber){
            String[] row = carParkingList.split( "\n" );
            for(String rows : row){
            String[] data = rows.split(",");
            if(data[1].equals(carNumber)){
                return data[0];
            }
        }
        return "미등록 차량";   
    }

        public static String incar(String location, String carNumber, int dateTime){
            String[] row = carParkingList.split( "\n" );
            for(String rows : row){
            String[] data = rows.split(",");
            if(data[0].equals(location)){
                return "중복주차 불가능";
            }
        }
            carParkingList += "\n" + location + "," + carNumber + "," + dateTime;
            return carParkingList;
    }

        public static String outcar(String carNumber){
            String[] row = carParkingList.split( "\n" );
            
            for(String rows : row){
            String[] data = rows.split(",");
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String formattedDate = data[2].format(formatter);
            if(data[1].equals(carNumber)){
                carParkingList = carParkingList.replace(rows, carNumber);
                return carParkingList;
            }
            int fee = 1000;
            if((Integer.parseInt(localDateTime) - Integer.parseInt(data[2])) < 30){
                return String.valueOf(1000);
            }else if((Integer.parseInt(localDateTime) - Integer.parseInt(data[2])) > 30){
                int PlusMinutes = (Integer.parseInt(localDateTime) - Integer.parseInt(data[2])) - 30;
                int plusfee = (PlusMinutes+9)/10 * 1000;
                fee += plusfee;
                if(fee>20000)
                fee = 20000;
                return String.valueOf(fee);
            }
            return String.valueOf(1000);
        }
        return "미등록 차량";
    } */