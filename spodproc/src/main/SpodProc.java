package main;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SpodProc {
    public static void main(String[] args) {
        String fileName = "spodproc/src/resources/endsong_0.json";
        JsonArray masterArray = Helper.readJsonFile(fileName);
        List<EndSongObject> endSongObjectArray = new ArrayList<EndSongObject>();

        //Converte the JsonArray to a list of EndSongObjects
        for (JsonElement jsonElement : masterArray) {
            EndSongObject endSongObject = new EndSongObject(jsonElement.getAsJsonObject());
            endSongObjectArray.add(endSongObject);
        }

        Collections.sort(endSongObjectArray, new PlatformComparator());
        Helper.writeJsonFile(endSongObjectArray, "spodproc/src/resources/endsong_1.json");
        Map<String, Integer> countMap = Helper.countListens(endSongObjectArray);

        List<Map.Entry<String, Integer>> countList = new LinkedList<Map.Entry<String, Integer>>(countMap.entrySet());
        Collections.sort(countList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (int i = countList.size()-1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = countList.get(i);
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }  
}

//Compares two EndSongObjects by their timestamps
class TimeStampComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return o1.getTs().compareTo(o2.getTs());
    }
}

//Compares two EndSongObjects by their platform
class PlatformComparator implements Comparator<EndSongObject> {
    @Override
    public int compare(EndSongObject o1, EndSongObject o2) {
        return Comparator.comparing(EndSongObject::getPlatform).thenComparing(EndSongObject::getTs).compare(o1, o2);
    }
}
