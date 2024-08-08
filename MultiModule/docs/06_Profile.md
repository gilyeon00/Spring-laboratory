- 실제 회사에서 개발할 땐 N개의 Profile 을 설정한다.
    - local, dev, test, prod ..
- 이렇게 나누는 이유
    - 환경별로 설정해야하는 property 값이 다르기 때문 (DB 주소, 로깅 레벨 등)
- 나누는 방법
    - application-{env}.yaml
    - ex) application-local.yaml, application-pdev.yaml ..

- 나눈 profile 을 코드에서 써먹을 수있는 방법
    - 개발 / 운영에서만 사용할 로직을 분리할 수 있음

```java
    @Value("${profile-name}")
    private String profileName;
    
    System.out.println("profileName : " + profileName);
        if(profileName.equals("local")){
            // aaa
        } else if (profileName.equals("beta")) {
            // bbb
        }
```