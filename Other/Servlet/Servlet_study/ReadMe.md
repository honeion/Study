# Servlet/JSP 공부
 - 업무 때문에 다시 공부

# Web Application Architecutre
 - 브라우저를 통해 다양한 정보를 제공하는 서비스를 제작하는 서버측 S/W
 - 요청에 대한 응답

## Was 서버와 Web 서버의 차이
  - Was 
	- 업무, Data, 서버리소스
	- n-tier Architecture (Client-Server-DB)
	- GUI, BL 분리
	- Thread, LB, 장애대체, 일종의 WebService
	- 연산처리함
	- tomcat, tMax(국내정부), Web Logic, IBM Web Spere ...
  - Web 
	- Http 요청에 대해 Html과 같은 정적 웹페이지 반환(아파치, nginx)
	- 정적 페이지 처리
	- Was 서버 보완(단순데이터 처리로 WAS의 부하 줄이기)
	- Was 앞에 proxy처럼 붙어서 기본 리소스 처리
	- IIS(MS->asp언어), apache, nginx(php, servlet/jsp)

 - [Web] [Was] 이런데, 보통 [Web[Was]]로 표현(web서버 안에 was서버)

## 개발환경
 - JDK 설치
 - eclipse java EE 설치
 
# Servlet 기초 구성

## Servlet 구동원리

### 자바 서블릿 특징
 - 자바를 사용하여 웹페이지를 동적으로 생성하는 서버 측 프로그램
 - 웹서버의 성능을 향상시키기 위해 사용되는 자바 클래스 
 - 자바 코드 안에 HTML 포함 / JSP는 HTML안에 자바 코드 포함

### 구동특징
 - 최초 요청 
    > Servlet 컴파일 -> 메모리 로드 -> 쓰레드 가동 -> 응답
 - 최초요청 
    > JSP -> Servlet 번역 -> Servlet 컴파일 -> 메모리 로드 -> 쓰레드 가동 > 응답
 - 이후요청
    > 쓰레드 가동 > 응답
 - 최초 응답은 느리고 이후 응답은 빠름
 - CGI 
    > 요청 -> 작업 프로세스 할당(요청 몰리면 과부하)
 - PHP, ASP
    > 요청 -> 쓰레드 할당(번역, 연산 후) > 응답(인터프리터 방식)

**Eclipse Servlet import Error**
 - 이클립스내 프로젝트에 Server 라이브러리가 설정 안됐을 수 있음
 - Java Build Path에서 Add Library - Server Runtime 추가

### Web.xml
 - Default Page 선언

## Get/Post 방식의 데이터 전송

### HTTP(HyperText Ransfer Protocol) 정의
  - WWW 상에서 정보를 주고받을 수 있는 프로토콜
  - HTTP는 클라이언트와 서버 사이에 이루어지는 요청/응답 프로토콜

### 요청메소드
  |Name|Description|Req Body 유무|Res Body 유무|
  |---|---|---|---|
  |GET|URL에 해당하는 자료의 전송을 요청|X|Y|
  |HEAD|GET과 같은 요청이나 자료에 대한 정보(META-INFO)만 받음|X|X|
  |POST|서버가 처리할 수 있는 자료를 보냄|Y|Y|
  |PUT|해당 URL에 자료를 저장함|Y|Y|
  |DELETE|해당 URL의 자료를 삭제함|X|Y|
  |TRACE|이전에 요청한 내용을 들을 것을 요청|X|Y|
  |OPTIONS|서버가 특정 URL에 대해 어떤 HTTP Method를 지원하는지 물음|options|Y|
  |CONNECT|TCP 연결을 원하는 대상으로 전달하도록 HTTP프록시 서버에 요청|Y|Y|
  |PATCH|리소스에 대한 부분적인 수정을 적용|Y|Y|

### 주요 응답코드
 |Code|Msg|Description|
 |--|--|--|
 |1XX|Information(정보)|정보교환|
 |2XX|Success(성공)|데이터 전송이 성공적으로 이루어졌거나, 이해되거나 수락됨|
 |200|OK|오류 없이 전송 성공|
 |3XX|Redirection|자료위치 변경|
 |4XX|Client Error|클라이언트 측 오류, 주소 잘못입력 or 잘못된 요청|
 |400|Bad Request|요청 실패. 문법상 오류로 서버가 요청사항 이해 불가|
 |401.1|Unauthorized|권한 없음(접속실패)|
 |403.2|Forbidden|금지 (읽기 접근 금지)|
 |403.7|Forbidden|금지 (클라이언트 인증서 필요)|
 |404|Not Found|문서를 찾을 수 없음|
 |405|Method not allowed|요청에 지정된 방법 사용 불가(POST대신 GET 으로 요청 등)|
 |5XX|Server Error|서버 측의 오류로 올바른 처리 불가|
 |500|Internal Server Error|서버 내부 오류|
 |503|Service Unavailable|외부 서비스가 죽거나 현재 멈춘상태|

## JSON 
 - JSON(JavaScript Object Notation)의 정의
 - key-value 쌍으로 이루어진 데이터 오브젝트를 전달하기 위해 인간이 읽을 수있는 텍스트를 사용하는 개방형 표준 포맷DLA
 - 비동기 브라우저/서버 통신(AJAX)을 위해, 넓게는 XML을 대체하는 주요 데이터 포맷
 - 프로그래밍 언어나 플랫폼에 독립적
 - 공식 인터넷 미디어 타입(mime)과 확장자(.json)
   - application/json(or text/plain)
  
 - [온라인 유효성 검사기](json.parser.online.fr)