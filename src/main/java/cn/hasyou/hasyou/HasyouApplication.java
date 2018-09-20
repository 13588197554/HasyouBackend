package cn.hasyou.hasyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 有你启动类
 */
@SpringBootApplication
@RestController
public class HasyouApplication {

	@GetMapping("/hi")
	public String hi() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(HasyouApplication.class, args);
	}
}
