package nsn.demo.springboot.tutorial.nsnspringproject.service

import nsn.demo.springboot.tutorial.nsnspringproject.model.UserModel
import org.springframework.stereotype.Service


@Service
class UserService {
    companion object {
        val USERS = listOf(
            UserModel(name = "Serge", email = "serge@mail.com", age = 2),
            UserModel(name = "Thelma", email = "thelma@mail.com", age = 2),
            UserModel(name = "Elroy", email = "elroy@mail.com", age = 22)
        )
    }

    fun getAll(): List<UserModel> {
        return USERS
    }
//    fun getByEmail(email: String): UserModel {
//        var ans: UserModel? = null
//
//        for (elt in USERS) {
//            if (elt.email==email) {
//                ans = elt
//            }
//
//        }
//        return ans?: throw NoSuchElementException("User not found")
//    }

    fun getAllByAge(age: Int): List<UserModel>{
        var ans: MutableList<UserModel> = mutableListOf()
        for (elt in USERS){
            if (elt.age == age){
                ans.add(elt)
            }
        }
        return ans.toMutableList()
    }

    fun getEmailContainingPattern(pattern: String): List<UserModel> {
        val ans: MutableList<UserModel> = mutableListOf()
        for (elt in USERS){
            if(elt.email.contains(pattern)){
                ans.add(elt)
            }
        }
        return ans.toList()
    }

    fun getByEmail(email: String): UserModel {
        return USERS.filter{ it.email == email }[0]
    }

    fun getUserByEmailPattern(pattern: String): List<UserModel> {
        return USERS.filter { it.email.contains(pattern) }
    }
}