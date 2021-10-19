package com.du.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MylocaleResolver implements LocaleResolver {
    //解析请求
    @Override //需要放到MvcConfig的beanli才能生效
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求中的语言参数
        String langauge = request.getParameter("l");
        Locale locale = Locale.getDefault();
        //如果请求带了国际化的参数
        if (StringUtils.hasLength(langauge)){
            //zh_CN
            String[] split = langauge.split("_");
            //国家，地区
            locale = new Locale(split[0],split[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
