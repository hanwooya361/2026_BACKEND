package day09.종합예제.model.dto;

public class BoardDto {
    // DTO : 데이터 이동 객체, 자바는 저장소가 아님. 즉 DB(저장소)가 저장소
    // - DB 표에서 사용할 (CRUD)자료들을 private 멤버변수로 구성
    private String content;
    private String writer;
    // 2. 기본생성자, 전체매개변수 생성자
    public BoardDto() {
    }
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
    // 3. setter and getter, toString
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    @Override
    public String toString() {
        return "BoardDto [content=" + content + ", writer=" + writer + "]";
    }
    
}
