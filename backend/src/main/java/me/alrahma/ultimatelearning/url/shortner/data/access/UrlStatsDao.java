package me.alrahma.ultimatelearning.url.shortner.data.access;

import me.alrahma.ultimatelearning.url.shortner.models.UrlStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlStatsDao extends JpaRepository<UrlStats, Long> {
}
