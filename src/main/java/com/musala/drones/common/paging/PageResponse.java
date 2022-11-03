package com.musala.drones.common.paging;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponse<T>(Meta<T> meta, List<T> data) {
    public PageResponse(Page<T> page) {
        this(new Meta<>(page), page.getContent());
    }

    public record Meta<T>(long total, boolean hasNext) {
        public Meta(Page<T> page) {
            this(page.getTotalElements(), page.hasNext());
        }
    }
}
