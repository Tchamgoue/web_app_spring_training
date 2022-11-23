package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;



@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter{


    private final  String instanceId = UUID.randomUUID().toString();

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // before the rest (filters, servlet)


        if (servletResponse instanceof HttpServletResponse httpResponse){
            //((HttpServletResponse) servletResponse).addHeader();
            httpResponse.setHeader("Instance-Id", instanceId);
        }

        filterChain.doFilter(servletRequest, servletResponse);

        // after the rest (filters, servlet)
        //httpResponse.setHeader("titi", "toto");
    }


}
