package com.iticbcn.mongoapi.Mapper;

import org.mapstruct.Mapper;
import com.iticbcn.mongoapi.DTO.CotxeDTO;
import com.iticbcn.mongoapi.Model.Cotxe;

@Mapper(componentModel = "spring")
public interface CotxeMapper {

    CotxeDTO toDTO(Cotxe cotxe);

    Cotxe toEntity(CotxeDTO dto);
}