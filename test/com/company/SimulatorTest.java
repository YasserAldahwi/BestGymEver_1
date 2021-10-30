package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    @Test
    void getMemberIfExist() throws IOException {
        List<String> lines = getTestLines();

        //Correct personal number
        ClubMember memberIfExist = Simulator.getMemberIfExist("7603021234", lines);
        assertEquals(new ClubMember("7603021234", "Alhambra Aromes", LocalDate.parse("2021-07-01")).toString(), memberIfExist.toString());

        //none exist p number
        memberIfExist = Simulator.getMemberIfExist("7615437777", lines);
        assertNull(memberIfExist);

        //Expired membership
        memberIfExist = Simulator.getMemberIfExist("8104021234", lines);
        assertNull(memberIfExist);
    }

    private List<String> getTestLines() {
        return List.of(
                "7603021234, Alhambra Aromes",
                "2021-07-01",
                "8104021234, Bear Belle",
                "2018-12-02"
        );
    }
}