package com.example.demo.service.vacation;

import com.example.demo.entity.Vacation;
import com.example.demo.model.VacationModel;
import com.example.demo.model.repository.UserRepository;
import com.example.demo.model.repository.VacationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceVacation implements IServiceVacation {

    private final UserRepository userRepository;
    private final VacationRepository vacationRepository;

    @Override
    public void createVacation(VacationModel vacationModel) {
        Vacation vacation = convertToEntity(vacationModel);
        vacationRepository.saveAndFlush(vacation);
    }

    private Vacation convertToEntity(VacationModel vacationModel){
        Vacation vacation = new Vacation();
        vacation.setVacationStart(vacationModel.getVacationStart());
        vacation.setVacationEnd(vacationModel.getVacationEnd());
        vacation.setUser(userRepository.findById(vacationModel.getUserId()).get());

        return vacation;
    }
}
