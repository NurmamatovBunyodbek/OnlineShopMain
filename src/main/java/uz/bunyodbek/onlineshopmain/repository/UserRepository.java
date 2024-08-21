package uz.bunyodbek.onlineshopmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.onlineshopmain.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByPhonenumber(String phonenumber);


}
