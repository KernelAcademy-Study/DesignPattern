public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars;

    //생성자
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigchars = new BigChar[string.length()];
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    //표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}

// 문자열 전체를 관리하는 클래스.
// 각 글자마다 BigCharFactory에 해당 글자에 맞는 BigChar 객체를 요청.
// 이미 있으면 재사용, 없으면 생성 후 등록.
