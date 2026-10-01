package mx.com.company.demo2.backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        String uri = "mongodb+srv://sultan2793_db_user:occ53STpt9TBNSlx@cluster0.hyvnh4z.mongodb.net/demo?appName=Cluster0";

        return MongoClients.create(uri);
    }
}