## **1. Decorator 패턴의 정의**

- 객체에 동적으로 책임 추가 가능
- 상속 대신 조립(composition) 사용
- 핵심 구성요소
    - Component (인터페이스/추상 클래스)
    - ConcreteComponent (기본 기능 구현)
    - Decorator (Component 참조)
    - ConcreteDecorator (추가기능 구현)
- 확장성과 유연성을 높이는 동시에 코드 중복 줄일 수 있음

---

## **2. Decorator 패턴의 장단점**

- **장점**:
    1. 열린-폐쇄 원칙(OCP) 준수: 기존 코드를 변경하지 않고 기능 확장 가능
    2. 유연한 조합 가능: 여러 데코레이터를 조합해 다양한 기능 제공
    3. 런타임 동적 확장: 애플리케이션 실행 중에도 기능 추가/제거 용이
    4. 책임 분리: 핵심 기능과 부가 기능을 분리해 유지보수성 향상
- **단점**:
    1. 클래스 수 증가: 많은 데코레이터 클래스 작성으로 코드베이스 복잡성 증가
    2. 데코레이터 체인 복잡도: 중첩된 래핑으로 호출 흐름 파악 어려움
    3. 디버깅 난이도: 분산된 기능으로 인해 문제 원인 찾기 까다로움
    4. 성능 오버헤드: 추가적인 래핑 및 메서드 호출로 인한 성능 저하 우려

## **3. Decorator 패턴이 적용된 코드**

```java
// Component 인터페이스
public interface Component { void operation(); }

// ConcreteComponent
public class ConcreteComponent implements Component {
    @Override public void operation() {
        System.out.println("ConcreteComponent 동작");
    }
}

// Decorator 추상 클래스
public abstract class Decorator implements Component {
    protected Component component;
    public Decorator(Component component) { this.component = component; }
    @Override public void operation() { component.operation(); }
}

// ConcreteDecoratorA
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    @Override public void operation() {
        super.operation(); addedBehavior();
    }
    private void addedBehavior() {
        System.out.println("추가 기능 A 구현");
    }
}
```

---

## **3. 실무에서 쓰이는 Decorator 패턴**

- **Java I/O 스트림**

```java
// FileInputStream: ConcreteComponent
InputStream fis = new FileInputStream("data.txt");
// BufferedInputStream: Decorator
InputStream bis = new BufferedInputStream(fis);
// DataInputStream: 또 다른 Decorator
DataInputStream dis = new DataInputStream(bis);

// 사용 예시
while (dis.available() > 0) {
    String line = dis.readLine();
    System.out.println(line);
}
dis.close();
```

- **구성**: FileInputStream → BufferedInputStream → DataInputStream
- 버퍼링, 자료형 읽기 기능을 동적으로 추가

- **Spring AOP (프록시 기반 Decorator)**

```java
@Aspect
public class LoggingAspect {
    @Around("execution(* com.example.service.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[LOG] Method 시작: " + pjp.getSignature());
        Object result = pjp.proceed();
        System.out.println("[LOG] Method 종료: " + pjp.getSignature());
        return result;
    }
}
```

-
    - BeanPostProcessor가 대상 Bean을 프록시로 감싸고, 메서드 호출 전후에 부가 기능 삽입

- **커스텀 서비스 Decorator 예시**

```java
// 1) Component 인터페이스
public interface PaymentService {
    void pay(int amount);
}

// 2) ConcreteComponent
public class BasicPaymentService implements PaymentService {
    @Override
    public void pay(int amount) {
        // 실제 결제 로직
        System.out.println(amount + "원 결제 완료");
    }
}

// 3) Decorator 추상 클래스
public abstract class PaymentDecorator implements PaymentService {
    protected PaymentService wrapped;
    public PaymentDecorator(PaymentService service) { this.wrapped = service; }
    @Override public void pay(int amount) { wrapped.pay(amount); }
}

// 4) ConcreteDecorator - 로깅
public class LoggingPaymentDecorator extends PaymentDecorator {
    public LoggingPaymentDecorator(PaymentService service) { super(service); }
    @Override
    public void pay(int amount) {
        System.out.println("[Log] 결제 시작: " + amount);
        super.pay(amount);
        System.out.println("[Log] 결제 종료: " + amount);
    }
}

// 5) ConcreteDecorator - 보안 검사
public class SecurePaymentDecorator extends PaymentDecorator {
    public SecurePaymentDecorator(PaymentService service) { super(service); }
    @Override
    public void pay(int amount) {
        // 인증/인가 로직
        if (!AuthManager.isAuthenticated()) {
            throw new RuntimeException("인증 필요");
        }
        super.pay(amount);
    }
}

// **사용 예시**
PaymentService service = new SecurePaymentDecorator(
    new LoggingPaymentDecorator(
        new BasicPaymentService()
    )
);
service.pay(10000);
```

-
    - 로그인 검사, 로깅 기능을 런타임에 체인으로 적용

## **4. 유사 패턴 비교 유사 패턴 비교**

| **패턴** | **목적** | **차이점** |
| --- | --- | --- |
| Proxy | 접근 제어 | 기능 추가보다 제어에 집중 |
| Strategy | 알고리즘 교체 | 책임을 교체, 추가 아님 |
| Adapter | 인터페이스 호환 | 인터페이스 변환 목적 |

---

## **5. 면접 예상 질문**

- Decorator 패턴의 장단점은?
- 사용 시점과 대안 패턴은?
- 데코레이터 체인이 길어질 때 문제점은?
- Java I/O에서의 적용 예는?
