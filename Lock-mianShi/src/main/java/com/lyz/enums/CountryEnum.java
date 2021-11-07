package com.lyz.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CountryEnum {
    ONE(1,"齐国"),
    TWO(2,"楚国"),
    THREE(3,"燕国"),
    FOUR(4,"赵国"),
    FIVE(5,"魏国"),
    SIX(6,"韩国"),
    UNKNOWN(99,"未知错误");

    private Integer retCode;
    private String retMessage;

     CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static  CountryEnum forEach(Integer i){
        CountryEnum[] countryEnums =  CountryEnum.values();
        CountryEnum countryEnum = Arrays.asList(countryEnums).stream().filter(c->c.retCode==i).
                findFirst().orElse(CountryEnum.UNKNOWN);
        return countryEnum;
    }

}
