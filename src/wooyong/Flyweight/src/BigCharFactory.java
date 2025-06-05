import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    //이미 만든 BigChar 인스턴스를 관리
    private Map<String,BigChar> pool = new HashMap<>();
    //Singleton 패턴
    private static BigCharFactory singleton = new BigCharFactory();

    //생성자
    private BigCharFactory() {
    }

    //유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    //BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = pool.get(String.valueOf(charname));
        if (bc == null) {
            //여기서 BigChar 인스턴스를 생성
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}

//	Flyweight 객체를 관리하는 핵심 클래스.
//	내부에 Map<String, BigChar> 풀(pool)을 가지고 있음 → 같은 문자면 같은 인스턴스 반환.
//	싱글턴(Singleton) 방식으로 전역 1개만 생성되어 재사용.