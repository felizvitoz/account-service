package id.bikushoppu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bikushoppu.entity.Role;
import id.bikushoppu.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(final Role role) throws Exception {
        return roleRepository.save(role);
    }

}
