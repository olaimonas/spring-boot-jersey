package spring.boot.jersey.service;

import org.springframework.stereotype.Service;
import spring.boot.jersey.rest.model.Cat;
import spring.boot.jersey.rest.model.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("catService")
public class CatServiceImpl implements CatService {

    private Map<Long, Cat> cats = new HashMap<>();

    public CatServiceImpl() {
        Cat micius = new Cat(777L);
        Cat katt = new Cat(747L);
        micius.setAge(10);
        micius.setName("Micius (default)");
        katt.setAge(12);
        katt.setName("Katt (default)");
        cats.put(micius.getId(), micius);
        cats.put(katt.getId(), katt);
    }

    @Override
    public Cat getCat(Long id) {
        return cats.getOrDefault(id, null);
    }

    @Override
    public void saveCat(CatRequest request) {
        if (cats.containsKey(request.getId())) {
            throw new IllegalArgumentException();
        }
        Cat cat = new Cat(request.getId());
        cat.setAge(request.getAge());
        cat.setName(request.getName());
        cats.put(cat.getId(), cat);
    }

    @Override
    public void updateCat(CatRequest request) {
        if (cats.containsKey(request.getId())) {
            getCat(request.getId()).setAge(request.getAge());
            getCat(request.getId()).setName(request.getName());
        }
    }

    @Override
    public List<Cat> getAllCats(PageRequest pageRequest) {

        List<Cat> filteredCats = cats.values().stream().skip(pageRequest.getOffset()).limit(pageRequest.getSize()).collect(Collectors.toList());

        return filteredCats;
    }
}
