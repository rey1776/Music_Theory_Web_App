package com.example.demo;

import com.example.demo.Service.MusicScale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicTheoryApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(MusicTheoryApplication.class, args);
		MusicScale music = (MusicScale) context.getBean("musicScale");
		System.out.println(music);



	}

}
