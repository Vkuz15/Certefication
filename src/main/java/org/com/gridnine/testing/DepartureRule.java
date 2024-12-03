package org.com.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureRule implements FilterRule {

    @Override
    public boolean ruleApply(Flight flight) {
        LocalDateTime now = LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(now)) {
                return false;
            }
        }
        return true;
    }
}
