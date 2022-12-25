package ma.enset.immatriculationservice;

import com.thoughtworks.xstream.XStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ImmatriculationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmatriculationServiceApplication.class, args);
	}

	@Bean
	public XStream xStream() {
		XStream xStream = new XStream();

		xStream.allowTypesByWildcard(new String[] { "**" });
		return xStream;
	}
}
