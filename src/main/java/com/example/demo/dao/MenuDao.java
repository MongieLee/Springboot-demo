package com.example.demo.dao;

import com.example.demo.model.persistent.Menu;
import com.example.demo.model.service.MenuDto;
import com.example.demo.utils.MappingUtils;
import lombok.val;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 菜单模块数据持久层
 */
@Repository
public class MenuDao {
    private final SqlSession sqlSession;

    public MenuDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Menu getMenuById(Long id) {
        return sqlSession.selectOne("getMenuById", MappingUtils.asMap("id", id));
    }

    public Menu getMenuByName(String name) {
        return sqlSession.selectOne("getMenuByName", MappingUtils.asMap("name", name));
    }

    public void createMenu(Menu menu) {
        sqlSession.insert("createMenu", menu);
    }

    public List<Menu> getAll() {
        return sqlSession.selectList("cn.example.demo.Menu.getAll");
    }

    public void updateMenu(Menu menu) {
        sqlSession.update("updateMenu", menu);
    }

    public void deleteMenu(Long id) {
        sqlSession.delete("deleteMenu", MappingUtils.asMap("id", id));
    }

    public Integer findMaxSequence() {
        return sqlSession.selectOne("findMaxSequence");
    }

    public List<Menu> getSibling(Menu menu) {
        return sqlSession.selectList("cn.example.demo.Menu.getSibling", menu);
    }

    public List<Menu> getUserMenus(Long userId) {
        return sqlSession.selectList("getUserMenus", userId);
    }

    public void test() {
        val list = Arrays.asList(1, 2, 3);
        sqlSession.selectOne("test", list);
    }
}