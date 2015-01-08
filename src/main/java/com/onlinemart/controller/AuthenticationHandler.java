/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

//import com.sun.media.jfxmedia.logging.Logger;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author acer
 */
@Controller
public class AuthenticationHandler implements AuthenticationSuccessHandler {
    
RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    
    
   //@Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
 //RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
        if (hsr1.isCommitted()) {
           // Logger.logMsg(0,"Response has already been committed. Unable to redirect");
//logger.debug("Response has already bee committed. Unable to redirect to " + targetUrl);
            return;
        }

        //System.out.println(determineTargetUrl(a));
       redirectStrategy.sendRedirect(hsr, hsr1, determineTargetUrl(a));

    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isCustomer = false;
        boolean isAdmin = false;
        boolean isVendor = false;
       
        HttpSession httpsession = null;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
          //Logger.logMsg(0,"Roles are "+authorities);
        
        
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
                isCustomer = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_VENDOR")) {
                isVendor = true;
                break;
            }
        }
       // httpsess

        if (isCustomer) {
           // httpsession.setAttribute("userSession",authentication.getPrincipal());
            return "/customer/dashboard";
        } else if (isAdmin) {
            return "/admin/dashboard";
        } else if (isVendor) {
            return "/vendor/dashboard";
        } else {
            throw new IllegalStateException();
        }
    }
}
