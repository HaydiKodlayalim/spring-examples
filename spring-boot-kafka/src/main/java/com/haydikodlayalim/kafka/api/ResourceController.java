package com.haydikodlayalim.kafka.api;

import com.haydikodlayalim.kafka.dto.KMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kmessage")
public class ResourceController {

    private static final String topic = "my-first-topic";

    @Autowired
    private KafkaTemplate<String, KMessage> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody KMessage kMessage) {
        kafkaTemplate.send(topic, kMessage);
    }
}
