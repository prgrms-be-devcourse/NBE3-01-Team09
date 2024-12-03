package org.programmer.cafe.domain.item.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.programmer.cafe.domain.item.entity.Item;
import org.programmer.cafe.domain.item.entity.dto.ItemDto;
import org.programmer.cafe.domain.item.entity.dto.ItemMapper;
import org.programmer.cafe.domain.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * 상품 서비스 클래스
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 상품 전체 목록 반환 메서드
     *
     * @return List<Item>
     */
    public List<Item> getItemList() {
        return itemRepository.findAll();
    }

    public ItemDto save(ItemDto itemDto) {
        final Item item = ItemMapper.INSTANCE.toEntity(itemDto);
        final Item saved = itemRepository.save(item);
        return ItemMapper.INSTANCE.toDto(saved);
    }
}
