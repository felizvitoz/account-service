package id.bikushoppu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "id.bikushoppu.repository")
public class JpaConfig {
}
