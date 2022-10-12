package com.example.music.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.SysUser;
import com.example.music.domain.vo.sys.LoginVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.example.music.constant.SysConstant.TOKEN;
import static com.example.music.constant.SysConstant.X_FORWARDED_FOR;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 16:02
 * @Description 用于登录的处理器
 */
@Slf4j
@RestController
public class SysLoginController {

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 登录方法
     *
     * @param loginVo 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        AjaxResult ajax = AjaxResult.success();

        SysUser sysUser = iSysUserService.findUserByPhone(loginVo.getPhone());
        // 核验密码
        if (checkPassword(sysUser, loginVo.getPassword())) {
            String token = iSysUserService.createToken(sysUser);
            iSysUserService.updateUserById(sysUser);
            ajax.put(TOKEN, token);
        } else {
            log.warn("登录失败，密码错误 手机号：{}，原始密码:{}", loginVo.getPhone(), sysUser.getPassword());
            return AjaxResult.error(CodeEnum.LOGIN_FAIL);
        }
        return ajax;
    }

    /**
     * 校验密码
     *
     * @param user     数据库用户信息
     * @param password 登录传输的加密的MD5信息
     * @return 是否相同
     */
    private boolean checkPassword(SysUser user, String password) {
        return user.getPassword().equals(password);
    }

}
