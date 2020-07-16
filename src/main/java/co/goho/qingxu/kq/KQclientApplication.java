package co.goho.qingxu.kq;

import co.goho.qingxu.kq.model.KQClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KQclientApplication {

	public static void main(String[] args) {
		KQClient.runClient("ws://49.235.104.157:25303");
		SpringApplication.run(KQclientApplication.class, args);
	}

}

