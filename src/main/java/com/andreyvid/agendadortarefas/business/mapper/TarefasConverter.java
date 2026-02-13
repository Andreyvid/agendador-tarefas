package com.andreyvid.agendadortarefas.business.mapper;

import com.andreyvid.agendadortarefas.business.dto.TarefasDto;
import com.andreyvid.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDto dto);

    TarefasDto paraTarefaDto(TarefasEntity entity);
}
