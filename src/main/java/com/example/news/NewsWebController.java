package com.example.news;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/news")
public class NewsWebController {
  final NewsDAO dao;

  @Value("${news.imgdir}")
  String imgDir;

  @Autowired
  public NewsWebController(NewsDAO dao) {
    this.dao = dao;
  }


//  목록보기
  @GetMapping("/list")
  public String list(Model m) {
    List<News> newsList;
    try {
      newsList = dao.getAll();
      m.addAttribute("newsList", newsList);
    } catch (SQLException e) {
      e.printStackTrace();
      log.info("뉴스 목록 가져오기에서 문제 발생");
      m.addAttribute("error", "뉴스 목록 보기가 정상적으로 처리되지 않았습니다.");
    }
    return "news/newsList";
  }


//  등록하기
//  삭제하기
//  상세보기
}
