package st.malike.distributed.tracing.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * malike_st
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringMongoDB {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(SpringMongoDB.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


}
