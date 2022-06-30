package com.example.demo.service.comment;

import com.example.demo.entity.Comment;
import com.example.demo.model.CommentModel;
import com.example.demo.model.repository.CommentRepository;
import com.example.demo.model.repository.IdeaRepository;
import com.example.demo.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceComment implements IServiceComment{

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final IdeaRepository ideaRepository;

    @Override
    public void createComment(CommentModel commentModel) {
        Comment comment = convertToEntity(commentModel);
        commentRepository.saveAndFlush(comment);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    private Comment convertToEntity(CommentModel commentModel){
        Comment comment = new Comment();
        comment.setDate(commentModel.getDate());
        comment.setBodyText(commentModel.getBodyText());
        comment.setHeadText(commentModel.getHeadText());
        comment.setIdea(ideaRepository.findById(commentModel.getIdeaId()).get());
        comment.setUser(userRepository.findById(commentModel.getUserId()).get());

        return comment;
    }
}
