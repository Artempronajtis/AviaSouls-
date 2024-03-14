package ru.netology.javaqa.AviaSouls.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AviaSoulsTest {
    @Test
    public void testTicketCompareTo() {
        Ticket ticket1 = new Ticket("A", "B", 100, 800, 1000);
        Ticket ticket2 = new Ticket("C", "D", 200, 1200, 1400);

        assertTrue(ticket1.compareTo(ticket2) < 0);
    }

    @Test
    public void testTicketTimeComparator() {
        TicketTimeComparator comparator = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("A", "B", 100, 800, 1000);
        Ticket ticket2 = new Ticket("C", "D", 200, 1200, 1400);
        Ticket ticket3 = new Ticket("E", "F", 150, 900, 1100);

        assertTrue(comparator.compare(ticket1, ticket2) == 0);
        assertTrue(comparator.compare(ticket1, ticket3) == 0);
        assertTrue(comparator.compare(ticket2, ticket3) == 0);
    }

    @Test
    public void testSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        manager.add(new Ticket("A", "B", 100, 800, 1000));
        manager.add(new Ticket("C", "D", 200, 1200, 1400));
        manager.add(new Ticket("E", "F", 150, 900, 1100));

        Ticket[] expectedAB = {new Ticket("A", "B", 100, 800, 1000)};
        Ticket[] expectedCD = {new Ticket("C", "D", 200, 1200, 1400)};

        Ticket[] resultAB = manager.search("A", "B");
        Ticket[] resultCD = manager.search("C", "D");

        assertArrayEquals(expectedAB, resultAB);
        assertArrayEquals(expectedCD, resultCD);
    }


}
