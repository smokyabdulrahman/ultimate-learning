package me.alrahma.ultimatelearning.url.shortner.services.implementations;

import me.alrahma.ultimatelearning.url.shortner.data.access.UrlDao;
import me.alrahma.ultimatelearning.url.shortner.data.access.UrlStatsDao;
import me.alrahma.ultimatelearning.url.shortner.dtos.GetUrlDto;
import me.alrahma.ultimatelearning.url.shortner.exceptions.ResourceNotFoundException;
import me.alrahma.ultimatelearning.url.shortner.models.Url;
import me.alrahma.ultimatelearning.url.shortner.models.UrlStats;
import me.alrahma.ultimatelearning.url.shortner.services.contracts.UrlService;
import me.alrahma.ultimatelearning.url.shortner.services.contracts.UrlStatsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    private final UrlDao urlDao;
    private final UrlStatsService urlStatsService;

    public UrlServiceImpl(UrlDao urlDao, UrlStatsService urlStatsService) {
        this.urlDao = urlDao;
        this.urlStatsService = urlStatsService;
    }

    @Override
    @Transactional
    public String getUrlBySlug(GetUrlDto getUrlDto) {
        var result = urlDao.getUrlBySlug(getUrlDto.getSlug());
        if (result == null) {
            throw new ResourceNotFoundException(String.format("Url with key: %s is not found.", getUrlDto));
        }

        updateNumberOfVisits(result);

        var urlStats = new UrlStats();
        urlStats.setUrl(result);
        urlStats.setDeviceType(getUrlDto.getDeviceType());
        urlStatsService.insertStats(urlStats);

        return result.getFullUrl();
    }



    @Override
    public Url createShortUrl(String url) {
        // Check if full url already exists
        var result = urlDao.findByFullUrl(url);
        if (result != null) {
            return result;
        }

        var newUrl = new Url();
        newUrl.setFullUrl(url);
        var uuid = UUID.randomUUID().toString();
        newUrl.setSlug(uuid.substring(0, uuid.indexOf('-')));
        newUrl.setNumberOfVisits(0);
        result = urlDao.save(newUrl);

        return result;
    }

    @Override
    public Url updateNumberOfVisits(Url url) {
        if (url == null) {
            throw new NullPointerException("Url is null");
        }

        url.setNumberOfVisits(url.getNumberOfVisits() + 1);
        url = urlDao.save(url);

        return url;
    }
}
