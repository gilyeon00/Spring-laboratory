package deb.be.feign.service;


import deb.be.feign.feign.client.DemoFeignClient;
import deb.be.feign.feign.common.dto.BaseRequestInfo;
import deb.be.feign.feign.config.DemoFeignConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final DemoFeignClient demoFeignClient;

    public String get(){
        demoFeignClient.callGet();
    }
}
