package web.service;

import web.entity.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    void updateRole(Role role);
    void removeRoleById(long id);
    List<Role> getAllRoles();
    Role getRoleByName(String name);
}
