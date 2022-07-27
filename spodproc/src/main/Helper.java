package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class Helper {

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
}
