package org.com.gridnine.testing;

import java.util.List;

public class TotalGroundTimeRule implements FilterRule {

    private static final int MAX_GROUND_TIME_MINUTES = 120; // 2 часа

    @Override
    public boolean ruleApply(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalGroundTime = 0;

        for (int i = 0; i < segments.size() - 1; i++) {
            Segment current = segments.get(i);
            Segment next = segments.get(i + 1);
            long groundTime = java.time.Duration.between(current.getArrivalDate(), next.getDepartureDate()).toMinutes();
            totalGroundTime += groundTime; // Суммируем общее время на земле
        }

        return totalGroundTime > MAX_GROUND_TIME_MINUTES; // Сравниваем с лимитом, должен быть больше 2 часов
    }
}
