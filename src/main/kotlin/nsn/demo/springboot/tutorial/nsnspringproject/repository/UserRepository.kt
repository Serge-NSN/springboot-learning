package nsn.demo.springboot.tutorial.nsnspringproject.repository

import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<UserEntity, Long>{
    fun findByAgeGreaterThan(age:Int): List<UserEntity>
    fun findByName(name: String): List<UserEntity>
    fun findByEmail(email: String): Optional<UserEntity>

}