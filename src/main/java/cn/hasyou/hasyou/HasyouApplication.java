package cn.hasyou.hasyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 有你启动类
 */
@SpringBootApplication
@RestController
public class HasyouApplication {

	@GetMapping("/hi")
	public ResponseEntity hi() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hi david");
	}

	@GetMapping("/hello")
    public ResponseEntity hello () {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("hello david");
    }

	public static void main(String[] args) {
		SpringApplication.run(HasyouApplication.class, args);
	}
}
