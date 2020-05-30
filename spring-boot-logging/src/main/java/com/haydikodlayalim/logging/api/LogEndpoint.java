package com.haydikodlayalim.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping
    public String getDetails() {
        log.info("get details methodu basladi");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try {
            log.debug("internalLogDetail methodu basladi");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            log.error("Hata : {}", e);
        }
        return "";
    }

    /*
    - Loglama Asenkron olmalidir
    - printStackTrace ve System.out.println() kullanilmamalidir (format)
    - Sensitive data olmamalidir
    - Tum loglar merkezi toplanmalidir, belli formatta
    - Level dikkatli kullanilmalidir
    - Farkli levellar farkli appendarlar kullanilabilir
     */
}
