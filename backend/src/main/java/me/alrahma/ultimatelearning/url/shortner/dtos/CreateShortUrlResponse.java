package me.alrahma.ultimatelearning.url.shortner.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class CreateShortUrlResponse {

    public CreateShortUrlResponse(String shortUrl) {
        this.shortUrl = String.format("http://localhost:8080/url/%s", shortUrl);
    }

    @Setter
    @Getter
    private String shortUrl;
}
