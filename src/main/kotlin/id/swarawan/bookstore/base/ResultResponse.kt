package id.swarawan.bookstore.base

data class ResultResponse(
	var status: String = "OK",
	var data: Any? = null,
	var meta: MetaResponse? = null
)