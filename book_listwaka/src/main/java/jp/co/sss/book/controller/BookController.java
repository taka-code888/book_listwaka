package jp.co.sss.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.book.entity.Genre;
import jp.co.sss.book.repository.Bookrepository;

@Controller
public class BookController {

	@Autowired
	private Bookrepository bookRepository;

	/**
	 * http://localhost:2222/book_list/list
	 * 2つのテーブルが結合された検索結果を取得するためのメソッド
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String showItemAndCategoryList(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "list";
	}

	/**
	 *
	 * Like 曖昧検索
	 * @param name
	 * @param model
	 * @return
	 */
	@PostMapping("/list/like")
	public String bookLike(String name, Model model) {

		// 「%」は「0 文字以上の任意の文字列」の意味
		model.addAttribute("books", bookRepository.findBybookNameLike("%" + name + "%"));

		//return "redirect:/lesson03_01/index";
		return "list";
	}

	/**
	 *
	 * @param categoryId
	 * @param model
	 * @return
	 */
	@RequestMapping("/list/genre")
	public String searchByGenreId(int genreId, Model model) {

		// 参照先テーブルに対応付けられたエンティティGenreのオブジェクトを生成
		Genre genre = new Genre();

		// Categoryのオブジェクト内のidフィールドにパラメータの値を代入

		genre.setGenreId(genreId);

		// Categoryのオブジェクト内のidフィールドを使用した条件検索を実行
		//List<Book> books = bookRepository.findByGenre(genre);

		// 検索結果をリクエストスコープに保存
		model.addAttribute("books", bookRepository.findByGenre(genre));

		// 一覧画面に遷移
		return "list";
	}

}
