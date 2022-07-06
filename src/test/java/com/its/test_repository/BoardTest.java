package com.its.test_repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService bs;


    @Test
    @Transactional
    @Rollback
    @DisplayName("로그인 테스트")
    public void loginTest(){
        String testTitle = "테스트제목";
        String testWriter = "테스트작성자";
        String testContents = "테스트내용";
        BoardDTO boardDTO = new BoardDTO(testTitle,testWriter,testContents);
        Long saveId = bs.save(boardDTO);
        BoardDTO resultDTO = new BoardDTO();
        resultDTO.setBoardWriter(testWriter);
        assertThat(resultDTO).isEqualTo(saveId);
    }



}
