package br.com.skeleton.consumer.async.service;

import br.com.skeleton.avro.Message;
import br.com.skeleton.consumer.async.romote.ExternalServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final ExternalServiceApi externalServiceApi;

    public void process(Message message) {
        Optional<Void> byClientId = externalServiceApi.findByClientId(message.getId());
    }

}
