package nsn.demo.springboot.tutorial.nsnspringproject.controller

import nsn.demo.springboot.tutorial.nsnspringproject.model.UserEntity
import nsn.demo.springboot.tutorial.nsnspringproject.service.UserService
import org.apache.catalina.User
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/users")
class UserController(
    private val userService: UserService,
) {
    val e1 = UserEntity(name = "Dudu", email = "dudu@mail.com", age = 2)
    val e2: List<UserEntity> = listOf(
            UserEntity(name="Ten", email="ten@mail", age=10),
            UserEntity(name="Twenty", email="twenty@mail", age=20),
            UserEntity(name="Thirty", email="thirty@mail", age=30),
            UserEntity(name="Forty", email="forty@mail", age=40),
            UserEntity(name="Fifty", email="fifty@mail", age=50),
            UserEntity(name="Twenty", email="twentycopy@mail", age=20),

    )

    @PostMapping("/save")
    fun addEntity(): String {
        for (elt in e2) {
            userService.new(elt)
        }
        return "Added 6 new Entities!"
    }


    @GetMapping("/greater/{age}")
    fun getUsersByAgeLessThan(@PathVariable age: Int): List<UserEntity>{
        return userService.getUsersByAgeGreaterThan(age)
    }

    @GetMapping("/all")
    fun getAll(): List<UserEntity> {
        return userService.getAll()
    }

//    @GetMapping("/user")
//    fun getByEmail(@RequestParam("email") email: String? = null): UserEntity {
//        return userService.getByEmail(email?:"serge@mail.com")
//    }

    @GetMapping("/username/{name}")
    fun getByName(@PathVariable name: String): List<UserEntity>{
        return userService.getUserByName(name)
    }

    @GetMapping("/user/{email}")
    fun getByEmail(@PathVariable email: String): UserEntity{
        return userService.getUserByEmail(email)
    }
}

