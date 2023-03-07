package com.mmaliga.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WeightClass {
    
	LEVE(0, "Leves"), MEIO_MEDIO(1, "Meio-Médios"), MEDIO(2, "Médios"),
    MEIO_PESADO(3, "Meio-Pesados"), PESADO(4, "Pesados"), CASADO(5, "Casada");

    private Integer code;
    private String name;

	public static WeightClass toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (WeightClass x : WeightClass.values()) {
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Categoria invalida!");
    }
}
	

