package jp.co.sss.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.book.entity.Book;
import jp.co.sss.book.entity.Genre;

public interface Bookrepository extends JpaRepository<Book, Integer> {

	// 曖昧検索
	List<Book> findBybookNameLike(String name);

	// ジャンルID検索
	List<Book> findByGenre(Genre genre);

}
