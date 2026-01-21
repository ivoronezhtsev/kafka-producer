package ru.voronezhtsev.kafka_producer;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final KafkaProducerService kafkaProducerService;

    public ProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @Operation(summary = "Отправить сообщение в топик")
    @PostMapping("produce")
    public void produce(@RequestBody KafkaMessage kafkaMessage) {
        kafkaProducerService.produceMessage(kafkaMessage);
    }
}
