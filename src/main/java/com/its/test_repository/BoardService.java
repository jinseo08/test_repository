package com.its.test_repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toBoardDTO(boardDTO);
        Long id = boardRepository.save(boardEntity).getId();
        return id;
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for(BoardEntity board : boardEntityList){
            boardDTOList.add(BoardDTO.toBoardETO(board));
        }
        return boardDTOList;
    }

        public BoardDTO findById(Long boardId) {
        Optional<BoardEntity> optionalBoardEntity =boardRepository.findById(boardId);
        if(optionalBoardEntity.isPresent()){
            return BoardDTO.toBoardETO(optionalBoardEntity.get());
        }else {
            return null;
        }
    }
}


