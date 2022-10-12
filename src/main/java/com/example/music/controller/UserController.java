package com.example.music.controller;

        import com.example.music.common.AjaxResult;
        import com.example.music.service.ISysUserService;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:44
 * @Description
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private ISysUserService iSysUserService;

    @GetMapping("/detail")
    public AjaxResult userOfId(Integer id) {
        return AjaxResult.success("查询成功", iSysUserService.findUserById(id));
    }
}
