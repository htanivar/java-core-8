package sin.java.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class HttpClientTest {
    @Test
    public void getHttpClient_reponseBody_by_HttpEntity_test() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/comments?postId=1");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String responseString = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseString);
    }

    @Test
    public void getHttpClient_reponseBody_by_responseHandler() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/comments?postId=1");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String responseString = new BasicResponseHandler().handleResponse(response);
        System.out.println(responseString);
    }

}
