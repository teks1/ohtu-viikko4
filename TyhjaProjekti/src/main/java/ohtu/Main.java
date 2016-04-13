package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014438341";
        if (args.length > 0) {
            studentNr = args[0];
        }
        String url = "http://ohtustats2016.herokuapp.com/students/" + studentNr + "/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream = method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

//        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

//        System.out.println("Oliot:");
        int tehtavatYhteensa = 0;
        int aikaYhteensa = 0;
        System.out.println("opiskelijanumero " + studentNr + "\n");
        for (Submission sub : subs) {
            aikaYhteensa += sub.getHours();
            tehtavatYhteensa += sub.getTotalExercises();
            System.out.println(sub);
        }

        System.out.println("\nyhteensä: " + tehtavatYhteensa + " tehtävää " + aikaYhteensa + " tuntia");

        
        String lol = "";
        System.out.println(lol);
    }
}
