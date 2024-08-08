## module-common

```java
package dev.be.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS("0000", "SUCCESS")
    , UNKNOWN_ERROR("9999", "UNKNOWN_ERROR")
    ;

    private String code;
    private String message;
}
```

## module-api

```java
@Service
public class DemoService {

    public String save(){
        System.out.println(CodeEnum.SUCCESS.getCode());
        return "save";
    }

    public String find(){
        return "find";
    }
}
```

```java
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/save")
    public String save() {
        return demoService.save();
    }

    @GetMapping("/find")
    public String find() {
        return demoService.find();
    }
}
```

순수한 Java 객체에 대한 참조는 모듈간 정상적으로 가능하다 !

<img width="1341" alt="1" src="https://github.com/gilyeon00/multiModule/assets/52391627/0ec93bfb-fa0e-458b-b5f1-f9cb5a9754b4">