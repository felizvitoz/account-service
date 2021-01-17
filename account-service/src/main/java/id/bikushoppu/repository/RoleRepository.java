package id.bikushoppu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.bikushoppu.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findFirstByCode(String code);
}
