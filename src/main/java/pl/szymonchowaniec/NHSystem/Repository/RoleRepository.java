package pl.szymonchowaniec.NHSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymonchowaniec.NHSystem.Model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}
