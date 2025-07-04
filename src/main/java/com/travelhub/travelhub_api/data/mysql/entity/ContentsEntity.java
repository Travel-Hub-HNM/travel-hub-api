package com.travelhub.travelhub_api.data.mysql.entity;

import com.travelhub.travelhub_api.data.dto.contents.ContentsDto;
import com.travelhub.travelhub_api.data.mysql.entity.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contents")
public class ContentsEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_idx")
    private Long ctIdx;

    @Column(name = "ct_title", nullable = false)
    private String ctTitle;

    @Column(name = "ct_score")
    private Double ctScore;

    @Column(name = "ct_view_count", nullable = false)
    private Long ctViewCount;

    @Column(name = "us_id", nullable = false)
    private String usId;

    public void updateTitle(String title) {
        this.ctTitle = title;
    }

    public void updateScore(Double score) {
        this.ctScore = score;
    }

    public ContentsDto ofContents() {
        this.ctViewCount++;

        return ContentsDto.builder()
                .ctIdx(this.ctIdx)
                .ctTitle(this.ctTitle)
                .ctScore(this.ctScore)
                .ctViewCount(this.ctViewCount)
                .insertTime(this.getInsertTime())
                .updateTime(this.getUpdateTime())
                .build();
    }
}
