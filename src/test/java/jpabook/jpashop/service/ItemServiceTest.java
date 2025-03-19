package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemService itemService;

    @Test
    public void 아이템_등록() throws Exception {
        //given
        Album album = new Album();
        album.setArtist("kim");
        Book book = new Book();
        book.setAuthor("kim");
        Movie movie = new Movie();
        movie.setDirector("kim");

        //when
        Long savedAlbumId = itemService.saveItem(album);
        Long savedBookId = itemService.saveItem(book);
        Long savedMovieId = itemService.saveItem(movie);

        //then
        assertEquals(album, itemService.findOne(savedAlbumId));
        assertEquals(book, itemService.findOne(savedBookId));
        assertEquals(movie, itemService.findOne(savedMovieId));
    }
}