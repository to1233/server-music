package com.example.music.controller;

import com.example.music.common.AjaxResult;
import com.example.music.domain.entity.SysUser;
import com.example.music.domain.vo.sys.SysUserPasswordVo;
import com.example.music.enums.CodeEnum;
import com.example.music.service.ICollectService;
import com.example.music.service.ISysUserService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/21 16:44
 * @Description 用户信息查询
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private ISysUserService iSysUserService;

    @Resource
    private ICollectService iCollectService;


    @GetMapping("/detail/{userId}")
    public AjaxResult userOfId(@PathVariable("userId") Integer userId) {
        return AjaxResult.success("查询成功", iSysUserService.findUserById(userId));
    }

    @GetMapping("/getCollectInfo/{userId}")
    public AjaxResult findCollectInfo(@PathVariable("userId") Integer userId) {
        return AjaxResult.ajaxResult(iCollectService.findCollectInfo(userId));
    }

    /**
     * 注销对应的用户
     *
     * @param userId 用户id
     * @return
     */
    @GetMapping("/cancel/{userId}")
    public AjaxResult cancel(@PathVariable("userId") Integer userId) {
        return AjaxResult.ajaxResult(iSysUserService.cancelByUserId(userId));
    }

    /**
     * 更新用户信息
     * @param sysUser 用户信息
     * @return
     */
    @PostMapping("/updateUserMsg")
    public AjaxResult updateUserMsg(@RequestBody SysUser sysUser) {
        return AjaxResult.ajaxResult(iSysUserService.updateUserById(sysUser));
    }

    /**
     * 更新用户密码
     * @param sysUserPasswordVo
     * @return
     */
    @PostMapping("/updatePassword")
    public AjaxResult updatePassword(@RequestBody SysUserPasswordVo sysUserPasswordVo) {
        boolean res = iSysUserService.verifyPassword(sysUserPasswordVo.getId(),sysUserPasswordVo.getOldPassword());
        if(!res) {
            return AjaxResult.error(CodeEnum.PASSWORD_ERROR);
        }
        SysUser sysUser = new SysUser();
        sysUser.setId(sysUserPasswordVo.getId());
        sysUser.setPassword(sysUserPasswordVo.getPassword());
        return  AjaxResult.ajaxResult(iSysUserService.updateUserById(sysUser));
    }

}
