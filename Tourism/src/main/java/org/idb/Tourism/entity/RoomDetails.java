package org.idb.Tourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rid;

    @Column(length = 15)
    private int rsingletype;

    @Column(length = 15)
    private int rdoubletype;

    @Column(length = 30)
    private double rsingleprice;

    @Column(length = 30)
    private double rdoubleprice;
}
