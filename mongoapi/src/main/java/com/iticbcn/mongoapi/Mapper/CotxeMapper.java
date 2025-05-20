package com.iticbcn.mongoapi.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Model.Cotxe;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CotxeMapper {

    CotxeDTO toDTO(Cotxe cotxe);

    Cotxe toEntity(CotxeDTO dto);
}