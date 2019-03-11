package com.union.aimei.pc.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseMenu;
import com.union.aimei.pc.system.mapper.BaseMenuMapper;
import com.union.aimei.pc.system.service.BaseMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufeihua
 */
@Service
public class BaseMenuServiceImpl implements BaseMenuService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private BaseMenuMapper baseMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {
        return this.baseMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insertSelective(BaseMenu record) {
        return this.baseMenuMapper.insertSelective(record);
    }

    @Override
    public BaseMenu selectByPrimaryKey(Integer menuId) {
        return this.baseMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseMenu record) {
        return this.baseMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageInfo<BaseMenu> selectListByConditions(Integer pageNo, Integer pageSize, BaseMenu record) {
        logger.info("每页的数量: " + pageSize);
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<>(baseMenuMapper.selectListByConditions(record));
    }

    /**
     * 根据id查询登录时候的菜单
     *
     * @param userId
     * @return
     */
    @Override
    public List<BaseMenu> findLoginMenus(Integer userId) {

        List<BaseMenu> loginMenus = baseMenuMapper.findLoginMenus(userId);
        List<BaseMenu> responseMenus = getList(loginMenus);

        return responseMenus;
    }


    /**
     * 查询admin的权限
     *
     * @return
     */
    @Override
    public List<BaseMenu> findAdminLoginMenus() {
        List<BaseMenu> loginMenus = baseMenuMapper.selectListByConditions(null);
        List<BaseMenu> responseMenus = getList(loginMenus);

        return responseMenus;
    }

    private List<BaseMenu> getList(List<BaseMenu> loginMenus) {
        List<BaseMenu> responseMenus = new ArrayList<>(10);

        if (loginMenus.size() > 0) {
            //查询出第一级菜单
            for (BaseMenu loginMenu : loginMenus) {
                if (loginMenu.getParentId() == 0) {
                    loginMenu.setName(loginMenu.getMenuName());
                    loginMenu.setHref(loginMenu.getMenuUrl());
                    loginMenu.setType(loginMenu.getMenuType());
                    responseMenus.add(loginMenu);
                }
            }
            //查询出第二级菜单
            for (BaseMenu menu : responseMenus) {
                for (BaseMenu baseMenu : loginMenus) {
                    if (menu.getMenuId().equals(baseMenu.getParentId())) {
                        baseMenu.setName(baseMenu.getMenuName());
                        baseMenu.setHref(baseMenu.getMenuUrl());
                        baseMenu.setType(baseMenu.getMenuType());
                        menu.setHasChildList(true);
                        menu.getChildList().add(baseMenu);
                    }
                }
            }
        }
        return responseMenus;
    }
}