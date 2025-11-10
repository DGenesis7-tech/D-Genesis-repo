import data.models.Officer;
import data.models.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfficerTest {
    @Test
    public void officerTestToSetName() {
        Officer officer = new Officer();
        officer.setName("Daniel");
        String officerName = officer.getName();
        assertEquals("Daniel", officerName);
    }

    @Test
    public void officerTestToSetId() {
        Officer officer = new Officer();
        officer.setName("Daniel");
        String officerName = officer.getName();
        assertEquals("Daniel", officerName);

        Rank rank = Rank.PRIVATE;
        officer.setId(rank);
        int id = officer.getId();
        assertEquals(id, officer.getId());
    }

    @Test
    public void officerTestToSetRank() {
        Officer officer = new Officer();
        officer.setName("Daniel");
        Rank rank = Rank.PRIVATE;
        officer.setRank(rank);
        int id = officer.getId();
        assertEquals(id, officer.getId());

        assertEquals(rank, officer.getRank());
    }

    @Test
    public void officerTestHigherRankId() {
        Officer officer = new Officer();
        Rank rank = Rank.CONSTABLE;
        officer.setRank(rank);
        int id = officer.getId();
        assertEquals(id, officer.getId());
        assertEquals(rank, officer.getRank());
    }

}
