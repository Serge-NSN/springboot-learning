package nsn.demo.springboot.tutorial.nsnspringproject.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
//@Table(name="Users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?=null,
    val name: String = "",
    val email: String = "",
    val age: Int=0
)


