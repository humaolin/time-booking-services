package com.fantasy.tbs.web.rest;

import com.fantasy.tbs.domain.TimeBookDTO;
import com.fantasy.tbs.domain.TimeWorkDTO;
import com.fantasy.tbs.service.impl.TimeBookingServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.time.ZonedDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TimeBookingController {

    private final TimeBookingServiceImpl timeBookingService;
    @Value("${jhipster.clientApp.name}")
    private String applicationName;
    private static final String ENTITY_NAME = "timeBookingServiceTimeBooking";

    public TimeBookingController(TimeBookingServiceImpl timeBookingService) {
        this.timeBookingService = timeBookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<Void> addTimeBooking(@RequestBody TimeBookDTO timeBookDTO) {
        timeBookingService.bookTime(timeBookDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/calc/{personalNumber}")
    public ResponseEntity<TimeWorkDTO> calc(@PathVariable("personalNumber") String personalNumber, ZonedDateTime start, ZonedDateTime end) {
        //calculate work hours between start and end, I do not know the calculation rule, so i calculate the period between min and max booking time in this period
        Optional<TimeWorkDTO> result = timeBookingService.calc(personalNumber, start, end);
        return
            ResponseUtil.wrapOrNotFound(
                result,
                HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, personalNumber)
            );
    }
}
