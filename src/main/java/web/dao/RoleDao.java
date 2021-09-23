package web.dao;

import web.entity.Role;
import web.entity.User;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);
    void updateRole(Role role);
    void removeRoleById(long id);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}
