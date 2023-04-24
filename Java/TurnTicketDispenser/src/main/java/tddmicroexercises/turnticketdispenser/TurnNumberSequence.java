package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements NumberSequence
{
    static int _turnNumber = 0;

    public int getNextTurnNumber()
    {
        return _turnNumber++;
    }
}
