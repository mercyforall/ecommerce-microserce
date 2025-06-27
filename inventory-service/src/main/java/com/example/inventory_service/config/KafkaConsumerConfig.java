package com.example.inventory_service.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String,Object> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");  // Adjust the bootstrap server address as needed
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "inventory_group");  // Set a unique group ID for the consumer
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // Use StringDeserializer for the key
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class); // Use JsonDeserializer for the value
        return new DefaultKafkaConsumerFactory<>(config);  // Create a DefaultKafkaConsumerFactory with the provided configuration
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() { 
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory()); // Set the consumer factory for the listener container
        factory.setConcurrency(3); // Set the number of concurrent consumers
        factory.getContainerProperties().setPollTimeout(3000);  // Set the poll timeout
        return factory;  // Return the configured Kafka listener container factory
    }

}
