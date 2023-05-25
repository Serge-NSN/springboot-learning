package nsn.demo.springboot.tutorial.nsnspringproject.service


import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.LoginDto
import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.UserDto
import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import nsn.demo.springboot.tutorial.nsnspringproject.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


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
            password = BCryptPasswordEncoder().encode(userDto.password)
        )

        return UserDto(userRepository.save(new))
    }



    fun getUsersByAgeGreaterThan(age: Int): List<UserEntity>{
        return userRepository.findByAgeGreaterThan(age)
    }

    fun loginUser(loginDto: LoginDto): ResponseEntity<UserEntity> {
        val user: Optional<UserEntity> = userRepository.findByEmail(loginDto.email)

        return if (user.isEmpty) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        } else {
            val userInfo: UserEntity = user.get()
            val hashedPassword = BCryptPasswordEncoder().encode(loginDto.password)
            if ( loginDto.email == userInfo.email  && BCryptPasswordEncoder().matches(loginDto.password, userInfo.password)) {
                ResponseEntity(userInfo, HttpStatus.OK)
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

    fun deleteUser(id: Long): ResponseEntity<String> {
        if(userRepository.findById(id).isEmpty){
            return ResponseEntity("User Does not exist!", HttpStatus.NOT_FOUND)
        }
        userRepository.delete(userRepository.findById(id).get())
        return ResponseEntity("Deleted User", HttpStatus.OK)
    }


//    fun checkUser(dto: UserDto): UserEntity {
//        val loginDetail = UserEntity(
//            email = dto.email,
//            password = dto.password
//        )
//        if
//    }

}