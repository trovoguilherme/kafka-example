package br.com.skeleton.producer;

import br.com.skeleton.avro.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaAvroProducer {

    private final StreamBridge streamBridge;

    public void send(Message message) {

        log.info("Sending message id={}", message.getId());

        boolean send = streamBridge.send("output-out-0", message);

        if (!send) {
            throw new RuntimeException("Message not send");
        }
    }

}
