package org.programmer.cafe.domain.user.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageSearchRequest {
    private final Long id;
    private final String name;
    private final String email;

}
