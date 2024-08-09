package deb.be.feign.controller;


import deb.be.feign.feign.common.dto.BaseRequestInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target_server")
public class TargetController {

    @GetMapping("/get")
    public BaseRequestInfo demoGet(@RequestHeader("CustomHeaderName") String header,
                                   @RequestParam("name") String name,
                                   @RequestParam("age") Long age){
        return BaseRequestInfo.builder()
                .header(header)
                .name(name + " from target server")
                .age(age)
                .build();
    }
}
