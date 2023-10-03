package com.clothesstore.adminservice.utils;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Resource
public class ShopifyUtils {
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    private final WebClient.Builder webClientBuilder;

}
/*

public static function countDataCustomer($shop, $accessToken)
{
fe
    $client = new Client();
    $url = 'https://' . $shop . '/admin/api/2022-07/customers/count.json';
    $request = $client->request('get', $url, [
            'headers' => [
            'X-Shopify-Access-Token' => $accessToken,
            ]
        ]);
    $countCustomer = (array)json_decode($request->getBody());

    return $countCustomer;
}


    public static function setParam(array $headers, $params)
    {
        $links = explode(',', @$headers['Link'][0]);
        $nextPage = $prevPage = null;
        foreach ($links as $link) {
        if (strpos($link, 'rel="next"')) {
            $nextPage = $link;
        }
        if (strpos($link, 'rel="previous"')) {
            $prevPage = $link;
        }
    }

        $params = [];

        if ($nextPage) {
            preg_match('~<(.*?)>~', $nextPage, $next);
            $urlComponents = parse_url($next[1]);
            parse_str($urlComponents['query'], $parseStr);
            $params = $parseStr;
            $params['next_cursor'] = $parseStr['page_info'];
        }

        if ($prevPage) {
            preg_match('~<(.*?)>~', $prevPage, $next);
            $urlComponents = parse_url($next[1]);
            parse_str($urlComponents['query'], $parseStr);
            $params = !empty($params) ? $params : $parseStr;
            $params['prev_cursor'] = $parseStr['page_info'];
        }

        return $params;
    }
}
*
*/