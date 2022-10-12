package com.example.music.service;

import com.example.music.domain.entity.SysUser;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:00
 * @Description 用户信息实体类
 */
public interface ISysUserService {

    /**
     * 通过token 去获取缓存中的用户信息
     * @param token token
     * @return SysUser 用户信息
     */
    SysUser getUserByToken(String token);

    /**
     * 将sysUser 内容保存到缓存中
     * @param token 信令
     * @param sysUser 用户信息
     */
    void saveToken(String token,SysUser sysUser);

    /**
     * 使用用户
     * @param phone
     * @return
     */
    SysUser findUserByPhone(String phone);


    /**
     * 根据用户信息创建出token
     *
     * @param user 目标用户信息
     * @return
     */
    String createToken(SysUser user);

    /**
     * 根据用户id来更新用户信息
     * @param sysUser 用户信息
     * @return boolean 更新结果
     */
    boolean updateUserById(SysUser sysUser);

    /**
     * 查询用户信息根据id
     * @param userId
     * @return
     */
    SysUser findUserById(Integer userId);



}
