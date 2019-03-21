package com.example.mongorepo.optionalfails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;

import java.util.Optional;

@Data
@AllArgsConstructor
@Builder
public class TestDataWithOptional {
    private String id;
    private Optional<String> optionalString;
}
