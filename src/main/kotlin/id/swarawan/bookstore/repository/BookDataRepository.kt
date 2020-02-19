package id.swarawan.bookstore.repository

import id.swarawan.bookstore.entity.BookData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookDataRepository : JpaRepository<BookData, Long> {
}