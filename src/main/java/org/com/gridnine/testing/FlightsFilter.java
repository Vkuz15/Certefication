package org.com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightsFilter {

    private final List<FilterRule> rules;

    public FlightsFilter() {
        this.rules = new ArrayList<>();
    }

    public void addRule(FilterRule rule) {
        rules.add(rule);
    }

    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            boolean isValid = true;
            for (FilterRule rule : rules) {
                if (!rule.ruleApply(flight)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
