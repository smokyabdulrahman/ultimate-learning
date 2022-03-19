package me.alrahma.ultimatelearning.url.shortner.services.contracts;

import me.alrahma.ultimatelearning.url.shortner.dtos.CreateShortUrlResponse;
import me.alrahma.ultimatelearning.url.shortner.models.Url;

public interface UrlService {

    String getUrlBySlug(String slug);
    Url createShortUrl(String url);
    Url updateNumberOfVisits(Url url);
}
