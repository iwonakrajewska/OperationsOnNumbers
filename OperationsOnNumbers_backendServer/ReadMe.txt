
1.
to build backend server
mvn clean package

2.
to run backend server
java -jar target/OperationsOnNumbers-0.0.1-SNAPSHOT.jar

to check if server is started and service visible
http://localhost:8080/rest/test/ok


3. Info
Backend server runs in Tomcat, 
based on Spring Boot default configuration
Build assumes java8 + maven is installed

There is a couple of questions that should be asked to Requestor
3.1 Should there be any Authorization process? Assumed: token/username is send in header, and logged per request
3.2 Any specific handling for mathematic operation Divide? Assumed: rounding to 2 decimals


4. Design draft
4.1 SpringBoot main starter, 
4.2 ServletDispather configure rest/* url
4.3 Configure Json content 
4.4 Authorization interceptor
4.5 Flow: Controller > Service
4.6 Service operation structure: default(if needed), validate(and return), run operation, prepare response

5. Edge case test
5.1 backend server not working
5.2 incorrect url
5.3 invalid operation attribute
5.4 null/empty input
5.5 Divide numbers - mathematic operation problems for decimal numbers (need clarification from requestor)
