package com.rep.app.mapper;

import com.rep.app.entity.TelefoneEntity;
import com.rep.app.model.dto.TelefoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TelefoneEntityMapper {

    TelefoneEntityMapper INSTANCE = Mappers.getMapper(TelefoneEntityMapper.class);

    @Mapping(target = "idTelefone", source = "idTelefone")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "codOperadora", source = "codOperadora")
    @Mapping(target = "whatsapp", source = "whatsapp")
    TelefoneEntity toEntity(TelefoneDTO dto);

    @Mapping(target = "idTelefone", source = "idTelefone")
    @Mapping(target = "telefone", source = "telefone")
    @Mapping(target = "codOperadora", source = "codOperadora")
    @Mapping(target = "whatsapp", source = "whatsapp")
    TelefoneDTO toDto(TelefoneEntity entity);

}