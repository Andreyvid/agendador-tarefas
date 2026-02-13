package com.andreyvid.agendadortarefas.business;

import com.andreyvid.agendadortarefas.business.dto.TarefasDto;
import com.andreyvid.agendadortarefas.business.mapper.TarefasConverter;
import com.andreyvid.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.andreyvid.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.andreyvid.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.andreyvid.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDto gravarTarefa(String token,TarefasDto dto){
        String email = jwtUtil.extrairEmailToken(token).substring(7);
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENDTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDto(
                tarefasRepository.save(entity));
    }
}
