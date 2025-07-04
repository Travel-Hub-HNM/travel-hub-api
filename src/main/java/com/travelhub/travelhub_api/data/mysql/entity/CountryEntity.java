package com.travelhub.travelhub_api.data.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cnt_idx")
    private Long cntIdx;

    @Column(name = "cnt_code")
    private String cntCode;

    @Column(name = "cnt_name")
    private String cntName;

    @Column(name = "cnt_low_lat")
    private Double cntLowLat;

    @Column(name = "cnt_low_lng")
    private Double cntLowLng;

    @Column(name = "cnt_high_lat")
    private Double cntHighLat;

    @Column(name = "cnt_high_lng")
    private Double cntHighLng;
}
