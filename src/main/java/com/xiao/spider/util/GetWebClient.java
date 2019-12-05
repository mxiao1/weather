package com.xiao.spider.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;

public class GetWebClient {
    private final static int timeout = 60; // 超时时间单元
    public static WebClient getDefaultWebClient(){
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setTimeout(timeout*3);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        String[] sslClientProtocols = { "TLSv1", "TLSv1.1", "TLSv1.2" };// 设置支持的TLS协议版本
        webClient.getOptions().setSSLClientProtocols(sslClientProtocols);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        return webClient;
    }
}
