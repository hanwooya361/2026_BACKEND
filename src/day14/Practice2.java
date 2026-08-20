package day14;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
    public static void main(String[] args) {
        // <?>는 "어떤 타입이든 다 들어올 수 있는 와일드카드(조커) 타입"
        List<InventorySlot<?>> inventory = new ArrayList<>();
        // ?: 와일드 카드 타입 사용한경우(String/Double 등등 다양한 제네릭 타입 사용하기 위해서)
        InventorySlot<String> slot1 = new InventorySlot(1, "집행자의 검");
        InventorySlot<Double> slot2 = new InventorySlot(2, 500000);
        InventorySlot<Integer> slot3 = new InventorySlot(3, 85.5);
        InventorySlot<String> slot4 = new InventorySlot(4, "드래곤 갑옷");
        // ? 와일드 카드 타입인 경우 다양한 제네릭타입 받을 수 있다.
        inventory.add(slot1);   //문자열 무기 ("집행자의 검")
        inventory.add(slot2);   //정수형 골드 (500000)
        inventory.add(slot3);   //실수형 강화 확률 (85.5)
        inventory.add(slot4);   //문자열 방어구 ("드래곤 갑옷")
        System.out.println("==== 인벤토리 슬롯 목록 ====");
        inventory.forEach( (list1) -> {System.out.println("[슬롯 "+list1.getSlotNumber() + "번] 보관: "+list1.getData());});
        System.out.println("============================");
    }
}

class InventorySlot< T > {
    private int slotNumber;
    private T data;

    public InventorySlot(int slotNumber, T data){
        this.slotNumber = slotNumber;
        this.data = data;
    }
    public int getSlotNumber(){
        return slotNumber;
    }
    public T getData(){
        return data;
    }
}

/* package day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // <?>는 "어떤 타입이든 다 들어올 수 있는 와일드카드(조커) 타입"
        List<InventorySlot<?>> inventory = new ArrayList<>(); 
        InventorySlot<String> weapon = new InventorySlot<>();
        InventorySlot<Integer> gold = new InventorySlot<>();
        InventorySlot<Double> up = new InventorySlot<>();
        InventorySlot<String> shiled = new InventorySlot<>();
        weapon.setSlotNumber(1);
        weapon.setData("집행자의 검");
        inventory.add(weapon);
        gold.setSlotNumber(2);
        gold.setData(50000);
        inventory.add(gold);
        up.setSlotNumber(3);
        up.setData(25.5);
        inventory.add(up);
        shiled.setSlotNumber(4);
        shiled.setData("드래곤 갑옷");
        inventory.add(shiled);
        inventory.forEach((list1) -> {System.out.println("슬롯"+list1.getSlotNumber()+"번호"+":"+ list1.getData());});
    }
}

class InventorySlot< T > {
    private int slotNumber;
    private T data;
    public int getSlotNumber() {
        return slotNumber;
    }
    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public InventorySlot(int slotNumber, T data) {
        this.slotNumber = slotNumber;
        this.data = data;
    }
    
}

-------------------------------------------
[ Practice15 ] 컬렉션 기반 인벤토리 슬롯 관리 시스템
상황: 
게임 인벤토리는 여러 개의 제네릭 슬롯(InventorySlot<T>)으로 구성되며, 
전체 슬롯 목록은 List 컬렉션을 통해 일괄 관리 및 순회 출력을 수행합니다.

요구사항:
1. InventorySlot<T> 제네릭 클래스 작성:
   - 필드: private int slotNumber, private T data
2. Main 실행 클래스 구현:
   - 다음 슬롯 객체들을 리스트에 추가:
     * 슬롯 1번: 문자열 무기 ("집행자의 검")
     * 슬롯 2번: 정수형 골드 (500000)
     * 슬롯 3번: 실수형 강화 확률 (85.5)
     * 슬롯 4번: 문자열 방어구 ("드래곤 갑옷")
   -  for문(for-each)을 사용하여 모든 슬롯 정보를 순회 출력

출력 예시:
=== 인벤토리 슬롯 목록 ===
[슬롯 1번] 보관: 집행자의 검
[슬롯 2번] 보관: 500000
[슬롯 3번] 보관: 85.5
[슬롯 4번] 보관: 드래곤 갑옷
------------------------------------------- */