package com.iticbcn.mongoapi.Service;

import com.iticbcn.mongoapi.Model.Cotxe;
import com.iticbcn.mongoapi.DTO.CotxeDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CotxeService {
    Mono<Cotxe> save(CotxeDTO cotxeDTO);
    Mono<Cotxe> findById(String id);
    Flux<Cotxe> findAll();
    Mono<Cotxe> update(CotxeDTO cotxeDTO);
    Mono<Void> delete(String id);
}