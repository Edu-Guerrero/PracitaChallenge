package com.challenge.accounts_movements_service.application.util;

import java.util.List;

public record PagedResult<T>(
        List<T> content,
        int page,
        int size,
        long totalElements
) {}
