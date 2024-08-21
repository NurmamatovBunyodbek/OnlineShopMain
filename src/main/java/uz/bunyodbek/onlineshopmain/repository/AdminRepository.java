package uz.bunyodbek.onlineshopmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.onlineshopmain.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    boolean existsByUsernameAndPassword(String username, String password);


}
