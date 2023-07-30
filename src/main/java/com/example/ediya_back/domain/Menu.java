package com.example.ediya_back.domain;

import com.example.ediya_back.dto.request.MenuRequest;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Long id;

    private String name;

    private String imgLink;

    @Column(columnDefinition = "text")
    private String detail;

    private String giftLink;

    public void update(MenuRequest request) {
        this.imgLink = request.getImgLink();
        this.name = request.getName();
        this.detail = request.getDetail();
        this.giftLink = request.getGiftLink();
    }
}
