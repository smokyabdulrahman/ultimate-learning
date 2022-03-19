package me.alrahma.ultimatelearning.url.shortner.controllers;

import me.alrahma.ultimatelearning.url.shortner.dtos.CreateShortUrlDto;
import me.alrahma.ultimatelearning.url.shortner.dtos.CreateShortUrlResponse;
import me.alrahma.ultimatelearning.url.shortner.services.contracts.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("url")
public class UrlShortnerController {

    private final UrlService urlService;

    public UrlShortnerController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("{slug}")
    public RedirectView getFullUrl(@PathVariable String slug) {
        var result = urlService.getUrlBySlug(slug);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(result);
        return redirectView;
    }

    @PostMapping()
    public ResponseEntity<CreateShortUrlResponse> createShortUrl(@RequestBody CreateShortUrlDto createShortUrlDto) {
        var result = urlService.createShortUrl(createShortUrlDto.getUrl());

        return new ResponseEntity<>(new CreateShortUrlResponse(result.getSlug()), HttpStatus.OK);
    }
}
