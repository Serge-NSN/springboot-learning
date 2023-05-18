package nsn.demo.springboot.tutorial.nsnspringproject.controller

import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.UserDto
import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import nsn.demo.springboot.tutorial.nsnspringproject.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@CrossOrigin
@RequestMapping("/api")
class UserController(
    private val userService: UserService,
) {
    //Registration
    @PostMapping("/register")
    fun registerUser(@RequestBody  dto: UserDto): ResponseEntity<UserDto> = ResponseEntity(userService.register(dto), HttpStatus.CREATED)

    //Login
    @PostMapping("/login")
    fun login(
        @RequestParam email: String,
        @RequestParam password: String
    ): ResponseEntity<UserEntity> {
        return userService.loginUser(email, password)
    }

    //Update User
    @PatchMapping("/update/{id}")
    fun updateUser(@RequestBody dto: UserDto, @PathVariable id: Long): ResponseEntity<UserDto>{
        return userService.updateUser(id, dto)
    }

    //Delete User
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<String>{
        return userService.deleteUser(id)
    }

    //Get all users
    @GetMapping("/all")
    fun getAll(): List<UserEntity> = userService.getAll()
//    @GetMapping("/user")


    //Get user by email
    @GetMapping("/email")
    fun getByEmail(@RequestParam("email") email: String? = null): Optional<UserEntity> {
        return userService.getUserByEmail(email?:"serge@mail.com")
    }

    //Get user by name
    @GetMapping("/name")
    fun getByEmail(@RequestParam name: String): List<UserEntity> = userService.getUserByName(name)

    //Get user by id
    @GetMapping("/id/{id}")
    fun getById(@PathVariable id: Long): Optional<UserEntity> = userService.getUserById(id)

    //Get users greater than a particular age
    @GetMapping("/greater-than/{age}")
    fun getUsersByAgeLessThan(@PathVariable age: Int): List<UserEntity> = userService.getUsersByAgeGreaterThan(age)

}

//    @GetMapping("/login")
//    fun login(@RequestBody dto: UserDto): ResponseEntity<UserDto>{
//        return ResponseEntity(userService.checkUser(dto), HttpStatus.NOT_FOUND)
//    }
//}

