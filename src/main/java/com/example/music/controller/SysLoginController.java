package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.SysUser;
import com.example.music.domain.vo.sys.LoginSuccessVo;
import com.example.music.domain.vo.sys.LoginVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.ISysUserService;
import com.example.music.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.example.music.constant.SysConstant.TOKEN;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 16:02
 * @Description 用于登录的处理器
 */
@Slf4j
@RestController("/sys")
public class SysLoginController {

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 登录方法
     *
     * @param loginVo 登录信息
     * @return 结果
     */
    @PostMapping("/loginByUserName")
    public AjaxResult login(@RequestBody LoginVo loginVo) {

        SysUser sysUser = iSysUserService.findUserByUserName(loginVo.getUserName());
        if (sysUser == null) {
            return AjaxResult.error(CodeEnum.NOT_USER_NAME);
        }
        // 核验密码
        if (checkPassword(sysUser, loginVo.getPassword())) {
            String token = JWTUtil.createToken(sysUser);
            LoginSuccessVo loginSuccessVo = new LoginSuccessVo();
            BeanUtils.copyProperties(sysUser,loginSuccessVo);
            loginSuccessVo.setToken(token);
            loginSuccessVo.setUserId(sysUser.getId());
            iSysUserService.updateUserById(sysUser);
            return AjaxResult.success("登录成功", loginSuccessVo);
        } else {
            log.warn("登录失败，密码错误 账号名：{}，原始密码:{}", loginVo.getUserName(), sysUser.getPassword());
            return AjaxResult.error(CodeEnum.LOGIN_FAIL);
        }
    }

    @PostMapping("/loginByPhone")
    public AjaxResult loginByPhone(@RequestBody LoginVo loginVo, HttpServletRequest request) {
        AjaxResult ajax = AjaxResult.success();

        SysUser sysUser = iSysUserService.findUserByPhone(loginVo.getPhone());
        // 核验密码
        if (sysUser == null) {
            return AjaxResult.error(CodeEnum.NOT_PHONE);
        }
        if (checkPassword(sysUser, loginVo.getPassword())) {
            String token = JWTUtil.createToken(sysUser);
            iSysUserService.updateUserById(sysUser);
            ajax.put(TOKEN, token);
        } else {
            log.warn("登录失败，密码错误 账号名：{}，原始密码:{}", loginVo.getUserName(), sysUser.getPassword());
            return AjaxResult.error(CodeEnum.LOGIN_FAIL);
        }
        return ajax;
    }


    @PostMapping("/signUp")
    public AjaxResult signUp(@RequestBody SysUser sysUser ) {
        return AjaxResult.success();
    }




    /**
     * 校验密码
     *
     * @param user     数据库用户信息
     * @param password 登录传输的加密的MD5信息
     * @return 是否相同
     */
    private boolean checkPassword(SysUser user, String password) {
        return password.equals(user.getPassword());
    }

}
