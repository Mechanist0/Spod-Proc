package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Helper {

    public static Map<String, Integer> countListens(List<EndSongObject> objList) {
        Map<String, Integer> countMap = new java.util.HashMap<String, Integer>();

        for (EndSongObject obj : objList) {
            if(obj.getMaster_metadata_track_name() != null) {
                if (countMap.containsKey(obj.getMaster_metadata_track_name())) {
                    countMap.put(obj.getMaster_metadata_track_name(), countMap.get(obj.getMaster_metadata_track_name()) + 1);
                } else {
                    countMap.put(obj.getMaster_metadata_track_name(), 1);
                }
            }
        }

        return countMap;
    }

    // From
    // https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
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
            System.exit(2);
            return null;
        }
    }

    //Use generics to write to a file, this will have more use once I implement inheritance
    public static <T> void writeJsonFile(List<T> endArray, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            // clear file
            writer.write("[\n");
            // write new data
            for (int i = 0; i < endArray.size(); i++) {
                T obj = endArray.get(i);
                if (obj.getClass() == EndSongObject.class) {
                    if (endArray.size() - 1 == i) {
                        writer.write(((EndSongObject) obj).toJson() + "\n");
                    } else {
                        writer.write(((EndSongObject) obj).toJson() + ",\n");
                    }
                }
            }
            writer.write("]");
            writer.close();
            System.out.println("File written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param objArray
     * @return Total time listened to array in milliseconds
     */
    public static long getTotalMs(List<EndSongObject> objArray) {
        long timeListenMS = 0;
        for (EndSongObject obj : objArray) timeListenMS += obj.getMs_played();
        return timeListenMS;
    }

    public static List<EndSongObject> censorEndSongObjects(List<EndSongObject> objArray) {
        List<EndSongObject> censoredArray = new ArrayList<EndSongObject>();

        for (EndSongObject obj : objArray) {
            obj.username = "";
            obj.platform = "";
            obj.ms_played = 0;
            obj.conn_country = "";
            obj.ip_addr_decrypted = "";
            obj.user_agent_decrypted = "";
            obj.master_metadata_track_name = "";
            obj.master_metadata_album_artist_name = "";
            obj.master_metadata_album_album_name = "";
            obj.spotify_track_uri = "";
            obj.episode_name = "";
            obj.episode_show_name = "";
            obj.spotify_episode_uri = "";
            obj.reason_start = "";
            obj.reason_end = "";
            obj.shuffle = false;
            obj.skipped = false;
            obj.offline = false;
            obj.offline_timestamp = 0;
            obj.incognito_mode = false;

            censoredArray.add(obj);
        }
        return censoredArray;
    }
}
