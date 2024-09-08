package br.com.skeleton.consumer;

import br.com.skeleton.avro.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
public class KafkaAvroConsumer {

    @Bean
    public Consumer<Message> messageConsumer() {
        return message -> {
            log.info("Message Received: {}", message);
        };
    }

}
