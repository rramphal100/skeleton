package healthchecks;

import com.codahale.metrics.health.HealthCheck;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPServerHealthCheck extends HealthCheck {
    private URL url = null;

    public HTTPServerHealthCheck(String url){
        try{ this.url = new URL(url); }
        catch(MalformedURLException e){
            System.err.println("HTTP Server HealthCheck has an invalid host server URL! You MUST manually correct this for valid healthchecks!!");
        }
    }

    @Override
    protected Result check() throws Exception {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        if(responseCode == 200){
            return Result.healthy("HTTP server is working correctly!!!");
        }
        else{
            return Result.unhealthy(new Error("HTTP Server is returning an error: " + Integer.toString(responseCode)));
        }
    }
}