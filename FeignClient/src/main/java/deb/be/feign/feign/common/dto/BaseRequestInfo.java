package deb.be.feign.feign.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // Json Serialize, Deserialize 와 같은 작업이 있을 때, 그 시점에 값이 없다면 해당 필드를 제외해줌
public class BaseRequestInfo {

    private String name;
    private Long age;
}

/*
@JsonInclude(JsonInclude.Include.NON_NULL) 역할
{
    "name" : null (X)
    , "age" : 12
}

{
    "age" : 12 (O)
}
 */
