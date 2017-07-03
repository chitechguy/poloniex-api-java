package com.cf.client;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author David
 */
public class HTTPClient
{
	private static final int TIMEOUT = 10;
	private RequestConfig config = RequestConfig.custom()
			.setConnectTimeout(TIMEOUT * 1000)
			.setConnectionRequestTimeout(TIMEOUT * 1000)
			.setSocketTimeout(TIMEOUT * 1000).build();

    public String postHttp(String url, List<NameValuePair> params, List<NameValuePair> headers) throws IOException
    {
        HttpPost post = new HttpPost(url);
        post.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        post.getEntity().toString();

        if (headers != null)
        {
            for (NameValuePair header : headers)
            {
                post.addHeader(header.getName(), header.getValue());
            }
        }

        try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {

	        HttpResponse response = httpClient.execute(post);

	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
		        return EntityUtils.toString(entity);

	        }
        }
        return null;
    }

    public String getHttp(String url, List<NameValuePair> headers) throws IOException
    {
        HttpRequestBase request = new HttpGet(url);

        if (headers != null)
        {
            for (NameValuePair header : headers)
            {
                request.addHeader(header.getName(), header.getValue());
            }
        }

	    try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {

		    HttpResponse response = httpClient.execute(request);

		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
			    return EntityUtils.toString(entity);

		    }
	    }
        return null;
    }
}
