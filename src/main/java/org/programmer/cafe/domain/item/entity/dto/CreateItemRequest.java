package org.programmer.cafe.domain.item.entity.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.programmer.cafe.domain.item.entity.ItemStatus;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CreateItemRequest {

    @Schema(description = "상품명", requiredMode = RequiredMode.REQUIRED, defaultValue = "커피콩")
    @NotBlank(message = "상품명을 입력해주세요.")
    private String name;

    @Schema(description = "이미지 경로", requiredMode = RequiredMode.REQUIRED, defaultValue = "/img/coffee.png")
    private String image;

    @Schema(description = "가격", requiredMode = RequiredMode.REQUIRED, defaultValue = "10000")
    @PositiveOrZero(message = "가격은 0 이상이어야 합니다.")
    private int price;

    @Schema(description = "재고", requiredMode = RequiredMode.REQUIRED, defaultValue = "15")
    @PositiveOrZero(message = "재고는 0 이상이어야 합니다.")
    private int stock;

    @Schema(description = "상태", requiredMode = RequiredMode.REQUIRED, allowableValues = {"ON_SALE",
        "OUT_OF_STOCK", "DISCONTINUED"})
    @NotNull(message = "상태를 입력해주세요.")
    private ItemStatus status;
}
