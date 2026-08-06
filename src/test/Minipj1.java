package test;
class StudyList{
    int contentNo;
    String title;
    int fk_userNo;
    int fk_categoryNo;
    int fk_studyTypeNo;
    int maxMember;
    int[] members;
    String detail;
    String date;

    public StudyList(int contentNo, String title, int fk_userNo, int fk_categoryNo, int fk_studyTypeNo, int maxMember,
            int[] members, String detail, String date) {
        this.contentNo = contentNo;
        this.title = title;
        this.fk_userNo = fk_userNo;
        this.fk_categoryNo = fk_categoryNo;
        this.fk_studyTypeNo = fk_studyTypeNo;
        this.maxMember = maxMember;
        this.members = members;
        this.detail = detail;
        this.date = date;
    }
    
}
class UserList{
    int pk_userNo;
    String userId;
    String userPw;
    String userName;
    int fk_roloNo;
    public UserList(int pk_userNo, String userId, String userPw, String userName, int fk_roloNo) {
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
public class Minipj1 {
    public static void main(String[] args) {

    }
}
