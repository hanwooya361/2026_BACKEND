package day09.대기명단.model.dto;

public class BoardDto {
    // DTO : 데이터 이동 객체, 자바는 저장소가 아님. 즉 DB(저장소)가 저장소
    // - DB 표에서 사용할 (CRUD)자료들을 private 멤버변수로 구성
    private String number;
    private int people;
    // 2. 기본생성자, 전체매개변수 생성자
    public BoardDto() {
    }
    public BoardDto(String number, int people) {
        this.number = number;
        this.people = people;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getPeople() {
        return people;
    }
    public void setPeople(int people) {
        this.people = people;
    }
    @Override
    public String toString() {
        return "BoardDto [number=" + number + ", people=" + people + "]";
    }
    
}
