package cecy.matriculacion.login;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootTest
class LoginApplicationTests {

	@Test
	public static void main(String[] args){
		SpringApplication.run(LoginApplicationTests.class, args);
	}

}
