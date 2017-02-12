package com.theironyard;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Created by michaelmernin on 2/12/17.
 */
@RestController
public class Controller {

    @Autowired
    LecturersRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    Server uidb = null;


    @PostConstruct
    public void init() throws SQLException {
        uidb = Server.createWebServer().start();
    }

    @PreDestroy
    public void destroy(){
        uidb.stop();
    }

    @RequestMapping(path = "/lectures", method = RequestMethod.GET)
    public Iterable<Lecturers> getLecturers () {
        return lecturers.findAll();
    }
    @RequestMapping(path = "/lectures", method = RequestMethod.POST)
    public void createLecturer (String name, String topic, String image, HttpServletResponse response) {

        Lecturers lecturer = new Lecturers(name, topic, image);
        lecturers.save(lecturer);
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> getReviews (int lecturerId) {
        Lecturers lecturer = lecturers.findOne(lecturerId);
        return reviews.findByLecturer(lecturer);
    }
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReview (String author, String text, boolean isGood,int lectureId, HttpServletResponse response) {
        Lecturers lecturer = lecturers.findOne(lectureId);
        Review review = new Review(author, text, isGood, lecturer);
        reviews.save(review);





    }

}
