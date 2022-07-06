package com.its.test_repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long id;
    private String boardTitle;
    private String boardWriter;
    private String boardContents;
    private int boardHits;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static BoardDTO toBoardETO(BoardEntity board) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(board.getId());
        boardDTO.setBoardTitle(board.getBoardTitle());
        boardDTO.setBoardWriter(board.getBoardWriter());
        boardDTO.setBoardContents(board.getBoardContents());
        boardDTO.setBoardHits(board.getBoardHits());
        boardDTO.setCreatedTime(board.getCreatedTime());
        boardDTO.setUpdatedTime(board.getUpdatedTime());
        return boardDTO;
    }

    public BoardDTO(String boardTitle, String boardWriter, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
    }
}
