package com.example.demo.service.star;

import com.example.demo.entity.Star;
import com.example.demo.model.StarModel;
import com.example.demo.repository.IdeaRepository;
import com.example.demo.repository.StarRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceStar implements IServiceStar {

    private final UserRepository userRepository;
    private final StarRepository starRepository;
    private final IdeaRepository ideaRepository;

    @Override
    public void createStar(StarModel starModel) {
        Star star = convertToEntity(starModel);
        starRepository.saveAndFlush(star);
    }

    private Star convertToEntity(StarModel starModel){
        Star star = new Star();
        star.setUser(userRepository.findById(starModel.getUserId()).get());
        star.setIdea(ideaRepository.findById(starModel.getIdeaId()).get());

        return star;
    }

}
