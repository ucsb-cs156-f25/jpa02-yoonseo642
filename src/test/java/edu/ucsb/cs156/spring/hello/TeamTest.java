package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        assert(t1.equals(t1)); 
    }

    @Test
    public void equals_differentClass_returnsFalse() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        String notATeam = "Not a team";
        assert(!t1.equals(notATeam));
    }

    @Test
    public void equals_sameNameAndMembers_returnsTrue() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assert(t1.equals(t2));
    }


    @Test
    public void equals_sameNameDifferentMembers_returnsFalse() {
        Team t1 = new Team();
        t1.addMember("x");
        Team t2 = new Team();
        t2.addMember("y");
        assert(!t1.equals(t2));
    }

    @Test
    public void equals_differentNameSameMembers_returnsFalse() {
        Team t1 = new Team();
        t1.setName("A");
        t1.addMember("x");
        Team t2 = new Team();
        t2.setName("B");
        t2.addMember("x");
        assert(!t1.equals(t2));
    }


    // instantiate t as a Team object
    @Test
    public void hashCode_returns_expected_value() {
        int result = team.hashCode();
        int expectedResult = 0;
        assertEquals(-1226298695, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
