package com.theironyard;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by michaelmernin on 2/12/17.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {

    List<Review> findByLecturer(Lecturers lecturer);
}
