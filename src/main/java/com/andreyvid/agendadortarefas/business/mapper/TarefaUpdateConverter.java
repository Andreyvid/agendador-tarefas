package com.andreyvid.agendadortarefas.business.mapper;


import com.andreyvid.agendadortarefas.business.dto.TarefasDto;
import com.andreyvid.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefasDto dto, @MappingTarget TarefasEntity entity);
}
