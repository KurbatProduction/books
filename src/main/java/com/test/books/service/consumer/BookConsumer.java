package com.test.books.service.consumer;

import com.test.books.dto.BookDataDto;
import com.test.books.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@KafkaListener(topics = "${topic.books-create}")
public class BookConsumer {

    private final BookService bookService;

    @KafkaHandler
    public void onMessage(
            BookDataDto.Request message, ConsumerRecord<String, BookDataDto.Request> cr) {
        log.info(
                "Received message from {}, offset: {}, partition: {}, key: {}. Creating Book.",
                cr.topic(),
                cr.offset(),
                cr.partition(),
                cr.key());
        bookService.createBook(message);
        log.info("The book \"{}\" was created using Kafka", message.title());
    }
}
