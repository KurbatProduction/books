package com.test.books.service.producer;

import com.test.books.dto.BookDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.books-create}")
    public String topicBooksCreate;

    public void sendBookData(BookDataDto.Request message) {
        log.info("Preparing to send message={} to topic \"{}\"", message, topicBooksCreate);
        String key = UUID.randomUUID().toString();
        kafkaTemplate.send(topicBooksCreate, key, message);
        log.info(
                "Message={} with key={} has been sent to kafka topic \"{}\"",
                message,
                key,
                topicBooksCreate);
    }
}
