package com.example.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.music.dao.SysUserMapper;
import com.example.music.domain.entity.SysUser;
import com.example.music.enums.DataStatusEnum;
import com.example.music.service.CacheService;
import com.example.music.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.music.constant.SysConstant.DbColumnKey.*;

/**
 * @author zhangyang
 * @version 1.0
 * @Date 2022/8/13 17:07
 * @Description 用户信息查询接口
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    private CacheService cacheService;

    @Override
    public SysUser getUserByToken(String token) {
        log.debug("token验证：{}", token);
        return cacheService.getUserByToken(token);
    }

    @Override
    public void saveToken(String token, SysUser sysUser) {
        log.debug("更新用户信息---token验证：{},用户信息---{}", token, sysUser.toString());
        cacheService.cacheUserByToken(token, sysUser);
    }

    @Override
    public SysUser findUserByPhone(String phone) {
        return getBaseMapper().selectOne(new QueryWrapper<SysUser>().eq(PHONE_NUM, phone));
    }

    @Override
    public SysUser findUserByUserName(String userName) {
        return getBaseMapper().selectOne(new QueryWrapper<SysUser>().eq(USER_NAME, userName));
    }

    @Override
    public String createToken(SysUser user) {
        String token = getToken();
        saveToken(token, user);
        return token;
    }

    @Override
    public boolean updateUserById(SysUser sysUser) {
        return getBaseMapper().updateById(sysUser) > 0;
    }

    @Override
    public SysUser findUserById(Integer userId) {
        return getBaseMapper().selectById(userId);
    }

    @Override
    public boolean cancelByUserId(Integer userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setIsDeleted(DataStatusEnum.NO_USING.getStatus());
        return getBaseMapper().updateById(sysUser) > 0;
    }

    @Override
    public boolean verifyPassword(Integer userId, String password) {
        return getBaseMapper().selectCount(new QueryWrapper<SysUser>().eq(ID, userId).eq(PASSWORD, password)) > 0;
    }

    private String getToken() {
        int temp = (int) (Math.random() * 1000);
        return String.valueOf(temp);
    }


}
