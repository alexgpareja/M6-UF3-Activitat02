package com.iticbcn.mongoapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Model.Cotxe;
import com.iticbcn.mongoapi.Services.CotxeServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cotxes")
public class CotxeController {

  @Autowired
  private final CotxeServiceImpl cotxeService;

  public CotxeController(CotxeServiceImpl cotxeService) {
    this.cotxeService = cotxeService;
  }

  @PostMapping("/save")
  public Mono<Cotxe> createCotxe(@RequestBody CotxeDTO cotxeDTO) {
    return cotxeService.save(cotxeDTO);
  }

  @GetMapping("/{id}")
  public Mono<Cotxe> getCotxeById(@PathVariable String id) {
    return cotxeService.findById(id);
  }

  @GetMapping("/all")
  public Flux<Cotxe> getAllCotxes() {
    return cotxeService.findAll();
  }

  @PutMapping("/update")
  public Mono<Cotxe> updateCotxe(@RequestBody CotxeDTO cotxeDTO) {
    return cotxeService.update(cotxeDTO);
  }

  @DeleteMapping("/delete/{id}")
  public Mono<Void> deleteCotxe(@PathVariable String id) {
    return cotxeService.delete(id);
  }
}