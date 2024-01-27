package dev.przetrwaj.przetrwajapi.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/api/v1/demoGet")
    public ResponseEntity<String> demoEndpoint() {
        return ResponseEntity.ok("Response from secured endpoint");
    }

    @PostMapping("/api/v1/demoPost")
    public ResponseEntity<String> demoPost() {
        return ResponseEntity.ok("open POST");
    }
}
