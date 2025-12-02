package ir.maktabsharif.busticketsystem.repository;

import ir.maktabsharif.busticketsystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    Optional<AppUser> findByFullName(String fullName);

    Optional<AppUser> findById(Long id);
}
