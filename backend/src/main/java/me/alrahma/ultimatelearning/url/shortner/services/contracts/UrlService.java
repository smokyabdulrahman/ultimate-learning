package me.alrahma.ultimatelearning.url.shortner.services.contracts;

import me.alrahma.ultimatelearning.url.shortner.dtos.GetUrlDto;
import me.alrahma.ultimatelearning.url.shortner.models.Url;

public interface UrlService {

    String getUrlBySlug(GetUrlDto getUrlDto);
    Url createShortUrl(String url);
    Url updateNumberOfVisits(Url url);
}
