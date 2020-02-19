package id.swarawan.bookstore.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "book_data")
data class BookData(

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bd_id")
	val id: Long? = null,

	@Column(name = "bd_name")
	val name: String,

	@Column(name = "bd_excerpt")
	val excerpt: String,

	@Column(name = "bd_content")
	val content: String,

	@Column(name = "bd_author")
	val author: String,

	@Column(name = "bd_publisher")
	val publisher: String
)