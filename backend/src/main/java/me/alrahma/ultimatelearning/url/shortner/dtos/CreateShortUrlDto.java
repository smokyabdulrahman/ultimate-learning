package me.alrahma.ultimatelearning.url.shortner.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class CreateShortUrlDto {
    @Setter
    @Getter
    private String url;
}
