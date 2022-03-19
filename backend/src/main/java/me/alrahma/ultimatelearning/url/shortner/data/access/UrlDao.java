package me.alrahma.ultimatelearning.url.shortner.data.access;

import me.alrahma.ultimatelearning.url.shortner.models.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlDao extends JpaRepository<Url, Long> {

    Url getUrlBySlug(String slug);
    Url findByFullUrl(String fullUrl);
}
