package day02;

public class Exam1 {
    public static void main(String[] args) {
        //  == 다형성 ==
        // [1] 자동(묵시적) 타입 변환 : byte -> short -> int -> long -> float -> double
        byte bytevalue = 100;   // byte 타입에 bytevalue 변수명으로 100 리터럴 대입
        short shortvalue = bytevalue;  // [가능] byte -> short [*자료유지, 타입변경] 
        int intvalue = shortvalue;     // [가능] short -> int [*자료유지, 타입변경]
        long longvalue = intvalue;      // [가능] int -> long [*자료유지, 타입변경]
        float floatvalue = longvalue;    // [가능] long -> float [*자료유지, 타입변경]
        double doublevalue = floatvalue;  // [가능] float -> double [*자료유지, 타입변경]

        // * 연산(계산) 중 자동 타입 변환, byte/short 연산결과 => int , 두 항 중에서 더 큰 타입으로 결과 타입 반환
        byte b1 = 10; byte b2 = 20; short s1 = 30; int i1 = 40; long l1 = 50L; float f1 = 60.1f; double d1 = 70.2;
        int result1 = b1 + b2;   // byte + byte => int
        int result2 = b2 + s1;   // byte + short => int
        int result3 = i1 + i1;   // int + int => int
        long result4 = i1 + l1;   // int + long => long (더 큰 타입으로 결과 타입 반환)
        float result5 = i1 + f1; // int + float => float
        double result6 = i1 + d1; // int + double => double

        // [2] 강제(명시적) 타입 변환 :  byte <- short <- int <- long <- float <- double , 큰거 -> 작은거 , *자료손실 발생 가능성있음
        double dvalue = 3.14;
        float fvalue = (float)dvalue;   // [불가능], 자료앞에(변환할타입명) 명시 하여금 강제로 타입변환 가능 
        long lvalue = (long)fvalue;     // 3.14 -> 3 손실발생
        int ivalue = (int)lvalue;
        short svalue = (short)ivalue;
        byte bvalue = (byte)svalue;
    }
}
