package com.fantasy.tbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode
public class TimeWorkDTO {
    private ZonedDateTime timeStamp;
    private String personalNumber;
    private double workHours;
}
