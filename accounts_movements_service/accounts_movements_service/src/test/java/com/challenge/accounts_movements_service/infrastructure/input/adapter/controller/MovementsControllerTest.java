package com.challenge.accounts_movements_service.infrastructure.input.adapter.controller;

import com.challenge.accounts_movements_service.application.input.port.MovementInputPort;
import com.challenge.accounts_movements_service.application.util.PagedResult;
import com.challenge.accounts_movements_service.domain.model.Movement;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.mapper.MovementRestMapper;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.CreateMovementRequest;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.MovementResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.PagedMovementsResponse;
import com.challenge.accounts_movements_service.infrastructure.input.adapter.rest.customer_service.bean.UpdateMovementRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovementsControllerTest {

    private MovementInputPort movementService;
    private MovementRestMapper mapper;
    private MovementsController controller;
    private ServerWebExchange exchange;

    @BeforeEach
    void setUp() {
        movementService = mock(MovementInputPort.class);
        mapper = mock(MovementRestMapper.class);
        controller = new MovementsController(movementService, mapper);
        exchange = mock(ServerWebExchange.class);
    }

    @Test
    void listMovements_shouldDelegateAndReturnList() {
        UUID accId = UUID.randomUUID();
        int p = 0, s = 10;
        var pagedResp = mock(PagedMovementsResponse.class);
        PagedResult<Movement> pagedMovements = mock(PagedResult.class);

        when(movementService.list(accId, null, null, p, s)).thenReturn(Mono.just(pagedMovements));
        when(mapper.toPagedResponse(any())).thenReturn(pagedResp);

        var result = controller.listMovements(accId, null, null, p, s, exchange).block();
        assertNotNull(result);
        assertSame(pagedResp, result.getBody());
        verify(movementService).list(accId, null, null, p, s);
        verify(mapper).toPagedResponse(any());
    }

    @Test
    void getMovementById_shouldWork() {
        UUID movementId = UUID.randomUUID();
        var domainMvt = mock(com.challenge.accounts_movements_service.domain.model.Movement.class);
        var apiResp = mock(MovementResponse.class);

        when(movementService.getById(movementId)).thenReturn(Mono.just(domainMvt));
        when(mapper.toResponse(domainMvt)).thenReturn(apiResp);

        var result = controller.getMovementById(movementId, exchange).block();
        assertNotNull(result);
        assertSame(apiResp, result.getBody());
    }

    @Test
    void createMovement_shouldDelegateAndReturnCreated() {
        CreateMovementRequest req = mock(CreateMovementRequest.class);
        var domainMvt = mock(com.challenge.accounts_movements_service.domain.model.Movement.class);
        var apiResp = mock(MovementResponse.class);
        UUID mvtId = UUID.randomUUID();
        when(domainMvt.getId()).thenReturn(mvtId);

        when(mapper.toDomain(req)).thenReturn(domainMvt);
        when(movementService.create(domainMvt)).thenReturn(Mono.just(domainMvt));
        when(mapper.toResponse(domainMvt)).thenReturn(apiResp);

        var result = controller.createMovement(req, exchange).block();
        assertNotNull(result);
        assertEquals("/movements/" + mvtId, result.getHeaders().getLocation().toString());
        assertSame(apiResp, result.getBody());
    }

    @Test
    void updateMovement_shouldDelegateAndReturnOk() {
        UUID mvtId = UUID.randomUUID();
        UpdateMovementRequest req = mock(UpdateMovementRequest.class);
        var domainMvt = mock(com.challenge.accounts_movements_service.domain.model.Movement.class);
        var apiResp = mock(MovementResponse.class);

        when(mapper.toDomain(mvtId, req)).thenReturn(domainMvt);
        when(movementService.update(mvtId, domainMvt)).thenReturn(Mono.just(domainMvt));
        when(mapper.toResponse(domainMvt)).thenReturn(apiResp);

        var result = controller.updateMovement(mvtId, req, exchange).block();
        assertNotNull(result);
        assertSame(apiResp, result.getBody());
    }

    @Test
    void deleteMovement_shouldReturnNoContent() {
        UUID mvtId = UUID.randomUUID();
        when(movementService.delete(mvtId)).thenReturn(Mono.empty());

        var result = controller.deleteMovement(mvtId, exchange).block();
        assertNotNull(result);
        assertEquals(204, result.getStatusCodeValue());
    }
}
