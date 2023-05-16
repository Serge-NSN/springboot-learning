package nsn.demo.springboot.tutorial.nsnspringproject.service


import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.UserDto
import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import nsn.demo.springboot.tutorial.nsnspringproject.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService (
    private val userRepository: UserRepository,
){
    companion object {
        val USERS: List<UserEntity> = listOf(
            UserEntity(name = "Serge", email = "serge@mail.com", age = 2),
            UserEntity(name = "Thelma", email = "thelma@mail.com", age = 2),
            UserEntity(name = "Elroy", email = "elroy@mail.com", age = 22)
        )

    }

    fun getAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun getUserByName(name: String): List<UserEntity>{
        return userRepository.findByName(name)
    }

    fun getUserByEmail(email: String): UserEntity{
        return userRepository.findByEmail(email)
    }
    fun register(userDto: UserDto): UserDto {
        val new = UserEntity(
            id = userDto.id,
            name = userDto.name,
            email = userDto.email,
            age = userDto.age,
            password = userDto.password
        )

        return UserDto(userRepository.save(new))
    }



    fun getUsersByAgeGreaterThan(age: Int): List<UserEntity>{
        return userRepository.findByAgeGreaterThan(age)
    }

}