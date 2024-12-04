package org.com.gridnine.testing;

public class ArrivalRole implements FilterRule {

    @Override
    public boolean ruleApply(Flight flight) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                return false;
            }
        }
        return true;
    }
}
