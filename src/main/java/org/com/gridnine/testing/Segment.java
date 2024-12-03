package org.com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {

    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        departureTime = Objects.requireNonNull(dep);
        arrivalTime = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepartureDate() {
        return departureTime;
    }

    LocalDateTime getArrivalDate() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + departureTime.format(fmt) + '|' + arrivalTime.format(fmt) + ']';
    }
}
