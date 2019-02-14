package com.softserve.library.app.controller.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

public class UrlPatternUtils {

    private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {

        System.out.println(" - - - UrlPatternUtils - - - (hasUrlPattern)");
        Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();

        for (String servletName : map.keySet()) {

            ServletRegistration sr = map.get(servletName);

            Collection<String> mappings = sr.getMappings();

            if (mappings.contains(urlPattern)) {
                System.out.println(" - - - UrlPatternUtils - - - (hasUrlPattern) - true");
                return true;
            }
        }
        System.out.println(" - - - UrlPatternUtils - - - (hasUrlPattern) - false");
        return false;
    }

    // servletPath:
    // ==> /spath
    // ==> /spath/*
    // ==> *.ext
    // ==> /

    public static String getUrlPattern(HttpServletRequest request) {

        System.out.println(" - - - UrlPatternUtils - - - (getUrlPattern)");

        ServletContext servletContext = request.getServletContext();
        System.out.println(" - - - UrlPatternUtils - - - (getUrlPattern) - servletContext - " + servletContext);
        String servletPath = request.getServletPath();
        System.out.println(" - - - UrlPatternUtils - - - (getUrlPattern) - servletPath - " + servletPath);
        String pathInfo = request.getPathInfo();
        System.out.println(" - - - UrlPatternUtils - - - (getUrlPattern) - pathInfo - " + pathInfo);
        String urlPattern;

        if (pathInfo != null) {

            System.out.println(" - - - UrlPatternUtils - - - (getUrlPattern) - ( if (pathInfo != null) {)");
            urlPattern = servletPath + "/*";
            return urlPattern;
        }

        urlPattern = servletPath;

        boolean has = hasUrlPattern(servletContext, urlPattern);

        if (has) {

            return urlPattern;
        }

        /*int i = servletPath.lastIndexOf('.');

        if (i != -1) {

            String ext = servletPath.substring(i + 1);
            urlPattern = "*." + ext;
            has = hasUrlPattern(servletContext, urlPattern);

            if (has) {

                return urlPattern;
            }
        }*/
        return "/";
    }
}
