
https://f-lab.kr/insight/understanding-java-string-handling?gad_source=1&gad_campaignid=22368870602&gbraid=0AAAAACGgUFdQxQEklnjBWIiKJ29A8FjxC&gclid=Cj0KCQiA6sjKBhCSARIsAJvYcpOiDgGZOQTJJkUPZ1r1ripzJryalFf052Lz3acaljUDdlg8_sqNKkMaAuX0EALw_wcB


# String / StringBuilder / StringBuffer


스트링은 기본적으로 **불변객체**이다
그렇기 떄문에 문자열 기반의 데이터를 수정하는 작업은 새로운 객체를 생성하고 삭제하는 로직을 거치게 되기 때문에,
불필요한 메모리를 계속 소모하게 된다. -> 아 이게 문자열을 파싱하는 로직이 비싼 이유일까?


그러한 점에서 StringBuilder, StringBuffer 는 그 자체로 **가변적**이다.
StringBuffer는 멀티스레드 환경에서 안전하게 사용할 수 있도록 동기화를 지원하지만, StringBuilder는 동기화를 지원하지 않는다. 
따라서 단일 스레드 환경에서는 StringBuilder가 더 높은 성능을 제공한다.

그러면 결국
문자열이 불변한다 -> String
가변적인데, 단일스레드 환경이다 -> StringBuilder
가변적인데, 멀티스레드 환경이다 -> StringBuffer

인 것인데 왜 그럴까?
문자열의 가변적인 특징을 가져가기 위해 다른 스트링 타입은 무엇을 포기한걸까?



문자열이 불변이라는 뜻은 -> 자바의 Heap 영역 내부에 "리터럴 전용 풀" 이라는 곳에 동적 메모리를 생성하고 이를 활용한다.
그래서 같은 문자열이면 새로운 문자열 객체를 생성하지 않고 마치 싱글톤 패턴과 같이 가져올 수 있는 것이다.

그리고 바로 이러한 지점에서 불변함이라는 특징이 빛을 받는다.
같은 메모리 객체를 공유하는 다른 String 값이 가변적이라면 반대의 사용하는 측에서도 영향을 받을 수 밖에 없음.
그래서 String 타입은 불변하며 Thread-safe 하다는 것이다.



그럼 어떻게 나머지 두 타입이 수정에 유리한 구조를 갖게되었냐 하면 -> 내부적으로 char[] 배열을 지니고 있음.
그래서 인덱스별로 값을 유동적으로 바꿀 수 있게 되는 것이다.

그럼 어떻게 StringBuffer는 Thread-Safe한 구조를 가질 수 있었을까?

````
 @Override
    public synchronized void ensureCapacity(int minimumCapacity) {
        super.ensureCapacity(minimumCapacity);
    }

    /**
     * @since      1.5
     */
    @Override
    public synchronized void trimToSize() {
        super.trimToSize();
    }

    /**
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @see        #length()
     */
    @Override
    public synchronized void setLength(int newLength) {
        toStringCache = null;
        super.setLength(newLength);
    }

    /**
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @see        #length()
     */
    @Override
    public synchronized char charAt(int index) {
        return super.charAt(index);
    }
    
````

StringBuffer의 내부 구조이다.
내부적으로 synchronized를 통해 동기화를 지원하고 있기 떄문에 Thread-safe하다.
하지만 synchronized를가 Thread-safe를 보장해줌으로서 트레이드오프가 존재하는데, 이건 나중에 동기화에 대해서 알아볼떄 알아보자

