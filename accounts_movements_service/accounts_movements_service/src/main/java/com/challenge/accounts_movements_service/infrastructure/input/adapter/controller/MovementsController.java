package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.MovementInputPort;
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

import static com.challenge.accounts_movements_service.infrastructure.util.Constants.*;

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

        log.info(IN + ACTION_LIST + "list movements accountId={} startDate={} endDate={} page={} size={}",
                accountId, startDate, endDate, p, s);

        return movementService.list(accountId, startDate, endDate, p, s)
                .map(movementRestMapper::toPagedResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_LIST + "movements listed successfully accountId={} startDate={} endDate={} page={} size={}",
                        accountId, startDate, endDate, p, s))
                .doOnError(e -> log.error(OUT + ACTION_LIST + "error listing movements accountId={} startDate={} endDate={} page={} size={}. Error: {}",
                        accountId, startDate, endDate, p, s, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> getMovementById(UUID movementId, ServerWebExchange exchange) {
        log.info(IN  + ACTION_GET_BY_ID + "get movements with id: {}", movementId);

        return movementService.getById(movementId)
                .map(movementRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_GET_BY_ID + "movement  retrieved successfully id={}",
                        resp != null && resp.getBody() != null ? resp.getBody().getId() : null))
                .doOnError(e -> log.error(OUT + ACTION_GET_BY_ID + "error retrieving movement id={}. Error: {}",movementId, e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> createMovement(CreateMovementRequest createMovementRequest, ServerWebExchange exchange) {
        log.info(IN + ACTION_CREATE + "create movement accountId={} type={} value={} date={}",
                createMovementRequest.getAccountId(),
                createMovementRequest.getType(),
                createMovementRequest.getValue(),
                createMovementRequest.getDate());

        return movementService.create(movementRestMapper.toDomain(createMovementRequest))
                .doOnSuccess(m -> log.info(OUT + ACTION_CREATE + "movement created id={} accountId={} type={} value={} balanceAfter={}",
                        m.getId(), m.getAccountId(), m.getType(), m.getValue(), m.getBalanceAfter()))
                .map(saved -> ResponseEntity
                        .created(URI.create("/movements/" + saved.getId()))
                        .body(movementRestMapper.toResponse(saved)))
                .doOnError(e -> log.error(OUT + ACTION_CREATE + "error creating movement. Error: {}", e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<MovementResponse>> updateMovement(UUID movementId, UpdateMovementRequest updateMovementRequest, ServerWebExchange exchange) {
        log.info(IN + ACTION_UPDATE + "update movements/{} accountId={} type={} value={} date={}",
                movementId,
                updateMovementRequest.getAccountId(),
                updateMovementRequest.getType(),
                updateMovementRequest.getValue(),
                updateMovementRequest.getDate());

        return movementService.update(movementId, movementRestMapper.toDomain(movementId, updateMovementRequest))
                .map(movementRestMapper::toResponse)
                .map(ResponseEntity::ok)
                .doOnSuccess(resp -> log.info(OUT + ACTION_UPDATE + "movement movements/{} accountId={} type={} value={} date={}",
                        movementId, updateMovementRequest.getAccountId(), updateMovementRequest.getType(), updateMovementRequest.getValue(), updateMovementRequest.getDate()))
                .doOnError(e -> log.error(OUT + ACTION_UPDATE + "error updating movement. Error: {}",
                        e.getMessage(), e));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteMovement(UUID movementId, ServerWebExchange exchange) {
        log.info(IN + ACTION_DELETE + "delete movement with id: {}", movementId);

        return movementService.delete(movementId)
                .thenReturn(ResponseEntity.noContent().<Void>build())
                .doOnSuccess(message -> log.info(OUT + ACTION_DELETE + "delete movement successfully with id {}", movementId))
                .doOnError(e -> log.error(OUT + ACTION_DELETE + "Error deleting movement. Error: {}", e.getMessage()));
    }
}
