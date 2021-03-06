package com.example.demo.dao;

import com.example.demo.controller.RoleController;
import com.example.demo.controller.UserController;
import com.example.demo.model.persistent.RoleDTO;
import com.example.demo.model.persistent.Role;
import com.example.demo.model.persistent.RoleMenuRel;
import com.example.demo.utils.MappingUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单模块数据持久层
 */
@Repository
public class RoleDao {
    private final SqlSession sqlSession;
    private static final String namespace = "cn.example.demo.Role.";

    private String getMapperName(String mapperName) {
        return namespace + mapperName;
    }


    public RoleDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Role getRoleById(Long id) {
        return sqlSession.selectOne(getMapperName("getRoleById"), MappingUtils.asMap("id", id));
    }

    public Role getRoleByName(String name) {
        return sqlSession.selectOne(getMapperName("getRoleByName"), MappingUtils.asMap("name", name));
    }

    public void createRole(Role role) {
        sqlSession.insert(getMapperName("createRole"), role);
    }

    public List<Role> getAll() {
        return sqlSession.selectList(getMapperName("getAll"));
    }

    public void updateRole(Role role) {
        sqlSession.update(getMapperName("updateRole"), role);
    }

    public void deleteRole(Long id) {
        sqlSession.delete(getMapperName("deleteRole"), MappingUtils.asMap("id", id));
    }

    public List<Role> getList(Role role) {
        return sqlSession.selectList(getMapperName("getPage"), role);
    }

    public void saveRoleMenus(RoleController.TempRoleMenu roleMenuObj) {
        sqlSession.update(getMapperName("saveRoleMenus"), roleMenuObj);
    }

    public void clearMenus(Long roleId) {
        sqlSession.delete(getMapperName("clearMenus"), roleId);
    }

    public List<RoleMenuRel> getRoleMenus(Long roleId) {
        return sqlSession.selectList(getMapperName("getRoleMenus"), MappingUtils.asMap("roleId", roleId));
    }

    public void cleanRolesByUserId(@Param("userId") Long userId) {
        sqlSession.delete("cleanRolesByUserId", userId);
    }

    public void bindRolesByUserId(UserController.UserIdRoles userIdRoles) {
        System.out.println(userIdRoles);
        sqlSession.insert(getMapperName("bindRolesByUserId"), userIdRoles);
    }

    public List<RoleDTO> getUserRolesByUserId(List<Long> userIds) {
        return sqlSession.selectList(getMapperName("getUserRolesByUserId"), MappingUtils.asMap("userIds",userIds));
    }
}