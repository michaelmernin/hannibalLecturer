package com.theironyard;

import javax.persistence.*;

/**
 * Created by michaelmernin on 2/12/17.
 */

@Entity
@Table(name = "lecturers")
public class Lecturers {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String topic;

    @Column(nullable = false)
    String image;




}
