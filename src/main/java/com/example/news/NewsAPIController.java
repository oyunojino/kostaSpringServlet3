package com.example.news;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/news")
public class NewsAPIController {
  final NewsDAO dao;

  @Autowired
  public NewsAPIController(NewsDAO dao) {
    this.dao = dao;
  }

  @GetMapping
  public List<News> list() {
    List<News> newsList = new ArrayList<>();
    try {
      newsList = dao.getAll();
    } catch (SQLException e) {
      e.printStackTrace();
      log.warn("뉴스 목록 가져오기에서 문제 발생");
//      error 객체 추가 - error 따로 처리하는 화면 구성
    }
    return newsList;
  }
}

