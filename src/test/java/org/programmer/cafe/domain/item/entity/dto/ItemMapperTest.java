package org.programmer.cafe.domain.item.entity.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.programmer.cafe.domain.item.entity.Item;
import org.programmer.cafe.domain.item.entity.ItemStatus;

class ItemMapperTest {

    @Test
    void testDtoToEntity() {
        final ItemDto createDto = ItemDto.builder().name("커피콩").price(1000).image("/img/asdsad.png")
            .stock(15).status(ItemStatus.ON_SALE).build();

        final Item entity = ItemMapper.INSTANCE.toEntity(createDto);

        assertEquals(createDto.getName(), entity.getName());
        assertEquals(createDto.getPrice(), entity.getPrice());
        assertEquals(createDto.getImage(), entity.getImage());
        assertEquals(createDto.getStock(), entity.getStock());
        assertEquals(createDto.getStatus(), entity.getStatus());
    }

    @Test
    void testEntityToDto() {
        final Item entity = Item.builder().name("커피콩").price(1000).image("/img/asdsad.png")
            .stock(15).status(ItemStatus.ON_SALE).build();

        final ItemDto createDto = ItemMapper.INSTANCE.toDto(entity);
        assertEquals(createDto.getName(), entity.getName());
        assertEquals(createDto.getPrice(), entity.getPrice());
        assertEquals(createDto.getImage(), entity.getImage());
        assertEquals(createDto.getStock(), entity.getStock());
        assertEquals(createDto.getStatus(), entity.getStatus());
    }
}