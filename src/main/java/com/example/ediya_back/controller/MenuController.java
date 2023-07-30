package com.example.ediya_back.controller;

import com.example.ediya_back.domain.Menu;
import com.example.ediya_back.dto.request.MenuRequest;
import com.example.ediya_back.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/menu/create")
    public Menu menu(@RequestBody MenuRequest request){
        Menu menu = Menu.builder()
                .name(request.getName())
                .imgLink(request.getImgLink())
                .detail(request.getDetail())
                .giftLink(request.getGiftLink())
                .build();
        menuService.create(menu);
        return menu;
    }
    @PostMapping("/menu/{id}")
    public Menu findById(@PathVariable Long id){
        Menu menu = menuService.findById(id);
        return menu;
    }
    @PostMapping("/menu/list")
    public ResponseEntity<List<Menu>> findAll(){
        return ResponseEntity.ok(menuService.findAll());
    }

    @PatchMapping("/menu/{bucket_id}")
    public ResponseEntity<Menu> update(@PathVariable Long bucket_id, @RequestBody MenuRequest request){
        return ResponseEntity.ok(menuService.update(bucket_id, request));
    }

    @DeleteMapping("/menu/{bucket_id}")
    public ResponseEntity<Long> delete(@PathVariable Long bucket_id){
        menuService.delete(bucket_id);
        return ResponseEntity.ok(bucket_id);
    }

}
