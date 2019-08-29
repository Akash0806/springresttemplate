package com.demo.spring.config;

import com.demo.spring.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityClientImpl implements CityClient {

    final String ROOT_URI = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";
    @Autowired
    RestTemplate restTemplate;

    public City getAllCity() {
        ResponseEntity<City> response = restTemplate.getForEntity(ROOT_URI, City.class);
        return (City) response.getBody();

    }


}
