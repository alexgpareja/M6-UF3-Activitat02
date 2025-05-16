package com.iticbcn.mongoapi.Services;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Model.Cotxe;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CotxeService {
    Mono<Cotxe> save(@RequestBody CotxeDTO cotxeDTO);

    Mono<Cotxe> findById(String id);

    Flux<Cotxe> findAll();

    Mono<Cotxe> update(CotxeDTO cotxeDTO);

    Mono<Void> delete(String id);
}