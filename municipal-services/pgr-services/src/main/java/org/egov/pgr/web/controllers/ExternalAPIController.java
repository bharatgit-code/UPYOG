package org.egov.pgr.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/external")
@Slf4j
public class ExternalAPIController {
    private static final Logger LOG = LogManager.getLogger(ExternalAPIController.class);
    @Value("${api.security.grievance.static-bearer-token}")
    private String grievanceExpectedToken;

    @PostMapping("/grievance/_status")
    public ResponseEntity<String> getSecureData(@RequestHeader(value = "Authorization") String authorizationHeader) {
        LOG.info("Process Start: Received street light grievance status from third party");
        StopWatch watcher = StopWatch.createStarted();
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing or invalid Authorization header");
        }

        String actualToken = authorizationHeader.substring(7); // Remove "Bearer " prefix

        if (!grievanceExpectedToken.equals(actualToken)) {
            // Log failed attempt if needed
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid token");
        }
        // Token is valid, proceed with business logic
        String response = "valid response";
        LOG.info("Process End: Consumed street light grievance status from third party, execution time in MS: {}", watcher.getTime());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
