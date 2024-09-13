package br.com.skeleton.consumer.async.romote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "externalServiceApi", url = "${remote.external-service-api.url}")
public interface ExternalServiceApi {

    @GetMapping("/{clientId}")
    Optional<Void> findByClientId(@PathVariable String clientId);

}
