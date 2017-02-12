package com.theironyard;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;

/**
 * Created by michaelmernin on 2/12/17.
 */

@Entity
@Table(name ="reviews")
public class Review {

    @Id
    @GeneratedValue
    int id;

    @Column
    String author;

    @Column
    String text;

    @ManyToOne
    Lecturers lecturer;

    @Column
    boolean isGood;
}
