package com.its.test_repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService bs;

    @PostMapping("/board/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        bs.save(boardDTO);
        return "/board";
    }

    @GetMapping("board/{boardId}")
    public String findById(@PathVariable Long boardId, Model model){
        BoardDTO boardDTO = bs.findById(boardId);
        model.addAttribute("board", boardDTO);
        return "/detail";
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = bs.findAll();
        model.addAttribute("boardList",boardDTOList);
        return "/boardPages/list";
    }
}
