package nsn.demo.springboot.tutorial.nsnspringproject.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.*

@Entity
//@Table(name="Users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null,
    var name: String = "",
    var email: String = "",
    var age: Int=0,
    var password: String = ""
)



