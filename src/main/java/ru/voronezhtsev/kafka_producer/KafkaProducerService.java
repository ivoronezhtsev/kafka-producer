package ru.voronezhtsev.kafka_producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceMessage(KafkaMessage kafkaMessage) {
        kafkaTemplate.send("my-first-topic", 0, kafkaMessage.key(), kafkaMessage.value());
        System.out.println("Produced " + kafkaMessage);
    }
}
