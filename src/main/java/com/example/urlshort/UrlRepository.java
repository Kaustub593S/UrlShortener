package com.example.urlshort;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<UrlInfo, Long> {

    Optional<UrlInfo> findByShortCode(String shortCode);
}
