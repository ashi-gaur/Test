package com.ashi.bajaj.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ashi.bajaj.Model.RequestData;
import com.ashi.bajaj.Model.ResponseData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @GetMapping
    public ResponseEntity<?> getOperationCode() {
        return ResponseEntity.ok().body("{ \"operation_code\": 1 }");
    }

    @PostMapping
    public ResponseData processData(@RequestBody RequestData requestData) {
        List<String> data = requestData.getData();

        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> highestLowercaseAlphabet = new ArrayList<>();

        for (String item : data) {
            if (item.matches("[0-9]+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]")) {
                    highestLowercaseAlphabet.add(item);
                }
            }
        }

        String highestLowercase = highestLowercaseAlphabet.stream()
                .max(Comparator.naturalOrder())
                .orElse("");

        ResponseData response = new ResponseData();
        response.setSuccess(true);
        response.setUserId("ashi_singh_gaur_12072004");
        response.setEmail("ashi.singh2021@vitbhopal.ac.in");
        response.setRollNumber("21BHI10075");
        response.setNumbers(numbers);
        response.setAlphabets(alphabets);
        response.setHighestLowercaseAlphabet(highestLowercase.isEmpty() ? new ArrayList<>() : List.of(highestLowercase));

        return response;
    }
}
