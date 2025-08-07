# GoF의 디자인 패턴
## 1. 스터디 계획서
### 1. 스터디 주제 
- GoF의 디자인 패턴
### 2. 스터디 목표  
- GoF의 디자인 패턴 16개의 개념에 대해 학습하고, 이를 코드에 적용할 수 있다.
### 3. 진행 개요   
- 진행 횟수 : 주 1회 - 매주 상의 후 결정
- 진행 시간 : 17:00 ~ 18:30

### 4. 스터디 활동 계획
- 5/8 (목) : 아래 패턴 中 각자 택 1 하여 개념 발표 및 코드 공유
- 5/15 (목) : 아래 패턴 中 각자 택 1 하여 개념 발표 및 코드 공유
- 5/22 (목) : 아래 패턴 中 각자 택 1 하여 개념 발표 및 코드 공유
- 5/29 (목) : 아래 패턴 中 각자 택 1 하여 개념 발표 및 코드 공유

  - Iterator, Template Method, Singleton, Prototype, Bridge, Strategy, Decorator, State, Flyweight, Proxy, Command, Observer, Composite, Future, Facade, Factory Method
  - 총 16개 패턴 학습 완료

### 5. 참고 자료
- 스터디 깃허브 주소: git@github.com:KernelAcademy-Study/DesignPattern.git
- 책: JAVA 언어로 배우는 디자인 패턴 입문 3판

### 6. 패턴별 상세 문서

#### 1. 객체 생성과 재사용
**학습 목표**: 객체의 생성 방법과 관련된 패턴, 객체 생성에 대한 기본적인 이해
- [Singleton 패턴](src/wooyong/Singleton/) - 기본 객체 생성 개념, 하나의 인스턴스를 공유해야 하는 경우 이해
- [Factory Method 패턴](src/wooyong/Factory%20Method/) - 객체 생성을 서브클래스에 위임하여 객체 생성을 추상화
- [Prototype 패턴](src/wooyong/Prototype/) - 객체를 복제하여 생성하는 방식, 객체 복제의 필요성
- [Flyweight 패턴](src/wooyong/Flyweight/) - 메모리 효율성을 고려한 객체 공유 방법

#### 2. 로직 캡슐화와 구조적 확장
**학습 목표**: 객체 간의 관계나 구조 설계에 대한 패턴, 각 객체의 협력과 구조적 설계 방안을 순차적으로 학습
- [Facade 패턴](src/Daehwa/Facade/Facade.md) - 전체 시스템을 단순화하여 외부에서 쉽게 접근 가능
- [Bridge 패턴](src/Daehwa/Bridge/Bridge.md) - 추상과 구현을 분리해 독립적 확장
- [Decorator 패턴](src/Daehwa/Decorator/Decorator.md) - 기존 객체에 기능을 동적으로 추가
- [Proxy 패턴](src/Daehwa/Proxy/Proxy.md) - 대리 객체로 다른 객체에 대한 접근을 제어

#### 3. 행위 패턴
**학습 목표**: 객체 간의 상호작용과 책임 분배, 그리고 비즈니스 로직의 흐름을 다루는 패턴, 흐름에 따라 순서대로 학습
- [Strategy 패턴](src/taehyun/Strategy_Pattern_Book/) - 동적 알고리즘 교체를 통한 유연한 설계
- [State 패턴](src/taehyun/State_Pattern_Book/) - 객체의 상태에 따른 동작 변경
- [Iterator 패턴](src/taehyun/Iterator_Pattern_Book/) - 컬렉션의 요소를 순차적으로 접근
- [Future 패턴](src/taehyun/Future_Pattern_MyCode/) - 비동기 작업을 처리하는 대리 객체 패턴

#### 4. 구조적 / 행위 혼합 패턴
**학습 목표**: 구조적 요소와 행위적 요소를 동시에 다루는 패턴, 이들을 유기적으로 결합하여 실무 및 프로젝트에 적용
- [Template Method 패턴](src/minsoo/TemplateMethodPattern/TemplateMethod.md) - 알고리즘의 골격을 정의, 세부적인 구현은 서브 클래스에서
- [Command 패턴](src/minsoo/CommandPattern/README.md) - 요청을 객체로 캡슐화하여 실행, 큐에 쌓기 등
- [Observer 패턴](src/minsoo/ObserverPattern/) - 상태 변화에 대한 알림을 다른 객체에 전달
- [Composite 패턴](src/minsoo/CompositePattern/) - 트리 구조로 객체들을 구성하여 부분, 전체를 동일하게 다루는 방식
***
## 2. 리포지토리 사용
- 각자 이름이 적힌 폴더에서 진행
    - git merge 시에 충돌 방지

### 폴더별 구현 패턴 목록
- **Daehwa 폴더**: 
  - Bridge (추상화와 구현 분리)
  - Decorator (기능 동적 확장)
  - Facade (복잡한 시스템 단순화)
  - Proxy (접근 제어 및 대리)

- **minsoo 폴더**:
  - Command (요청을 객체화)
  - Composite (객체 트리 구조)
  - Observer (객체 간 의존성 관리)
  - Template Method (알고리즘 골격 정의)

- **taehyun 폴더**:
  - Iterator (컬렉션 순회)
  - State (상태에 따른 행동 변화)
  - Strategy (알고리즘 교체)
  - Future (비동기 처리)

- **wooyong 폴더**:
  - Factory Method (객체 생성 추상화)
  - Flyweight (메모리 효율적 객체 공유)
  - Prototype (객체 복제)
  - Singleton (단일 인스턴스)
***
## 3. 진행 상황
### 1. 05.08
- 김태현: Strategy 패턴 (알고리즘을 교체 가능하게 설계)
- 이민수: Template Method 패턴 (상속 기반 알고리즘 골격 정의)
- 김대화: Facade 패턴 (복잡한 서브시스템 단순화)
- 이우용: Singleton 패턴 (전역 단일 인스턴스)

### 2. 05.15
- 김태현: State 패턴 (상태 변화에 따른 객체 행동 변경)
- 이민수: Command 패턴 (요청을 객체화하여 재사용성 확보)
- 김대화: Bridge 패턴 (추상화와 구현 분리로 독립 확장)
- 이우용: Factory Method 패턴 (객체 생성 로직 추상화)

### 3. 05.22
- 김태현: Iterator 패턴 (컬렉션 순회 표준화)
- 이민수: Observer 패턴 (객체 간 의존성 관리)
- 김대화: Decorator 패턴 (런타임 기능 확장)
- 이우용: Prototype 패턴 (객체 복제)

### 4. 05.29
- 김태현: Future 패턴 (비동기 처리)
- 이민수: Composite 패턴 (트리 구조 객체 처리)
- 김대화: Proxy 패턴 (접근 제어 및 대리 객체)
- 이우용: Flyweight 패턴 (메모리 효율적 객체 공유)