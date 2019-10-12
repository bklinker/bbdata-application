package com.bbdata.server.web.rest;

import com.bbdata.server.service.BbdataKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bbdata-kafka")
public class BbdataKafkaResource {

    private final Logger log = LoggerFactory.getLogger(BbdataKafkaResource.class);

    private BbdataKafkaProducer kafkaProducer;

    public BbdataKafkaResource(BbdataKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
