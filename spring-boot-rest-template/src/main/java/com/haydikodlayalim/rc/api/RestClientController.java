package com.haydikodlayalim.rc.api;

import com.haydikodlayalim.rc.model.KisiDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8081/kisi";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<KisiDto>> getKisiList(){
        ResponseEntity<List> result = restTemplate.getForEntity(webUrl, List.class);
        List<KisiDto> responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto){
        ResponseEntity<KisiDto> result = restTemplate.postForEntity(webUrl, kisiDto, KisiDto.class);
        KisiDto responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }
}
