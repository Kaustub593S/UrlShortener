package com.example.urlshort;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    public UrlService(UrlRepository urlRepository)
    {
        this.urlRepository=urlRepository;
    }
    private String shortCodeGenerator()
    {
        String shortCode= UUID.randomUUID().toString().substring(0,6);
        return shortCode;
    }
    public String createShortUrl(String originalUrl, User user)
    {
        String shortCode = shortCodeGenerator();
        UrlInfo urlInfo = new UrlInfo();
        urlInfo.setShortCode(shortCode);
        urlInfo.setOriginalurl(originalUrl);
        urlInfo.setUser(user);

        urlRepository.save(urlInfo);

        return shortCode;

    }
    public String getOriginalUrl(String shortCode)
    {
        UrlInfo urlInfo = urlRepository
                .findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));

        return urlInfo.getOriginalurl();
    }
}
