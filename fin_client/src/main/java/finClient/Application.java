package finClient;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    // Имя обменника
    static final String topicExchangeName = "personal-finance";
    // Имя очереди для отправки сообщения
    static final String queueName = "personal-finance";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args).close();
    }
}