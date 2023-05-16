//package nsn.demo.springboot.tutorial.nsnspringproject.controller
//
//import nsn.demo.springboot.tutorial.nsnspringproject.controller.dto.PostDto
//import nsn.demo.springboot.tutorial.nsnspringproject.service.StupidService
//import org.springframework.http.HttpStatus
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PathVariable
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/api/post")
//class StupidController(
//    private val service: StupidService
//) {
//    @PostMapping
//    fun create(@RequestBody dto: PostDto): ResponseEntity<PostDto> {
//        return ResponseEntity(service.create(dto), HttpStatus.CREATED)
//    }
//
//    @GetMapping("/{id}")
//    fun get(@PathVariable id: Long): ResponseEntity<PostDto> {
//        return ResponseEntity.ok(service.get(id))
//    }
//}