package com.es.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class ESJdbcTest {

    static String  driver = "org.elasticsearch.xpack.sql.jdbc.jdbc.JdbcDriver";
    static String elasticsearchAddress = "192.168.25.150:9200";

    public static Properties connectionProperties(){
        Properties properties = new Properties();
//        properties.put("user", "test_admin");
//        properties.put("password", "x-pack-test-password");
        return properties;
    }

    public static void main(String[] args) {

        String address = "jdbc:es://http://" + elasticsearchAddress;
        Properties connectionProperties = connectionProperties();
        try  {
            Connection connection = DriverManager.getConnection(address, connectionProperties);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(
                    "SELECT * FROM prodect");
          while(results.next()){
              System.out.println(results.getString("firstname"));
          }
        }catch (Exception e){
              e.printStackTrace();
        }

    }

    @Test
    public void fff()throws Exception{
        String address = "jdbc:es://" + elasticsearchAddress;
        Properties connectionProperties = connectionProperties();
        Connection connection =
                DriverManager.getConnection(address, connectionProperties);
        connection.createStatement();
    }

    @Test
    public void test(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String address = "jdbc:es://http://" + elasticsearchAddress;
        Properties connectionProperties = connectionProperties();

        try (Connection connection = DriverManager.getConnection(address, connectionProperties);
             Statement statement = connection.createStatement();
             ResultSet results = statement.executeQuery(
                     "SELECT *  FROM salary")) {

            while(results.next()){
                System.out.println(results.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}