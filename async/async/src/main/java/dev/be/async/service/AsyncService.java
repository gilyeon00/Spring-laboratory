package dev.be.async.service;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall_1(){
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());

        // 주입받은 Bean 의 메서드 사용
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_2(){
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());

        // 단순 인스턴스 사용
        EmailService emailService = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_3(){
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());

        // 내부 메서드 Async 로 설정
        sendMail();
    }

    @Async
    public void sendMail(){
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}
