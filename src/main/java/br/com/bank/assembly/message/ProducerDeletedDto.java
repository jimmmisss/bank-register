package br.com.bank.assembly.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProducerDeletedDto {

    private String origin;
    private String method;

    private Long id;

    private LocalDateTime instant = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
}