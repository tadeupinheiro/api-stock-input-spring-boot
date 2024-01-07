package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "TB_COLOR")
public class ColorModel {

    @Id
    private UUID colorCode;
    @Nullable
    private String colorName;

    public UUID getColorCode() {
        return colorCode;
    }

    public void setColorCode(UUID colorCode) {
        this.colorCode = colorCode;
    }

    @Nullable
    public String getColorName() {
        return colorName;
    }

    public void setColorName(@Nullable String colorName) {
        this.colorName = colorName;
    }
}
