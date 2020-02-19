package id.swarawan.bookstore.rest.model

data class BookDataRestModel(
	val name: String,
	val excerpt: String,
	val content: String,
	val author: String,
	val publisher: String
)