package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.EndSongObject;

public class SpodProcTest {
    @Test
    public void test() {
        assertEquals(true, true);
    }

    @Test
    public void enumTest() {
        String startReason = "backbtn";
        EndSongObject.StartReason startReasonEnum = EndSongObject.StartReason.valueOf(startReason);
        assertTrue(EndSongObject.StartReason.backbtn == startReasonEnum);
    }

    @Test
    public void enumTestWeird() {
        EndSongObject testObject = new EndSongObject();
        testObject.setReason_end("unexpected-exit-while-paused");
        EndSongObject.EndReason endReason = testObject.getReason_end();
        assertTrue(EndSongObject.EndReason.unexpectedexitwhilepaused == endReason);
    }
}