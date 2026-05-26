package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.MovementInputPort; // AJUSTA si tu interfaz se llama distinto
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.MovementRestMapper;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.MovementsApi;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateMovementRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedMovementsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateMovementRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MovementsController implements MovementsApi {

    private final MovementInputPort movementService;
    private final MovementRestMapper movementRestMapper;

    @Override
    public Mono<ResponseEntity<PagedMovementsResponse>> listMovements(UUID accountId,
                                                                      LocalDate startDate,
                                                                      LocalDate endDate,
                                                                      Integer page,
                                                                      Integer size,
                                                                      ServerWebExchange exchange) {

        int p = page != null ? page : 0;
        int s = size != null ? size : 20;

        log.info("HTTP GET /movements accountId={} startDate={} endDate={} page={} size={}",
                accountId, startDate, endDate, p, s);

        return movementService.list(accountId, startDate, endDate, p, s) // Mono<PagedResult<Movement>>
                .map(movementRestMapper::toPagedResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> getMovementById(UUID movementId, ServerWebExchange exchange) {
        log.info("HTTP GET /movements/{}", movementId);

        return movementService.getById(movementId)
                .map(movementRestMapper::toResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> createMovement(CreateMovementRequest createMovementRequest, ServerWebExchange exchange) {
        log.info("HTTP POST /movements accountId={} type={} value={} date={}",
                createMovementRequest.getAccountId(),
                createMovementRequest.getType(),
                createMovementRequest.getValue(),
                createMovementRequest.getDate());

        return movementService.create(movementRestMapper.toDomain(createMovementRequest))
                .doOnSuccess(m -> log.info("Movement created id={} accountId={} type={} value={} balanceAfter={}",
                        m.getId(), m.getAccountId(), m.getType(), m.getValue(), m.getBalanceAfter()))
                .map(saved -> ResponseEntity
                        .created(URI.create("/movements/" + saved.getId()))
                        .body(movementRestMapper.toResponse(saved)));
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> updateMovement(UUID movementId, UpdateMovementRequest updateMovementRequest, ServerWebExchange exchange) {
        log.info("HTTP PUT /movements/{} accountId={} type={} value={} date={}",
                movementId,
                updateMovementRequest.getAccountId(),
                updateMovementRequest.getType(),
                updateMovementRequest.getValue(),
                updateMovementRequest.getDate());

        return movementService.update(movementId, movementRestMapper.toDomain(movementId, updateMovementRequest))
                .map(movementRestMapper::toResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteMovement(UUID movementId, ServerWebExchange exchange) {
        log.info("HTTP DELETE /movements/{}", movementId);

        return movementService.delete(movementId)
                .thenReturn(ResponseEntity.noContent().build());
    }
}
