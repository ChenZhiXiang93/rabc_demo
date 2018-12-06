package czx.wt.filter;

import czx.wt.pojo.Urls;
import czx.wt.pojo.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 14:00
 * @Version: 1.0
 */
public class LoginFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        String path = request.getContextPath();
        logger.info("********"+uri+"*******path"+path);
        //静态资源放行
        if (uri.endsWith(".css") || uri.endsWith(".js")
                || uri.endsWith(".eot") || uri.endsWith(".svg")
                || uri.endsWith(".ttf") || uri.endsWith(".woff")
                || uri.endsWith(".png") || uri.endsWith(".jpg")
                || uri.contains("swagger") || uri.contains("wabjars") || uri.contains("v2")){
            //放行，传给下个过滤器
            filterChain.doFilter(request,servletResponse);
            return;
        }else {
            //登录请求，放行
            if (uri.contains("login")){
                logger.info("登录请求，放行");
                filterChain.doFilter(request,servletResponse);
                return;
            }else {
                //在session中拿到user信息
                HttpSession session = request.getSession();
                Users users = (Users) session.getAttribute("user");
                //判断user信息是否存在
                if (null != users && !users.equals("")){
                    List<Urls> urls = (List<Urls>) session.getAttribute("allUrl");
                    //该url是否需要认证
                    boolean isAuth = false;
                    //循环遍历
                    for (Urls u: urls) {
                        if (u.getUrlName().equals(uri)){
                            //需要认证
                            isAuth = true;
                        }
                    }
                    if (isAuth){
                        logger.info(uri+"需要验证");
                        List<Urls> urls1 = users.getUrls();
                        //用户是否有权
                        boolean isPer = false;
                        for (Urls ur : urls1) {
                            if (ur.getUrlName().equals(uri)){
                                //有权
                                isPer = true;
                            }
                        }
                        if (isPer){
                            logger.info(uri+"用户有权");
                            filterChain.doFilter(request,servletResponse);
                            return;
                        }else {
                            logger.info("用户没有权限");
                            //销毁session
                            session.removeAttribute("user");
                            session.removeAttribute("allUrl");
                            session.invalidate();
                            HttpServletResponse res = (HttpServletResponse) servletResponse;
                            res.sendRedirect(path+"/jsp/login.jsp");
                            return;
                        }
                    }else {
                        logger.info(uri+"不需要验证");
                        filterChain.doFilter(request,servletResponse);
                        return;
                    }
                }else {
                    //user为空，证明没有登录
                    logger.info("user为空，证明没有登录,跳转登录页面");
                    HttpServletResponse res = (HttpServletResponse) servletResponse;
                    res.sendRedirect(path+"/jsp/login.jsp");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
