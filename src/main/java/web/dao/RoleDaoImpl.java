package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.Role;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addRole(Role role) {
        String str = role.getName();
        if(!(getAllRoles().contains(str))){
            Role manager = entityManager.merge(role);
            entityManager.persist(manager);
        }
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.name=:role",
                Role.class).setParameter("role", name);
        return queryRole.getSingleResult();
    }
}
