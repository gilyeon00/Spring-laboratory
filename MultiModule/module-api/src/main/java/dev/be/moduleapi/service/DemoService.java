package dev.be.moduleapi.service;


import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repository.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;
    private final MemberRepository memberRepository;


    @Value("${profile-name}")
    private String profileName;

    public String save(){
        Member member = Member
                .builder()
                .name(Thread.currentThread().getName())
                .build();
        memberRepository.save(member);

        System.out.println("profileName : " + profileName);
        if(profileName.equals("local")){
            // aaa
        } else if (profileName.equals("beta")) {
            // bbb
        }
        return "save";
    }

    public String find(){
        int size = memberRepository.findAll().size();
        System.out.println("DB size : " + size);
        return "find";
    }

    public String exception(){
        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "exception";
    }
}
