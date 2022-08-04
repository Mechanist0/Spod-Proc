package main;

import java.util.Comparator;
import java.util.List;

public class SpodProc {
    public static void main(String[] args) {
        List<EndSongObject> endSongObjectArray = Helper
                .fileToEndSongObjectArray("spodproc/src/resources/endsong_0.json");
        System.out.println(endSongObjectArray);
    }
}

// Compares two EndSongObjects by their timestamps
class TimeStampComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return o1.getTs().compareTo(o2.getTs());
    }
}

// Compares two EndSongObjects by their platform
class PlatformComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return Comparator.comparing(EndSongObject::getPlatform).thenComparing(EndSongObject::getTs).compare(o1, o2);
    }
}
