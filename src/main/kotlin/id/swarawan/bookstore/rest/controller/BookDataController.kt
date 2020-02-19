package id.swarawan.bookstore.rest.controller

import id.swarawan.bookstore.base.BaseController
import id.swarawan.bookstore.base.ResultResponse
import id.swarawan.bookstore.entity.BookData
import id.swarawan.bookstore.repository.BookDataRepository
import id.swarawan.bookstore.rest.model.BookDataRestModel
import id.swarawan.bookstore.config.DataNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/book"])
class BookDataController : BaseController() {

	@Autowired
	lateinit var bookDataRepository: BookDataRepository

	@PostMapping
	@Transactional(rollbackFor = [Exception::class])
	fun add(@RequestBody request: BookDataRestModel): ResponseEntity<ResultResponse> {
		val bookData = BookData(
			name = request.name,
			excerpt = request.excerpt,
			content = request.content,
			author = request.author,
			publisher = request.publisher
		)
		bookDataRepository.save(bookData)
		return generateResponse(true).build()
	}

	@GetMapping(value = ["{id}"])
	fun get(@PathVariable(value = "id") id: Long): ResponseEntity<ResultResponse> {
		val bookData = bookDataRepository.findById(id)
			.orElseThrow { throw DataNotFoundException("buku") }

		return generateResponse(bookData).build()
	}
}