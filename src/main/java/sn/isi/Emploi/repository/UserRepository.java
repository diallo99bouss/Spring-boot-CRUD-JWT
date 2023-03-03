package sn.isi.Emploi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.Emploi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
