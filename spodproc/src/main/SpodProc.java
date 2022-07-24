package main;

/**
 * Hello world!
 *
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SpodProc {
    public static void main(String[] args) {
        String fileName = "spodproc/src/resources/endsong_0.json";
        JsonArray masterArray = Helper.readJsonFile(fileName);
        List<EndSongObject> endSongObjectArray = new ArrayList<EndSongObject>();
        ArrayList<String> startreason = new ArrayList<String>();

        int amount = 0;
        String songName = "";

        for (JsonElement jsonElement : masterArray) {
            EndSongObject endSongObject = new EndSongObject(jsonElement.getAsJsonObject());
            startreason.add(endSongObject.getReason_end());
            endSongObjectArray.add(endSongObject);
            if (endSongObject.getMaster_metadata_track_name() != null)
                if (endSongObject.getMaster_metadata_track_name().equals(songName))
                    amount++;
        }

        startreason = Helper.removeDuplicates(startreason);
        System.out.println("You listened to " + songName + " " + amount + " times.");
        System.out.println(startreason);

        Collections.sort(endSongObjectArray, new MyComparator());

        for (int i = 0; i < 5; i++) {
            EndSongObject obj = endSongObjectArray.get(i);
            System.out.println(obj.getTs() + " " + obj.getMaster_metadata_track_name());
        }

    }  
}

class MyComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return o1.getTs().compareTo(o2.getTs());
    }
}
