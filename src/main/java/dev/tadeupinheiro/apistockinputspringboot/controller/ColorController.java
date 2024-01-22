package dev.tadeupinheiro.apistockinputspringboot.controller;

import dev.tadeupinheiro.apistockinputspringboot.dtos.ColorRecordDto;
import dev.tadeupinheiro.apistockinputspringboot.models.ColorModel;
import dev.tadeupinheiro.apistockinputspringboot.service.ColorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/color")
public class ColorController {
@Autowired
ColorService colorService;
@PostMapping
public ResponseEntity saveColor (@RequestBody @Valid ColorRecordDto colorRecordDto){
    var colorModel = new ColorModel();
    if(colorService.existsByColorCode(colorRecordDto.colorCode())){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Color already exists");
    }
    BeanUtils.copyProperties(colorRecordDto, colorModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(colorService.saveColor(colorModel));
}

@GetMapping
public ResponseEntity<List<ColorModel>> getAllColors (){
    return ResponseEntity.status(HttpStatus.OK).body(colorService.findAllColors());
}

@GetMapping("/{colorCode}")
public ResponseEntity<Object> getOneColor(@PathVariable(value = "colorCode") Integer id){
    Optional<ColorModel> colorModelOptional = colorService.findColor(id);
    if(colorModelOptional.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the color not is possible, because it no exist.");
    }
    return ResponseEntity.status(HttpStatus.FOUND).body(colorModelOptional.get());
}

@PutMapping("/{colorCode}")
public ResponseEntity<Object> updateColor(@PathVariable(value = "colorCode") Integer colorCode,
                                            @RequestBody @Valid ColorRecordDto colorRecordDto){
    Optional<ColorModel> colorModelOptional = colorService.findColor(colorRecordDto.colorCode());
    if(colorModelOptional.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't update this color, her not exist.");
    }
    var colorModelFinal = colorModelOptional.get();
    BeanUtils.copyProperties(colorRecordDto, colorModelFinal);
    return ResponseEntity.status(HttpStatus.OK).body(colorService.saveColor(colorModelFinal));
}

@DeleteMapping("/{colorCode}")
public ResponseEntity<Object> deleteColor(@PathVariable(value = "colorCode") Integer colorCode){
    if (!colorService.existsByColorCode(colorCode)){
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not is possible delete this color, her not found.");
    }
    Optional<ColorModel> colorModel = colorService.findColor(colorCode);
    colorService.deleteColor(colorModel.get());
    return ResponseEntity.status(HttpStatus.OK).body("Color from code " + colorCode + " was delete with success.");
}

}
