package test;

import java.util.Scanner;

class Study{
    int contentNo;
    String title;
    int fk_userNo;
    int fk_categoryNo;
    int fk_studyTypeNo;
    int maxMember;
    String detail;
    String date;

    public Study(int contentNo, String title, int fk_userNo, int fk_categoryNo, int fk_studyTypeNo, int maxMember,
            String detail, String date) {
        this.contentNo = contentNo;
        this.title = title;
        this.fk_userNo = fk_userNo;
        this.fk_categoryNo = fk_categoryNo;
        this.fk_studyTypeNo = fk_studyTypeNo;
        this.maxMember = maxMember;
        this.detail = detail;
        this.date = date;
    }
    
}
class User{
    int pk_userNo;
    String userId;
    String userPw;
    String userName;
    int fk_roloNo;
    public User(int pk_userNo, String userId, String userPw, String userName, int fk_roloNo) {
        this.pk_userNo = pk_userNo;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.fk_roloNo = fk_roloNo;
    }
}
class StudyType{
    int pk_studyTypeNo;
    String studyTypeName;
    public StudyType(int pk_studyTypeNo, String studyTypeName) {
        this.pk_studyTypeNo = pk_studyTypeNo;
        this.studyTypeName = studyTypeName;
    }

}
class Role{
    int pk_roleNo;
    String roleName;
    public Role(int pk_roleNo, String roleName) {
        this.pk_roleNo = pk_roleNo;
        this.roleName = roleName;
    }
    
}
class Category{
    int pk_categoryNo;
    String categoryName;
    public Category(int pk_categoryNo, String categoryName) {
        this.pk_categoryNo = pk_categoryNo;
        this.categoryName = categoryName;
    }
}

class StudyRepository{
    Study[] studies = new Study[100];
    // 저장
    boolean save(Study study) {
        for (int index = 0; index < studies.length; index++) {
            if (studies[index] == null) {
                studies[index] = study;
                return true;
            }
        }
        return false;
    }
    // 반환
    Study[] findAll() {
        return studies;
    }
}

class UserRepository{
    User[] users = new User[100];
    boolean save(User user) {
        for (int index = 0; index < users.length; index++) {
            if (users[index] == null) {
                users[index] = user;
                return true;
            }
        }
        return false;
    }
    // 반환
    User[] findAll() {
        return users;
    }
}
public class Minipj1 {
    public static void main(String[] args) {
        StudyRepository studies = new StudyRepository();
        UserRepository users = new UserRepository();
        Scanner scan = new Scanner(System.in);
        for (;;) {
            System.out.println("============ My Community ============ ");
            System.out.println("1.글쓰기 2.글출력 3.회원가입 4.회원목록");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();

            if(ch==1){
                scan.nextLine();
                System.out.print("제목 : ");   String title = scan.nextLine();
                System.out.print("회원번호(1~4) : ");   int fk_userNo = scan.nextInt();
                System.out.print("공부카테고리(1~10) : ");   int fk_categoryNo = scan.nextInt();
                System.out.print("진행방식(1~4) : ");   int fk_studyTypeNo = scan.nextInt();
                System.out.print("모집인원 : ");   int maxMember = scan.nextInt();
                System.out.print("상세내용 : ");   String detail = scan.nextLine();
                System.out.print("등록일을 입력해주세요(XXXX년XX월XX일) : ");   String date = scan.nextLine();

                Study study1 = new Study(title, fk_userNo, fk_categoryNo, fk_studyTypeNo, maxMember, detail, date);
            }
        }
    }
}
