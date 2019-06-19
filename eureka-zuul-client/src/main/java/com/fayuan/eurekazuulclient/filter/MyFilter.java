/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package com.fayuan.eurekazuulclient.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


/**
 * 自定义过滤器
 *
 * @author mr.24
 * @version Id: MyFilter, v 1.0 2019-06-19 21:39 Exp $$
 */
@Component
public class MyFilter extends ZuulFilter {
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    // 过滤器类型，这里是前置过滤
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    // 优先级，数值越低，优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }

    // 只有这里为true，才会执行过滤规则
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            logger.warn("token is empty.");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty.");
            } catch (Exception e) {
                return null;
            }
            logger.info("ok");
        }
        return null;
    }
}
