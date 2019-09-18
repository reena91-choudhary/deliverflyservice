package com.tottacoder.deliverfly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

import com.tottacoder.deliverfly.entities.Pigeon;
import com.tottacoder.deliverfly.repositories.PigeonRepository;


@SpringBootApplication
public class DeliveryFlyService 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(DeliveryFlyService.class, args);
    }
    @Bean
    CommandLineRunner init(final PigeonRepository pigeonRepository) {
        return args -> {
            Stream.of("Jack", "Andy", "Jill", "Wenty", "Hill").forEach(name -> {
            	Pigeon pigeon = new Pigeon(name);
            	pigeonRepository.save(pigeon);
            });
        };
    }
}
