package main;
/**
 * Hello world!
 *
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpodProc 
{
    public static void main( String[] args )
    {
        String fileName = "spodproc/resources/endsongobjtest.json";
        JsonArray masterArray = readJsonFile(fileName);

        for (JsonElement jsonElement : masterArray) {
            System.out.println(jsonElement.getAsJsonObject());
            EndSongObject endSongObject = new EndSongObject(jsonElement.getAsJsonObject());
            System.out.println(endSongObject.toString());
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
        }

        return null;
    }
}
