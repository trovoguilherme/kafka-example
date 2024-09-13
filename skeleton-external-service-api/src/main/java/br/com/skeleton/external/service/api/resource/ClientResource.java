package br.com.skeleton.external.service.api.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/client")
@RequiredArgsConstructor
public class ClientResource {

    @GetMapping("/{clientId}")
    public ResponseEntity<Void> findByClientId(@PathVariable final String clientId) {
        log.info("m=findByClientId, clientId={}", clientId);
        return ResponseEntity.ok().build();
    }

}
