package day08;
// 1.
class Member{
    private String id;
 
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
}
// 2.
class Score{
    private int score;

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        if(score < 0 && score > 100){
            System.out.println("유효하지않은 점수입니다");
        }else{System.out.println(score);}
        return this.score;
    }
}
// 3.
class BankAccount{
    private String accountNumber;

    public BankAccount() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
public class Project10 {
    public static void main(String[] args) {
        // 1.
        Member m1 = new Member();
        m1.setId("admin");
        System.out.println(m1.getId());
        
        // 2.
        Score s1 = new Score();
        s1.setScore(85);
        System.out.println(s1.getScore());
        s1.setScore(120);
        System.out.println(s1.getScore());

        // 3.
        BankAccount b1 = new BankAccount();
        
    }
}
