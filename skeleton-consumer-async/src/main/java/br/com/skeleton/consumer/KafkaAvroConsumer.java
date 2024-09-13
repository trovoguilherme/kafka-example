package br.com.skeleton.consumer;

import br.com.skeleton.avro.Message;
import br.com.skeleton.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaAvroConsumer {

    private final MessageService messageService;

    @Bean
    public Consumer<Message> messageConsumer() {
        return message -> {
            log.info("Message Received: {}", message);

            messageService.process(message);

            log.info("m=messageConsumer, msg=External Service called with success");
        };
    }

}
