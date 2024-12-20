package org.programmer.cafe.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.programmer.cafe.domain.cart.dto.CreateCartItemRequest;
import org.programmer.cafe.domain.cart.dto.GetCartItemsResponse;
import org.programmer.cafe.domain.cart.service.CartService;
import org.programmer.cafe.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "장바구니 상품 등록 API")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "등록 성공")})
    @PostMapping()
    public ResponseEntity<ApiResponse<?>> createCartItem(
        @Valid @RequestBody CreateCartItemRequest request) {
        // TODO: SecurityContextHolder에서 인증된 유저의 userId를 가져와야 함.
        Long userId = 1L;
        cartService.createCartItem(request, userId);
        return ResponseEntity.ok().body(ApiResponse.createSuccessWithNoData());
    }

    @Operation(summary = "장바구니 상품 조회 API")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "조회 성공")})
    @GetMapping()
    public ResponseEntity<ApiResponse<GetCartItemsResponse>> getCartItems() {
        // TODO: SecurityContextHolder에서 인증된 유저의 userId를 가져와야 함.
        Long userId = 1L;
        return ResponseEntity.ok()
            .body(ApiResponse.createSuccess(cartService.getCartItems(userId)));
    }

    @Operation(summary = "장바구니 상품 수량 변경 API")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "변경 성공")})
    @PatchMapping("/items/{id}")
    public ResponseEntity<ApiResponse<?>> updateCartItemCount(@PathVariable("id") Long itemId,
        @RequestParam int count) {
        // TODO: SecurityContextHolder에서 인증된 유저의 userId를 가져와야 함.
        Long userId = 1L;
        cartService.updateCartItemCount(itemId, count, userId);
        return ResponseEntity.ok().body(ApiResponse.createSuccessWithNoData());
    }

    @Operation(summary = "장바구니 상품 삭제 API")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "삭제 성공")})
    @DeleteMapping("/items/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCartItem(@PathVariable("id") Long itemId) {
        // TODO: SecurityContextHolder에서 인증된 유저의 userId를 가져와야 함.
        Long userId = 1L;
        cartService.deleteCartItem(itemId, userId);
        return ResponseEntity.ok().body(ApiResponse.createSuccessWithNoData());
    }
}
