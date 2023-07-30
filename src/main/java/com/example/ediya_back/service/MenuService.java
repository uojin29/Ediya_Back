package com.example.ediya_back.service;

import com.example.ediya_back.domain.Menu;
import com.example.ediya_back.dto.request.MenuRequest;
import com.example.ediya_back.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuService {
    private final MenuRepository menuRepository;

    public Menu create(Menu menu){
        menuRepository.save(menu);
        return menu;
    }

    public Menu findById(Long id){
        Menu menu = menuRepository.findById(id).get();
        return menu;
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

    public Menu update(Long id, MenuRequest request){
        Menu menu = menuRepository.findById(id).get();
        menu.update(request);
        menuRepository.save(menu);
        return menu;
    }

    public void delete(Long id){
        menuRepository.deleteById(id);
    }
}
