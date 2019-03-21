package com.example.mongorepo.optionalfails;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class TestController {

    final TestDataWithOptionalRepository withOptionalRepository;

    @PostMapping(value = "/dataWithOptional/{text}")
    public String saveString(@PathVariable(value = "text") String text) {
        TestDataWithOptional result = withOptionalRepository.save(TestDataWithOptional.builder()
                .optionalString(Optional.ofNullable(text))
                .build());
        return String.valueOf(result.getId());
    }

    @GetMapping(value = "/dataWithOptional")
    public String getAllWithOptional() {
        StringBuffer sb = new StringBuffer();
        for (TestDataWithOptional td : withOptionalRepository.findAll()) {
            sb.append(td.toString());
        }
        return sb.toString();
    }
}

