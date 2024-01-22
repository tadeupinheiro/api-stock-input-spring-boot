package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ColorModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ColorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    final ColorRepository colorRepository;

    public ColorService (ColorRepository colorRepository){
        this.colorRepository = colorRepository;
    }

    public boolean existsByColorCode(Integer idColor) {
        return this.colorRepository.existsById(idColor);
    }

    @Transactional
    public ColorModel saveColor(ColorModel colorModel) {
        this.colorRepository.save(colorModel);
        return colorModel;
    }

    public List<ColorModel> findAllColors() {
        List<ColorModel> colorModelList = this.colorRepository.findAll();
        return colorModelList;
    }

    public Optional<ColorModel> findColor(Integer idColor) {
        Optional<ColorModel> colorModelOptional = this.colorRepository.findById(idColor);
        return colorModelOptional;
    }

    @Transactional
    public void deleteColor(ColorModel colorModel) {
        this.colorRepository.delete(colorModel);
    }
}
