import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Violation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {


        BufferedReader br = new BufferedReader(new FileReader("src/main/java/jsonFile.json"));


        Type collectionType = new TypeToken<List<Violation>>() {}.getType();
        List<Violation> lcs = new Gson().fromJson(br, collectionType);
        String out;
        for (Violation lc : lcs)
            for (int j = 0; j < lc.getNodes().size(); j++)
                for (int k = 0; k < lc.getNodes().get(j).getAny().size(); k++)
                    for (int l = 0; l < lc.getNodes().get(j).getAny().get(k).getRelatedNodes().size(); l++) {
                        out = lc.getNodes().get(j).getAny().get(k).getRelatedNodes().get(l).getHtml();
                        System.out.println(out);
                    }
    }
}
