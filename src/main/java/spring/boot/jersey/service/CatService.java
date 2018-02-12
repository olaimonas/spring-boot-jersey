package spring.boot.jersey.service;

import spring.boot.jersey.rest.model.Cat;
import spring.boot.jersey.rest.model.PageRequest;

import java.util.List;

public interface CatService {

    Cat getCat(Long Id);

    void saveCat(CatRequest request);

    void updateCat(CatRequest request);

    List<Cat> getAllCats(PageRequest pageRequest);
}
