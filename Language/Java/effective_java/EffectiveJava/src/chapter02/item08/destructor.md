# 자바의 2가지 객체 소멸자

## finailzer
 - 예측할 수 없고, 상황에 따라 위험할 수 있어 일반적으로 불필요
 - java 9에서 deprecated API로 지정하고 cleaner를 대안으로 소개함
 
## cleaner
 - finalizer보다는 덜 위험하지만 예측할 수 없고, 느리고 일반적으로 불필요함
 
### [java](finalizer && cleaner) != [c++] destructor
 - C++에서의 파괴자는 특정 객체와 관련된 자원을 회수하는 보편적인 방법
 - 자바에서는 접근할 수 없게 된 객체를 회수하는 역할을 GC가 담당(try-with-resources, try-finally로 처리)
 