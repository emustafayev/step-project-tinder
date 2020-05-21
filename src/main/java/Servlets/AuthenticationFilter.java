package Servlets;


import Services.UserService;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

public class AuthenticationFilter implements Filter {
    private final UserService service;

    public AuthenticationFilter(SqlSession session) {
        service = new UserService(session);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (isHttp(req,resp) && isCorrectUser((HttpServletRequest) req) ) chain.doFilter(req,resp);
        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("/login");
    }

    private boolean isCorrectUser(HttpServletRequest req) {
        try{
            return Arrays.stream(req.getCookies()).anyMatch(this::checkCookie) &&
                    !req.getRequestURI().matches("(/login|/register)");
        }catch (NullPointerException e){
            return false;
        }
    }

    private boolean checkCookie(Cookie cookie) {
        return cookie.getName().equals("id") &&
         service.ifUserExists(
                 UUID.fromString(cookie.getValue())
         );
    }

    private boolean isHttp(ServletRequest req, ServletResponse resp) {
        return req instanceof HttpServletRequest && resp instanceof HttpServletResponse;
    }

    @Override
    public void destroy() {

    }
}