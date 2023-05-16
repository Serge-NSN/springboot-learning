//package nsn.demo.springboot.tutorial.nsnspringproject.service
//
//import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.PostDto
//import nsn.demo.springboot.tutorial.nsnspringproject.entity.PostEntity
//import nsn.demo.springboot.tutorial.nsnspringproject.repository.StupidRepository
//import org.springframework.http.ResponseEntity
//import org.springframework.stereotype.Service
//
//@Service
//class StupidService(
//    private val repository: StupidRepository
//) {
//    fun create(postDto: PostDto): PostDto {
//        val post = PostEntity(
//            title = postDto.title,
//            content = postDto.content
//        )
//        return PostDto(repository.save(post))
//    }
//
//    fun get(id: Long): PostDto {
//        return repository.findById(id).let {
//            if (it.isPresent) PostDto(it.get())
//            else throw Exception("Post not found")
//        }
//    }
//}
