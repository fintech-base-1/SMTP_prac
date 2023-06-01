package com.eastmeet.smtpprac;

import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

import java.io.FilterOutputStream;

@SpringBootApplication
@PropertySource("classpath:env.yml")
public class SmtpPracApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {

		SpringApplication.run(SmtpPracApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		senderService.sendEmail("dongwoo1404@kakao.com",
				"HI",
				"This is body");
	}

}
