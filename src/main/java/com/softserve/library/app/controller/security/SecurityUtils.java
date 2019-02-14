package com.softserve.library.app.controller.security;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class SecurityUtils {

    public static boolean isSecurityPage(HttpServletRequest request) {

       /* System.out.println(" - - - SecurityUtils - - - (isSecurityPage)");

        final String urlPattern = UrlPatternUtils.getUrlPattern(request); // todo: last point...
        final Set<String> roles = SecurityConfig.getAllRoles();
*/
        /*for (String role : roles) {

            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {

                System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (true)");
                return true;
            }
        }
        System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (false)");
        return false;
    }*/

        // Проверить имеет ли данный 'request' подходящую роль?
    /*public static boolean hasPermission(HttpServletRequest request) {

        System.out.println(" - - - SecurityUtils - - - (hasPermission)");

        String urlPattern = UrlPatternUtils.getUrlPattern(request);

        Set<String> allRoles = SecurityConfig.getAllRoles();

        for (String role : allRoles) {

            if (!request.isUserInRole(role)) {

                System.out.println(" - - - SecurityUtils - - - (hasPermission) - (continue) - " + role);
                continue;
            }

            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {

                System.out.println(" - - - SecurityUtils - - - (hasPermission) - (true)");
                return true;
            }
        }
        System.out.println(" - - - SecurityUtils - - - (hasPermission) - (false)");
        return false;
    }*/
    return false;
    }
}
