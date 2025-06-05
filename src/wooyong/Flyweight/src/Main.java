public class Main {
    public static void main(String[] args) {
        // 테스트를 위해 직접 문자열 설정
        String input = "10000110";

        BigString bs = new BigString(input);
        bs.print();
    }
}

//Main
// └─> BigString("101110110")
//      └─> for each char → BigCharFactory.getBigChar()
//             └─> Map에 없으면 new BigChar + Map에 저장
//             └─> Map에 있으면 기존 객체 반환
//      └─> 배열 bigchars[] 에 저장
//
//bs.print() 호출 시
// └─> 각 BigChar 객체의 print() 호출 → 콘솔 출력