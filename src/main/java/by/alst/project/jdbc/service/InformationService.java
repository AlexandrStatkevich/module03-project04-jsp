package by.alst.project.jdbc.service;

import by.alst.project.jdbc.dao.InformationDao;
import by.alst.project.jdbc.dto.InformationDto;
import by.alst.project.jdbc.entity.Information;

import java.util.List;

public class InformationService {

    private static final InformationService INSTANCE = new InformationService();

    private InformationService() {
    }

    public static InformationService getInstance() {
        return INSTANCE;
    }

    private final InformationDao informationDao = InformationDao.getInstance();

    public List<InformationDto> findAll() {
        return informationDao.findAll().stream().map(information -> new InformationDto(information.getUsersId(),
                information.getFirstName(), information.getSecondName(), information.getLastName(),
                information.getAddress(), information.getPhone())).toList();
    }

    public InformationDto findById(Integer usersId) {
        Information information = informationDao.findById(usersId).orElse(new Information());
        return new InformationDto(information.getUsersId(), information.getFirstName(), information.getSecondName(),
                information.getLastName(), information.getAddress(), information.getPhone());
    }
}
