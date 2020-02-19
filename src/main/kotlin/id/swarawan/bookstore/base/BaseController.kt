package id.swarawan.bookstore.base

open class BaseController {

	fun generateResponse(any: Any): ResponseHandler {
		return object : ResponseHandler() {
			override fun processResponse(): Any = any
		}
	}
}