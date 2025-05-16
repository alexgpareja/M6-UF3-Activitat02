package com.iticbcn.mongoapi.Repository;

import com.iticbcn.mongoapi.Model.Cotxe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotxeRepository extends ReactiveMongoRepository<Cotxe, String> {
}