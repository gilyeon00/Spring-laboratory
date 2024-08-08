## module-common

Service Bean 을 하나 만들어준다.

```java
package dev.be.modulecommon.service;

import org.springframework.stereotype.Service;

@Service
public class CommonDemoService {

    public String commonService(){
        return "commonService";
    }
}
```

## module-api

module-api 에서 원래 사용하던 대로 의존성 주입을 해준다.

```java
@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;

    public String save(){
        System.out.println(CodeEnum.SUCCESS.getCode());
        System.out.println();
        System.out.println(commonDemoService.commonService());
        return "save";
    }

    public String find(){
        return "find";
    }
}
```

## ➡️ Bean 주입 실패 🚨
<img width="1167" alt="2" src="https://github.com/gilyeon00/multiModule/assets/52391627/b15d1643-a4b1-4735-acd5-6dbf7154a009">

# ⭐️ Component Scan

Application 파일의 main 메서드를 실행시키는 패키지를 기준으로 컴포넌트 스캔(=Bean 스캔)이 일어난다.

➡️ Applicaion 파일의 현재 위치는 module-api 하위에 있다. 그렇다면, module-api 하위 패키지에서만 Bean 스캔이 일어나게 된다.
(정확히는 **dev.be**.moduleapi.ModuleApplicaion.java 이므로, dev.be.moduleapi 하위 패키지의 Bean 들을 읽어온다.)
따라서, CommonDemoService 는 **dev.be**.modulecommon.service 에 위치하기때문에, 해당 Bean 을 스캔하지 못한다.

➡️ 공통되는 path 는 **dev.be** 이므로, Application 파일을 **dev.be 하위로 옮겨주면 된다 ! ⭐️**

![3](https://github.com/gilyeon00/multiModule/assets/52391627/5dde6875-3080-4ab2-80ff-38dccaa5771b)

## 정리

순수한 Java 객체를 모듈간에 사용할 때는 문제가 없지만, Spring Bean 을 사용할 경우, 컴포넌트 스캔이라는 개념이 매우 중요 !
컴포넌트 스캔이 정상적으로 일어나야지만 모듈간의 Bean 을 주입받아 사용할 수 있음

## 🤔 Application 파일을 옮기지 않고 할 수 있는 다른 방법 ?

dev.be.modulecomon 경로에 있는 컴포넌트들만 읽어오면 될텐데 !

![4](https://github.com/gilyeon00/multiModule/assets/52391627/130d8193-4e00-45cf-a143-db3aa00851ff)

scanBasePackages 에 String[] 로 읽어오고자하는 패키지 경로를 기입해준다 ! ⭐️

![5](https://github.com/gilyeon00/multiModule/assets/52391627/5bf3b744-36e8-4b72-afb8-853a356932a3)


### 이 방식의 장점

회사에는 모듈이 정말 많을텐데, 모든 모듈의 빈을 다 스캔하는건 시간도 많이 걸리고 비효율적
➡️ 지정한 곳에서만 빈 스캔이 일어나기 때문에 시간 단축, 효율적으로 컨트롤 가능