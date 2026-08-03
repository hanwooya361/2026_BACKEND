package day04;

import java.util.Arrays;

public class Activity {
    public static void main(String[] args) {
        
        // [1] 배열
        int[] array = new int[0]; // 0개 저장 가능한 배열

        // [2] 배열내 꼬리(마지막 인덱스)에 요소 추가 , array.length-1
        // array[array.length-1] = 30;

        // [3] 현재 배열내 +1 증가한 배열 만들기
        int[] newArray = new int[array.length+1];

        // [*]
        for(int i=0; i<=array.length-1; i++){
            newArray[i] = array[i]; // 오른쪽 기존배열 i값을 새로운배열 i에 대입
        }
        // [4] [2] 반복
        newArray[newArray.length-1] = 30;
        
        // [5] 기존 배열 변수에 새로운 배열 대입
        array = newArray;

        // [*]
        System.out.print(Arrays.toString(array));
    }
}

/* package day04;

import java.util.Scanner;

public class Activity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] original = new int[0];
        while (true) {

            System.out.println("----------------------------------------");
            System.out.print("현재 배열 [크기: " + original.length + "]: ");

            if (original.length == 0) {
                System.out.println("비어 있음");
            } else {
                System.out.print("[ ");
                for (int i = 0; i < original.length; i++) {
                    System.out.print(original[i]);
                    if (i != original.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(" ]");
            }

            System.out.println();
            System.out.println("1. 요소 추가 | 2. 인덱스로 삭제 | 0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int ch = scanner.nextInt();

            if (ch == 1) {

                System.out.print("추가할 정수 값을 입력하세요: ");
                int value = scanner.nextInt();

                int[] newArray = new int[original.length + 1];

                for (int i = 0; i < original.length; i++) {
                    newArray[i] = original[i];
                }

                newArray[newArray.length - 1] = value;

                original = newArray;

                System.out.println(">> " + value + " 값이 성공적으로 추가되었습니다.");

            } else if (ch == 2) {

                if (original.length == 0) {
                    System.out.println(">> 삭제할 데이터가 없습니다.");
                    continue;
                }

                System.out.print("삭제할 인덱스 번호(0 ~ " + (original.length - 1) + ")를 입력하세요: ");
                int index = scanner.nextInt();

                if (index < 0 || index >= original.length) {
                    System.out.println(">> 잘못된 인덱스입니다.");
                    continue;
                }

                int deleteValue = original[index];
                int[] newArray = new int[original.length - 1];

                int j = 0;
                for (int i = 0; i < original.length; i++) {
                    if (i != index) {
                        newArray[j] = original[i];
                        j++;
                    }
                }

                original = newArray;

                System.out.println(">> 인덱스 [" + index + "]의 값 (" + deleteValue + ")이 삭제되었습니다.");

            } else if (ch == 0) {

                System.out.println("프로그램을 종료합니다.");
                break;

            } else {

                System.out.println("잘못된 메뉴입니다.");

            }
        }

        scanner.close();
    }
} */
    