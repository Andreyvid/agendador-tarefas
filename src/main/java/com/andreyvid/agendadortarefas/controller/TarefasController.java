package com.andreyvid.agendadortarefas.controller;

import com.andreyvid.agendadortarefas.business.TarefasService;
import com.andreyvid.agendadortarefas.business.dto.TarefasDto;
import lombok.RequiredArgsConstructor;
import org.osgi.annotation.bundle.Header;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDto> gravarTarefas(@RequestBody TarefasDto dto,
                                                    @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDto>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDto>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token){

        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }
}
