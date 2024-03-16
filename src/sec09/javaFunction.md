
## 🤔 java.util.function의 종류  
 <br/>  
  함수에 따라 요구되는 인자와 반환형이 다르다.

| 함수형 인터페이스 | 메서드 | 인자(들) 타입 | 반환값 타입 |
| --- | --- | --- | --- |
| Runnable (java.lang 패키지) | run |  |  |
| Supplier<T> | get |  | T |
| Consumer<T> | accept | T |  |
| BiConsumer<T, U> | accept | T, U |  |
| Function<T, R> | apply | T | R |
| BiFunction<T, U, R> | apply | T, U | R |
| Predicate<T> | test | T | boolean |
| BiPredicate<T, U> | test | T, U | boolean |
| UnaryOperator<T> | apply | T | T |
| BinaryOperator<T> | apply | T, T | T |