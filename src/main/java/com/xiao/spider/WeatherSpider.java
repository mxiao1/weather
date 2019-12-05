package com.xiao.spider;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.xiao.spider.util.GetWebClient;

public class WeatherSpider {
    private final static String url = "";
    public void spiderWeatherData(){
        try {
            WebClient webClient = GetWebClient.getDefaultWebClient();
//            HtmlPage htmlPage = webClient.getPage("");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
