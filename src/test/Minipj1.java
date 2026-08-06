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

    public Study(String title, int fk_userNo, int fk_categoryNo, int fk_studyTypeNo, int maxMember,
            String detail, String date) {
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
    public User(String userId, String userPw, String userName) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
    }
}
class StudyType{
    int pk_studyTypeNo;
    String studyTypeName;
    public StudyType( String studyTypeName) {
        this.studyTypeName = studyTypeName;
    }

}
class Role{
    int pk_roleNo;
    String roleName;
    public Role(String roleName) {
        this.roleName = roleName;
    }
    
}
class Category{
    int pk_categoryNo;
    String categoryName;
    public Category(String categoryName) {
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
                boolean result = studies.save(study1);

                if(result){System.out.println("게시물 작성 성공");}
                else{System.out.println("게시물 작성 실패");}
                
            }else if(ch==2){
                Study[] result = studies.findAll();
                for(Study study1 : result){
                    if(study1 != null){
                        System.out.printf("제목 : %s , 회원번호(1~4) : %d 공부카테고리(1~10) : %d , 진행방식(1~4) : %d 모집인원 : %d , 상세내용 : %s 등록일을 입력해주세요(XXXX년XX월XX일) : %s \n", study1.title, study1.fk_userNo, study1.fk_categoryNo, study1.fk_studyTypeNo, study1.maxMember, study1.detail, study1.date );
                    }
                }
            }else if(ch==3){
                scan.nextLine();
                System.out.print("ID : ");   String userId = scan.nextLine();
                System.out.print("PW : ");   String userPw = scan.nextLine();
                System.out.print("이름 : ");   String userName = scan.nextLine();
                User user = new User(userId, userPw, userName);
                boolean result = users.save(user);

                if(result){System.out.println("회원가입 성공");}
                else{System.out.println("회원가입 실패");}

            }else if (ch == 4) {
                User[] result = users.findAll();
                for (User user : result) {
                    if (user != null) {
                        System.out.printf("ID : %s , PW : %s , 이름 : %s \n", user.userId, user.userPw, user.userName);
                    }
                }
        }
    }
}
}
