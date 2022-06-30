package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Idea;
import com.example.demo.entity.User;
import com.example.demo.entity.Vacation;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.IdeaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PostData {

    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;
    private final CommentRepository commentRepository;
    private final VacationRepository vacationRepository;

    @PostConstruct
    private void initData () {
        User user = new User();

        user.setCabinet("B151");
        user.setAvatarUrl("https://avatarfiles.alphacoders.com/924/9248.jpg");
        user.setCoins(100);
        user.setPhone("89506581031");
        user.setKarma(100);
        user.setUsername("Олех");
        user.setEmail("worfa@mail.ru");

        userRepository.saveAndFlush(user);

        Idea idea = new Idea();
        idea.setDate(LocalDate.of(2020,10,20));
        idea.setBodyText("Идея идей по факту");
        idea.setHeadText("Главная идея месяца");
        idea.setUser(user);

        ideaRepository.saveAndFlush(idea);

        Comment comment = new Comment();
        comment.setIdea(idea);
        comment.setUser(user);
        comment.setDate(LocalDate.of(2020,10,20));
        comment.setBodyText("Идея бомба я так считаю");
        comment.setHeadText("Идея бомба!!!");

        commentRepository.saveAndFlush(comment);

        Vacation vacation = new Vacation();
        vacation.setVacationEnd(LocalDate.of(2021,10,20));
        vacation.setVacationStart(LocalDate.of(2020,10,20));
        vacation.setUser(user);
        vacationRepository.saveAndFlush(vacation);
    }
}
