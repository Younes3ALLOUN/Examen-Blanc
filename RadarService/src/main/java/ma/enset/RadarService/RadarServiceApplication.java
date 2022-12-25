package ma.enset.RadarService;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class RadarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadarServiceApplication.class, args);
	}


}
