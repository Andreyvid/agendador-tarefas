package com.andreyvid.agendadortarefas.business.mapper;

import com.andreyvid.agendadortarefas.business.dto.TarefasDto;
import com.andreyvid.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDto dto);

    TarefasDto paraTarefaDto(TarefasEntity entity);

    List<TarefasEntity> paraListaTarefasEntity (List<TarefasDto> dtos);

    List<TarefasDto> paraListaTarefasDTO (List<TarefasEntity> entity);
}
