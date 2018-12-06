package czx.wt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 类作用描述
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/12/5 0005 16:45
 * @Version: 1.0
 */
@Controller
public class Login {

    @RequestMapping("/login")
    public String index(){
        return "login";
    }


    @RequestMapping("/haha/gg")
    @ResponseBody
    public String auth(){
        return "有权限";
    }
}
