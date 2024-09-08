package br.com.skeleton.consumer;

import br.com.skeleton.avro.Message;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaAvroConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, Message> consumerRecord) {
        String key = consumerRecord.key();
        Message message = consumerRecord.value();

        log.info("Message received key: " + key + " Value: " + message);
    }

}
