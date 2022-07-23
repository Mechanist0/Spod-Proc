package main;

/**
 * Hello world!
 *
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SpodProc {
    public static void main(String[] args) {
        String fileName = "spodproc/src/resources/endsong_0.json";
        JsonArray masterArray = readJsonFile(fileName);
        List<EndSongObject> endSongObjectArray = new ArrayList<EndSongObject>();

        int amount = 0;
        String songName = "";

        for (JsonElement jsonElement : masterArray) {
            EndSongObject endSongObject = new EndSongObject(jsonElement.getAsJsonObject());
            endSongObjectArray.add(endSongObject);
            if (endSongObject.getMaster_metadata_track_name() != null)
                if (endSongObject.getMaster_metadata_track_name().equals(songName))
                    amount++;
        }

        System.out.println("You listened to " + songName + " " + amount + " times.");

        Collections.sort(endSongObjectArray, new MyComparator());

        for (int i = 0; i < 5; i++) {
            EndSongObject obj = endSongObjectArray.get(i);
            System.out.println(obj.getTs() + " " + obj.getMaster_metadata_track_name());
        }

    }

    /**
     * @param fileName
     * @return a JsonArray of the file
     **/
    public static JsonArray readJsonFile(String fileName) {
        JsonArray jsonArray = new JsonArray();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            StringBuilder sb = new StringBuilder();

            while (myReader.hasNextLine()) {
                sb.append(myReader.nextLine());
            }

            Gson gson = new Gson();
            JsonArray outerArray = gson.fromJson(sb.toString(), JsonArray.class);

            for (JsonElement jsonElement : outerArray) {
                jsonArray.add(jsonElement.getAsJsonObject());
            }

            myReader.close();
            return jsonArray;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

class MyComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return o1.getTs().compareTo(o2.getTs());
    }
}
