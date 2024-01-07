package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.respositories.ColorRepository;
import org.springframework.stereotype.Service;

@Service
public class ColorService {

    final ColorRepository colorRepository;

    public ColorService (ColorRepository colorRepository){
        this.colorRepository = colorRepository;
    }
}
