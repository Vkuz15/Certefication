package org.com.gridnine.testing;

import java.util.List;

public class GroundRule implements FilterRule {

    private static final int MAX_GROUND_TIME_MINUTES = 120; // 2 часа

    @Override
    public boolean ruleApply(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            Segment current = segments.get(i);
            Segment next = segments.get(i + 1);
            long groundTime = java.time.Duration.between(current.getArrivalDate(), next.getDepartureDate()).toMinutes();
            if (groundTime > MAX_GROUND_TIME_MINUTES) {
                return false;
            }
        }
        return true;
    }
}
