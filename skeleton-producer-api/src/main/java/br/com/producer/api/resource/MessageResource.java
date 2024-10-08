package br.com.producer.api.resource;

import br.com.producer.api.producer.KafkaAvroProducer;
import br.com.skeleton.core.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageResource {

    private final KafkaAvroProducer kafkaAvroProducer;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {

        message.setId(UUID.randomUUID().toString());

        kafkaAvroProducer.send(message.toAvro());

        return ResponseEntity.ok(message);
    }

}
