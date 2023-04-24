package tddmicroexercises.turnticketdispenser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketDispenserTest {

    @Test
    void twoOrMoreTicketDispensersShouldIncrementTheLastIssuedNumber() {
        TicketDispenser dispenser1 = new TicketDispenser(new TurnNumberSequence());
        TicketDispenser dispenser2 = new TicketDispenser(new TurnNumberSequence());
        TurnTicket ticket1 = dispenser1.getTurnTicket();
        TurnTicket ticket2 = dispenser2.getTurnTicket();
        assertTrue(ticket1.getTurnNumber() < ticket2.getTurnNumber());
    }

}
