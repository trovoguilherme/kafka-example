package br.com.skeleton.resource;

import br.com.skeleton.core.entity.Message;
import br.com.skeleton.producer.KafkaAvroProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageResource {

    private final KafkaAvroProducer kafkaAvroProducer;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {

        kafkaAvroProducer.send(message.toAvro());
        message.setStatus(Message.Status.SEND);

        return ResponseEntity.ok(message);
    }

}
