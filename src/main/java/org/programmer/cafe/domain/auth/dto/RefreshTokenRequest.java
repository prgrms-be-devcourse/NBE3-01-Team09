package org.programmer.cafe.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RefreshTokenRequest {

    private Long userId;
    private String accessToken;
}