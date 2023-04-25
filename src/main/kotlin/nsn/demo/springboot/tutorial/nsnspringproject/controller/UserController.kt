package nsn.demo.springboot.tutorial.nsnspringproject.controller

import nsn.demo.springboot.tutorial.nsnspringproject.model.UserModel
import nsn.demo.springboot.tutorial.nsnspringproject.service.UserService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/all")
    fun getAll(): List<UserModel> {
        return userService.getAll()
    }

    @GetMapping("/user")
    fun getByEmail(@RequestParam("email") email: String? = null): UserModel {
        return userService.getByEmail("serge@mail.com")
    }

    @GetMapping("/age-mates")
    fun getAllByAge(@RequestParam("a") age: Int? = null): List<UserModel> {
        return userService.getAllByAge(age?:2)
    }

    @GetMapping("/pattern")
    fun emailContains(@RequestParam("pattern")pattern: String? = null): List<UserModel> {
        return userService.getUserByEmailPattern(pattern?:"elma")
    }
}