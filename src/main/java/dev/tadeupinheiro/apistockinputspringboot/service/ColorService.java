package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.respositories.ColorRepository;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.UUID;

@Service
public class ColorService {

    final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository){
        this.colorRepository = colorRepository;
    }

    public boolean existsColorCode(UUID colorCode){
        return colorRepository.existsByColorCode(colorCode);
    };
}
