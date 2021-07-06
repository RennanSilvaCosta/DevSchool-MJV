package mjv.vacina.repository;

import mjv.vacina.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional(readOnly = true)
    User findByEmail(String email);

    @Transactional(readOnly = true)
    User findByCpf(String cpf);
}
