package com.iticbcn.mongoapi.Repository;

import com.iticbcn.mongoapi.Model.Cotxe;

import reactor.core.publisher.Flux;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotxeRepository extends ReactiveMongoRepository<Cotxe, String> {
    Flux<Cotxe> findByMarca(String marca);
}