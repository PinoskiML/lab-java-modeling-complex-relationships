package Lab308.repository;

import Lab308.model.Chapter;
import Lab308.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChapterRepositoryTest {
    @Autowired
    ChapterRepository chapterRepository;

    @Test
    public void findAll_chapters_chapterList() {
        List<Chapter> chapterList = chapterRepository.findAll();
        System.out.println(chapterList);
        assertEquals(7, chapterList.size(), "Expected 7"); //message is only displayed when test fails
    }


    @Test
    public void findById_id_correctChapter() {
        Optional<Chapter> chapter = chapterRepository.findById(1);
        System.out.println(chapter);
        assertTrue(chapter.isPresent(), "Chapter with id 1 was not found");
        assertEquals("Central HQ", chapter.get().getName(), "This should be Central HQ");

    }

/*
 @Test
    public void findChapterPresident_chapterID_correctChapterPresident(){
        Optional<Chapter> optionalChapter = chapterRepository.findById(5);
        //not empty
        if (optionalChapter.isPresent()){
            //System.out.println("Find president for chapter: " +optionalChapter);
            Chapter chapter = optionalChapter.get();
            Member president = chapter.getPresident();

            if (president == null){
                System.out.println("chapter" + chapter.getId() + "Has no president");
        }else{
               System.out.println("Chapter " + chapter.getId() + "'s president is: " +president.getName());
                }

    }
    }else{
        System.out.println("chapter 5 was not found");2
    }
*/


}