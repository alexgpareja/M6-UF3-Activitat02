package com.iticbcn.mongoapi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Mapper.CotxeMapper;
import com.iticbcn.mongoapi.Model.Cotxe;
import com.iticbcn.mongoapi.Repositories.CotxeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CotxeServiceImpl implements CotxeService {

  private final CotxeRepository repository;

  private final CotxeMapper mapper;

  @Autowired
  public CotxeServiceImpl(CotxeRepository repository, CotxeMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Mono<Cotxe> save(@RequestBody CotxeDTO cotxeDTO) {
    System.out.println("CotxeDTO recibido: " + cotxeDTO);
    Cotxe cotxe = mapper.toEntity(cotxeDTO);
    System.out.println("Cotxe convertido: " + cotxe);
    return repository.save(cotxe);
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
