package com.example.demo.service.idea;

import com.example.demo.entity.Idea;
import com.example.demo.model.IdeaModel;
import com.example.demo.repository.IdeaRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceIdea implements IServiceIdea {

    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;


    @Override
    public void createIdea(IdeaModel ideaModel) {
        Idea idea = convertToEntity(ideaModel);
        ideaRepository.saveAndFlush(idea);
    }

    private Idea convertToEntity(IdeaModel ideaModel){
        Idea idea = new Idea();
        idea.setDate(ideaModel.getDate());
        idea.setBodyText(ideaModel.getBodyText());
        idea.setHeadText(ideaModel.getHeadText());
        idea.setUser(userRepository.findById(ideaModel.getUserId()).get());

        return idea;
    }
}
