package org.programmer.cafe.domain.cart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.programmer.cafe.domain.item.entity.Item;
import org.programmer.cafe.domain.user.entity.User;

@Entity(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public Cart addItem(Item item) {
        this.count += 1;
        this.totalPrice += item.getPrice();
        return this;
    }

    public Cart updateCount(int count) {
        this.count = count;
        return this;
    }

    @Builder
    public Cart(int count, int totalPrice, User user, Item item) {
        this.count = count;
        this.totalPrice = totalPrice;
        this.user = user;
        this.item = item;
    }
}
