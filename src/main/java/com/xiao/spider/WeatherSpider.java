package com.xiao.spider;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.xiao.spider.util.GetWebClient;
import com.xiao.spider.util.LogCvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherSpider {
    private final static String url = "http://www.weather.com.cn/textFC/hb.shtml#"; // 中国天气首页文字版
    private final static String datey = "//ul[@class='day_tabs']/li[#{date}]"; // 日期
    private final static String dataDay = "//div[@class='conMidtab'][#{date}]/div[@class='conMidtab3']/table"; // 对应日期数据 1->今天 2->明天
    public void spiderWeatherData(){
        try {
            Map<String,String> map = new HashMap<>();
            WebClient webClient = GetWebClient.getDefaultWebClient();
            HtmlPage htmlPage = webClient.getPage(url);
            List<HtmlAnchor> anchors = (List<HtmlAnchor>) htmlPage.getByXPath("//div[@class='lqcontentBoxheader']/ul/li/a");
            for (HtmlAnchor anchor: anchors){
                map.put(anchor.asText(), getLink(anchor.getHrefAttribute()));
            }
            for (Map.Entry<String,String> entry: map.entrySet()){
                String city = entry.getKey();
                String cityWeatherLink = entry.getValue();
                // 获取今天以及
                for (int i= 1; i < 8; i++) {
                    spiderTwoPage(webClient, cityWeatherLink, i);
                }
                LogCvt.info("采集---" + city + "---今天及未来七天天气情况完成----" + cityWeatherLink);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<List<String>> spiderTwoPage(WebClient webClient,String link, int i) throws Exception{
        if (!isEmpty(link)){
            HtmlPage htmlPage = webClient.getPage(link);
            List<?> date = htmlPage.getByXPath(datey.replace("#{date}", String.valueOf(i)));
            htmlPage.getByXPath(dataDay.replace("#{date}", String.valueOf(i)));
        }
        return null;
    }
    public List<List<String>> getTableValues(HtmlPage page, String xpath){

        return null;
    }
    public String getLink(String string){
        String Url = "http://" + url.split("\\/")[2] + string;
        return Url;
    }
    public static void main(String[] args){
        new WeatherSpider().spiderWeatherData();
    }
    public boolean isEmpty(String msg){
        if (msg == "" || msg == null){
            return true;
        }
        return false;
    }


}
