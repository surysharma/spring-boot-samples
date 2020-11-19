package com.thebigscale.controller;

import com.google.common.flogger.FluentLogger;
import com.thebigscale.dto.ClientProfile;
import lombok.NonNull;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class ClientProfileController {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    @GetMapping("/clients")
    @ResponseBody
    public ResponseEntity<?> getClients(@RequestParam(name = "pc", defaultValue = "1") String pageCount) {

        logger.atInfo().log("Page count is " + pageCount);

        val clientProfile = new ClientProfile(new Random(1).nextLong(), "sury", "22",
                "Test profile summary",
                "some@email.com"
                );
        return new ResponseEntity<>(clientProfile, HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    @ResponseBody
    public ResponseEntity<?> getClient(@PathVariable String id) {
        val clientProfile = new ClientProfile(Integer.parseInt(id), "sury", "22",
                "Test profile summary", "some@email.com");
        return new ResponseEntity<>(clientProfile, HttpStatus.OK);
    }

    @PostMapping(value = "/client", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClientProfile> addClient(@Valid @RequestBody ClientProfile clientProfile) {
//        ClientProfile clientProfile = requestEntity.getBody();
        assert clientProfile != null;
        val clientProfileWithId = new ClientProfile(Math.abs(new Random(1).nextLong()), clientProfile.getName(),
                clientProfile.getAge(), clientProfile.getProfileSummary(), clientProfile.getEmail());
        return new ResponseEntity<>(clientProfileWithId, HttpStatus.ACCEPTED);
    }

}
