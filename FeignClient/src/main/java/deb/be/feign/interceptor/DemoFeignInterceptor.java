package deb.be.feign.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
/*
    interceptor : 우리가 요청을 보낼 때 한 곳에서 그 요청을 해서, 필요로 하는 공통적인 설정을 할 수 있는 것
 */
@RequiredArgsConstructor(staticName = "of")
public class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {

        if (template.method() == Request.HttpMethod.GET.name()) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " +
                    template.queries());
            return;
        }

        if(Objects.equals(template.method(), Request.HttpMethod.POST.name())){
            String encodedRequestBody = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);
            System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedRequestBody);
            String convertRequestBody = encodedRequestBody;
            template.body(convertRequestBody);
        }

    }
}
