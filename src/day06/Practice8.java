package day06;

import org.w3c.dom.css.Rect;

class Book{
    // 1. 멤버변수
    String title;
    String author;
    int price;
    // 2. 생성자 :
    // 자동 : 클래스내 빈공간 오른쪽 -> 소스 작업 -> constructure -> 멤버변수 체크 -> 확인
    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class Rectangle{
    int width;
    int height;

    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }
}

class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;

    BankAccount(String accountNumber, String ownerName, int balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
}

class Goods{
    String name;
    int price;

    Goods(){
        this.name = "미정";
        this.price = 0;
    }

    Goods(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class Member{
    String id;
    boolean isLogin;

    Member(){
        this.id = "guest";
        this.isLogin = false;
    }
}
public class Practice8 {
    public Practice8() {
    }

    public static void main(String[] args) {
        // 1.
        Book B1 = new Book("이것이 자바다", "신용권", 30000);
        Book B2 = new Book("자바의 정석", "남궁성", 28000);
        System.out.printf("%s %s %d\n", B1.title, B1.author, B1.price);
        System.out.printf("%s %s %d\n", B2.title, B2.author, B2.price);

        // 2. 
        Rectangle r1 = new Rectangle(10, 5);
        System.out.printf("width:%d height:%d \n", r1.width, r1.height);

        // 3.
        BankAccount b1 = new BankAccount("111-222-3333", "유재석", 10000);
        System.out.printf("계좌번호:%s, 예금주명:%s, 잔액:%d \n", b1.accountNumber, b1.ownerName, b1.balance);

        // 4. 
        Goods g1 = new Goods();
        Goods g2 = new Goods("콜라", 2000);
        System.out.printf("음료:%s 가격:%d \n", g1.name, g1.price);
        System.out.printf("음료:%s 가격:%d \n", g2.name, g2.price);

        // 5.
        Member m1 = new Member();
        System.out.printf("id:%s isLogin:%b", m1.id, m1.isLogin);

    }
}
