package com.softserve.library.app.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.security.Principal;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private String user;
    private String roles;
    private HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, String roles, HttpServletRequest request) {
        super(request);
        System.out.println(" - - - Wrapper - - - ");
        this.user = user;
        this.roles = roles;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {

        System.out.println(" - - - Wrapper - - - (isUserInRole)");
        if (roles == null) {
            System.out.println(" - - - Wrapper - - - (isUserInRole) - (roles == null)");
            return this.realRequest.isUserInRole(role);
        }
        System.out.println(" - - - Wrapper - - - (isUserInRole) - (roles != null)");
        return roles.contains(role);
    }

    @Override
    public Principal getUserPrincipal() {

        System.out.println(" - - - Wrapper - - - (getUserPrincipal)");
        if (this.user == null) {

            System.out.println(" - - - Wrapper - - - (getUserPrincipal) - (this.user == null)");
            return realRequest.getUserPrincipal();
        }

        /*// Make an anonymous implementation to just return our user
        return new Principal() {
            @Override
            public String getName() {
                return user;
            }
        };*/
        System.out.println(" - - - Wrapper - - - (getUserPrincipal) - (this.user != null)");
        return null;
    }
}
