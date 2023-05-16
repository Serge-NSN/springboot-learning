package nsn.demo.springboot.tutorial.nsnspringproject.controller.dto

import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity

data class UserDto(
    val id: Long? = null,
    val name: String = "",
    val email: String = "",
    val age: Int = 0,
    val password: String = ""
)   {
        constructor(userEntity: UserEntity): this(
            id = userEntity.id,
            name = userEntity.name,
            email = userEntity.email,
            age = userEntity.age,
            password = userEntity.password
        )
}


