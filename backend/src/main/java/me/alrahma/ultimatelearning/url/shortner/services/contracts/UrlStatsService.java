package me.alrahma.ultimatelearning.url.shortner.services.contracts;

import me.alrahma.ultimatelearning.url.shortner.models.UrlStats;

public interface UrlStatsService {
    UrlStats insertStats(UrlStats urlStats);
}
