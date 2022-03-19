package me.alrahma.ultimatelearning.url.shortner.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class GetUrlDto {
    @Getter
    private String slug;
    @Getter
    private String deviceType;
}
