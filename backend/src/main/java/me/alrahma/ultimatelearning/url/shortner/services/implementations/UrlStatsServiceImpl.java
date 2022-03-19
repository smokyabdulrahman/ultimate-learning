package me.alrahma.ultimatelearning.url.shortner.services.implementations;

import me.alrahma.ultimatelearning.url.shortner.data.access.UrlStatsDao;
import me.alrahma.ultimatelearning.url.shortner.models.UrlStats;
import me.alrahma.ultimatelearning.url.shortner.services.contracts.UrlStatsService;
import org.springframework.stereotype.Service;

@Service
public class UrlStatsServiceImpl implements UrlStatsService {

    private final UrlStatsDao urlStatsDao;

    public UrlStatsServiceImpl(UrlStatsDao urlStatsDao) {
        this.urlStatsDao = urlStatsDao;
    }

    @Override
    public UrlStats insertStats(UrlStats urlStats) {
        return urlStatsDao.save(urlStats);
    }
}
