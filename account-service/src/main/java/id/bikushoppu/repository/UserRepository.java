package id.bikushoppu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import id.bikushoppu.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
