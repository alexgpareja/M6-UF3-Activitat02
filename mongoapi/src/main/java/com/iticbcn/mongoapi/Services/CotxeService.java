package com.iticbcn.mongoapi.Services;

import org.springframework.web.bind.annotation.RequestBody;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Model.Cotxe;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CotxeService {
    Mono<Cotxe> save(@RequestBody CotxeDTO cotxeDTO);

    Mono<Cotxe> findById(String id);

    Flux<Cotxe> findAll();

    Mono<Cotxe> update(CotxeDTO cotxeDTO);

    Mono<Void> delete(String id);
}