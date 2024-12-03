package org.com.gridnine.testing;

import java.util.List;

public class FlightFilterDemo {
    public static void main(String[] args) {

        // Получение тестовых перелетов
        List<Flight> flights = FlightsBuilder.createFlights();

        // Правило: Вылет до текущего момента времени
        FlightsFilter filter1 = new FlightsFilter();
        filter1.addRule(new DepartureRule());
        List<Flight> filteredFlights1 = filter1.filter(flights);
        System.out.println("Рейсы после применения правила: Вылет после настоящего времени: " + filteredFlights1.size());
        filteredFlights1.forEach(System.out::println);

        // Правило: Сегменты с датой прилета раньше даты вылета
        FlightsFilter filter2 = new FlightsFilter();
        filter2.addRule(new ArrivalRole());
        List<Flight> filteredFlights2 = filter2.filter(flights);
        System.out.println("Рейсы после применения правила: Прибытие после вылета: " + filteredFlights2.size());
        filteredFlights2.forEach(System.out::println);

        // Правило: Общее время на земле превышает два часа
        FlightsFilter filter3 = new FlightsFilter();
        filter3.addRule(new GroundRule());
        List<Flight> filteredFlights3 = filter3.filter(flights);
        System.out.println("Рейсы после применения правила: Наземного времени: " + filteredFlights3.size());
        filteredFlights3.forEach(System.out::println);
    }
}