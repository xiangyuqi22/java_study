package com.comba.common.core.http;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Set;

/**
 * @author chenliang
 */
public class HttpClientHelper {
    private static final int MAX_TIMEOUT = 7000;
    private static RequestConfig requestConfig;

    static {
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
        requestConfig = configBuilder.build();
    }


    public String post(String token, String url, String charset, Map<String, String> params) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        if(!StringUtils.isEmpty(token)) {
            postMethod.setRequestHeader("X-Authorization", token);
        }
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
        String retRes = "ERROR";
        //构键对参
        if (null != params) {
            Set<String> keySet = params.keySet();
            NameValuePair[] data = new NameValuePair[keySet.size()];
            int i = 0;
            for (String s : keySet) {
                data[i] = new NameValuePair(s, params.get(s));
                i++;
            }
            postMethod.setRequestBody(data);
        }
        new DefaultHttpMethodRetryHandler(3, false);
        try {
            int statusCode = client.executeMethod(postMethod);
            postMethod.getParams().setParameter(
                    HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
            if (statusCode != HttpStatus.SC_OK) {
                retRes = "Method failed: " + postMethod.getStatusLine();
            }
            byte[] responseBody = postMethod.getResponseBody();
            return new String(responseBody, charset).trim();

        } catch (HttpException e) {
            retRes = "Fatal protocol violation: " + e.getMessage();
        } catch (IOException e) {
            retRes = "Fatal transport error:" + e.getMessage();
        } finally {
            postMethod.releaseConnection();
        }
        return retRes;
    }

    /**
     * post请求，传递json参数
     *
     * @param
     * @return
     * @author wangzengfeng
     * @date 2018/1/5 13:51
     */
    public String doPost(String apiUrl, String charset, Object json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        try {
            httpPost.setConfig(requestConfig);
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json.toString(), charset);
            stringEntity.setContentEncoding(charset);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, charset);
        } catch (IOException e) {

        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                }
            }
        }
        return httpStr;
    }




    /**
     * post请求
     *
     * @param
     * @return
     * @author wangzengfeng
     * @date 2018/1/8 11:20
     */
    public String doPost(String token, String apiUrl, String charset, Object json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        httpPost.setHeader("X-Authorization", token);
        try {
            httpPost.setConfig(requestConfig);
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json.toString(), charset);
            stringEntity.setContentEncoding(charset);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, charset);
        } catch (IOException e) {

        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {

                }
            }
        }
        return httpStr;
    }


    /**
     * post请求
     *
     * @param
     * @return
     * @author wangzengfeng
     * @date 2018/1/8 11:20
     */
    public String doAPost(String token, String apiUrl, String charset) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String httpStr = null;
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;

        httpPost.setHeader("authorization", token);
        try {
            httpPost.setConfig(requestConfig);
            // 解决中文乱码问题
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, charset);
        } catch (IOException e) {

        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {

                }
            }
        }
        return httpStr;
    }


    public String get(String url, String charset) {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        try {
            int statusCode = client.executeMethod(method);
            method.getParams().setParameter(
                    HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
            if (statusCode != HttpStatus.SC_OK) {
            }
            byte[] responseBody = method.getResponseBody();
            return new String(responseBody, charset).trim();

        } catch (HttpException e) {
        } catch (IOException e) {
        } finally {
            method.releaseConnection();
        }
        return "ERROR";

    }

    /**
     * get请求，设置头部token
     *
     * @param
     * @return
     * @author wangzengfeng
     * @method
     * @date 2018/1/5 13:50
     */
    public String doHeaderGet(String url, String charset, String token) {
        String result = "";
//      创建HttpGet或HttpPost对象，将要请求的URL通过构造方法传入HttpGet或HttpPost对象。
        HttpGet httpRequst = new HttpGet(url);
        httpRequst.setHeader("Content-Type", "application/json");
        httpRequst.setHeader("Accept", "application/json");
        httpRequst.setHeader("Authorization", token);
        try {
            //使用CloseableHttpClient类的execute方法发送HTTP GET请求，并返回HttpResponse对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse httpResponse = httpClient.execute(httpRequst);
            //HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity, charset);
                // 一般来说都要删除多余的字符 去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
                result.replaceAll("\r", "");
            } else {
                httpRequst.abort();
            }

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return result;
    }


    /**
     * get请求，设置头部token
     *
     * @param
     * @return
     * @author wangzengfeng
     * @method
     * @date 2018/1/5 13:50
     */
    public String doGet(String url, String charset, String token) {
        String result = "";
//      创建HttpGet或HttpPost对象，将要请求的URL通过构造方法传入HttpGet或HttpPost对象。
        HttpGet httpRequst = new HttpGet(url);
        httpRequst.setHeader("Content-Type", "application/json");
        httpRequst.setHeader("Accept", "application/json");
        httpRequst.setHeader("X-Authorization", token);
        try {
            //使用CloseableHttpClient类的execute方法发送HTTP GET请求，并返回HttpResponse对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse httpResponse = httpClient.execute(httpRequst);
            //HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity, charset);
                // 一般来说都要删除多余的字符 去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
                result.replaceAll("\r", "");
            } else {
                httpRequst.abort();
            }

        } catch (ClientProtocolException e) {

        } catch (IOException e) {

        }
        return result;
    }

    /**
     * delete请求
     *
     * @param url
     * @param headers
     * @param charset
     * @return
     * @author wangzengfeng
     * @date 2018/1/18 11:34
     */
    public String doDelete(String url, Map<String, String> headers, String charset) {
        if (charset == null) {
            charset = "utf-8";
        }
        String content = null;
        //since 4.3 不再使用 DefaultHttpClient
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpDelete httpdelete = new HttpDelete(url);
        //设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpdelete.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = closeableHttpClient.execute(httpdelete);
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {   //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 发送 http put 请求，参数以原生字符串进行提交
     *
     * @param url
     * @param headers
     * @param charset
     * @return
     * @author wangzengfeng
     * @date 2018/1/18 11:44
     */
    public String doPut(String url, String stringJson, Map<String, String> headers, String charset) {
        if (charset == null) {
            charset = "utf-8";
        }
        //HttpClients.createDefault()等价于 HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPut httpput = new HttpPut(url);

        //设置header
        httpput.setHeader("Content-type", "application/json");
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpput.setHeader(entry.getKey(), entry.getValue());
            }
        }
        //组织请求参数
        StringEntity stringEntity = new StringEntity(stringJson, charset);
        httpput.setEntity(stringEntity);
        String content = null;
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            closeableHttpResponse = closeableHttpClient.execute(httpput);
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            content = EntityUtils.toString(httpEntity, charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeableHttpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {//关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * 发送 SSL GET 请求（HTTPS），K-V形式
     *
     * @param apiUrl  API接口URL
     * @param params  参数map
     * @param charset 字符编码 utf-8
     * @return
     */
    public static String doGetSSL(String apiUrl, String charset, Map<String, Object> params) {
        StringBuffer paramsSb = new StringBuffer();
        for (String s : params.keySet()) {
            paramsSb.append(s);
            paramsSb.append("=");
            paramsSb.append(params.get(s).toString());
            paramsSb.append("&");
        }
        if (paramsSb.length() > 0) {
            paramsSb.deleteCharAt(paramsSb.length() - 1);
            apiUrl += "?" + paramsSb.toString();
        }
        CloseableHttpClient httpClient = createHttpClient();
        HttpGet httpGet = new HttpGet(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     *
     * @param apiUrl  API接口URL
     * @param charset 字符编码 utf-8
     * @param json    JSON对象
     * @return
     */
    public String doPostSSL(String apiUrl, String charset, Object json) {
        CloseableHttpClient httpClient = createHttpClient();
        HttpPost httpPost = new HttpPost(apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try {
            httpPost.setConfig(requestConfig);
            // 解决中文乱码问题
            StringEntity stringEntity = new StringEntity(json.toString(), charset);
            stringEntity.setContentEncoding(charset);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            httpStr = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }

    public static CloseableHttpClient createHttpClient() {
        SSLConnectionSocketFactory sslConnSocketFactory = createSSLConnSocketFactory();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslConnSocketFactory).build();

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(100);
        cm.setDefaultMaxPerRoute(cm.getMaxTotal());
        return HttpClients.custom().setSSLSocketFactory(sslConnSocketFactory).setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig).build();
    }

    /**
     * 创建SSL安全连接
     *
     * @return
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {
                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }

                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return sslsf;
    }

}