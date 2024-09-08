package br.com.skeleton.producer;

import br.com.skeleton.avro.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Message> template;

    public void send(Message message) {
        CompletableFuture<SendResult<String, Message>> future = template.send(topicName, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message" + result.getRecordMetadata().offset());
            } else {
                System.out.println("Not sent message" + ex.getMessage());
            }
        });
    }

}
