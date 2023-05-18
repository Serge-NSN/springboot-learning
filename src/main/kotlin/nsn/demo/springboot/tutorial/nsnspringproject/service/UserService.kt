package nsn.demo.springboot.tutorial.nsnspringproject.service


import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.UserDto
import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import nsn.demo.springboot.tutorial.nsnspringproject.repository.UserRepository
import org.apache.catalina.User
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class UserService (
    private val userRepository: UserRepository,
){
//    companion object {
//        val USERS: List<UserEntity> = listOf(
//            UserEntity(name = "Serge", email = "serge@mail.com", age = 2),
//            UserEntity(name = "Thelma", email = "thelma@mail.com", age = 2),
//            UserEntity(name = "Elroy", email = "elroy@mail.com", age = 22)
//        )
//
//    }

    fun getAll(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun getUserByName(name: String): List<UserEntity>{
        return userRepository.findByName(name)
    }

    fun getUserByEmail(email: String): Optional<UserEntity>{
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

    fun loginUser(email: String, password: String): ResponseEntity<UserEntity> {
        val userOptional: Optional<UserEntity> = userRepository.findByEmail(email)

        return if (userOptional.isEmpty) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            val user: UserEntity = userOptional.get()

            if (email == user.email && password == user.password) {
                ResponseEntity(user, HttpStatus.FOUND)
            } else {
                ResponseEntity(HttpStatus.UNAUTHORIZED)
            }
        }
    }

    fun getUserById(id: Long): Optional<UserEntity> {
        return userRepository.findById(id)
    }

    fun updateUser(id: Long, dto: UserDto): ResponseEntity<UserDto> {

        val userExistence: Optional<UserEntity> = userRepository.findById(id)

        if (userExistence.isEmpty){
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        else{
            val user:  UserEntity = userExistence.get()
            user.name = dto.name
            user.email = dto.email
            user.age = dto.age
            user.password = dto.password
            userRepository.save(user)
            return ResponseEntity(UserDto(user), HttpStatus.OK)
        }
    }

//    fun checkUser(dto: UserDto): UserEntity {
//        val loginDetail = UserEntity(
//            email = dto.email,
//            password = dto.password
//        )
//        if
//    }

}