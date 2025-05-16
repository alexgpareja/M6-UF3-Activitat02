package com.iticbcn.mongoapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Mapper.CotxeMapper;
import com.iticbcn.mongoapi.Model.Cotxe;
import com.iticbcn.mongoapi.Repositories.CotxeRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CotxeServiceImpl implements CotxeService {
    @Autowired
    private final CotxeRepository repository;
    private final CotxeMapper mapper;

    @Override
    public Mono<Cotxe> save(CotxeDTO cotxeDTO) {
        return repository.save(mapper.toEntity(cotxeDTO));
    }

    @Override
    public Mono<Cotxe> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Cotxe> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Cotxe> update(CotxeDTO cotxeDTO) {
        return repository.findById(cotxeDTO.id())
                .map(existing -> mapper.toEntity(cotxeDTO))
                .flatMap(repository::save);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Flux<Cotxe> findByMarca(String marca) {
        return repository.findByMarca(marca);
    }
}
