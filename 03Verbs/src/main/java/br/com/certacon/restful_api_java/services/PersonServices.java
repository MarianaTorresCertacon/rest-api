package br.com.certacon.restful_api_java.services;

import br.com.certacon.restful_api_java.exceptions.ResourceNotFoundException;
import br.com.certacon.restful_api_java.model.Person;
import br.com.certacon.restful_api_java.repositories.PersonRepository;
import br.com.certacon.restful_api_java.vo.v1.ModelMapperUtils;
import br.com.certacon.restful_api_java.vo.v1.PersonVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Finding all people");

        List<PersonVO> result = ModelMapperUtils.mapList(repository.findAll(), PersonVO.class);
        return result;
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person");
        ModelMapper modelMapper = new ModelMapper();
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        PersonVO personVO = modelMapper.map(entity, PersonVO.class);
        return personVO;
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");
        ModelMapper modelMapper = new ModelMapper();
        var entity = modelMapper.map(person, Person.class);
        var vo = modelMapper.map(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Creating one person");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        ModelMapper modelMapper = new ModelMapper();
        var vo = modelMapper.map(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        repository.delete(entity);
    }
}