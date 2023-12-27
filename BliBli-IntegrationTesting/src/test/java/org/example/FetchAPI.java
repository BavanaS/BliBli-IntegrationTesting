package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
public class FetchAPI
{
    public List<DataItem> test(String url)
    {
        RestAssured.baseURI = url;
        Response response=RestAssured.given()
                .baseUri(url)
                .get();
        Details details=response.as(Details.class);
        List<DataItem> keywords = details.getData();
        return keywords;
    }

    public String fetchKeyword(List<DataItem> keywordsList)
    {
        List<String> keywords=new ArrayList<>();
        for (DataItem i : keywordsList)
        {
            System.out.println(i.getKeyword());
            keywords.add(i.getKeyword());
        }
        return keywords.get(0);
    }
}
