package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int hid;

    @Column(length = 60, nullable = false)
    private String hname;

    @Column(length = 30, nullable = false)
    private String hcountry;

    @Column(length = 255, nullable = false)
    private String hlocation;

    @Column(length = 60, nullable = false)

    private String hemail;

    @Column(length = 64, nullable = false)
    private String hpassword;

    @Column(length = 15, nullable = false)
    private String hphone;

    private String hphoto;


    @ManyToOne
    @JoinColumn(name = "rid_fk")
    RoomDetails roomDetails;





}
