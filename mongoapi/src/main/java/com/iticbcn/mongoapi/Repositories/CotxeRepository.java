package com.iticbcn.mongoapi.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.iticbcn.mongoapi.Model.Cotxe;

import reactor.core.publisher.Flux;

@Repository
public interface CotxeRepository extends ReactiveMongoRepository<Cotxe, String> {
    Flux<Cotxe> findByMarca(String marca);
}