package net.monsterdev.moysklad.services.Impl;

import net.monsterdev.moysklad.model.Product;
import net.monsterdev.moysklad.services.MoyskladService;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("moyskladService")
public class MoyskladServiceImpl implements MoyskladService {
    private static final String BASE_URL = "https://online.moysklad.ru/api/remap/1.1";
    private static final String PRODUCTS_LIST_URL = BASE_URL + "/entity/product";

    // Http client
    private HttpClient client = null;

    private void createClient(String login, String password) {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(login, password);
        provider.setCredentials(AuthScope.ANY, credentials);
        client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
    }

    @Override
    public void connect(String login, String password) {
        if (client == null)
            createClient(login, password);
    }

    @Override
    public List<Product> getProducts() {
        try {
            HttpResponse response = client.execute(new HttpPost(PRODUCTS_LIST_URL));
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
                throw new HttpException("Failed to get products");
            JSONObject json = new JSONObject(EntityUtils.toString(response.getEntity()));
            // TODO: Разбор ответа сервера
            List<Product> result = new ArrayList<>();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
