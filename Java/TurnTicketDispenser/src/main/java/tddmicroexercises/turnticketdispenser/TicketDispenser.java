package tddmicroexercises.turnticketdispenser;

/*
    DIP: Dependency Inversion Principle violated fix,
    the TicketDispenser was dependent of specific implementation of sequence, should be dependent of Abstraction
*/
public class TicketDispenser
{
    private final NumberSequence numberSequence;

    public TicketDispenser(NumberSequence numberSequence) {
        this.numberSequence = numberSequence;
    }

    public NumberSequence getNumberSequence() {
        return numberSequence;
    }

    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = getNumberSequence().getNextTurnNumber();
        return new TurnTicket(newTurnNumber);
    }
}
