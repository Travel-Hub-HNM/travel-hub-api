package com.travelhub.travelhub_api.controller.review.request;

import com.travelhub.travelhub_api.data.dto.auth.LoginUserDTO;
import com.travelhub.travelhub_api.data.enums.ImageType;
import com.travelhub.travelhub_api.data.mysql.entity.ImageEntity;
import com.travelhub.travelhub_api.data.mysql.entity.ReviewEntity;
import lombok.NonNull;

import java.util.List;

public record ReviewCreateRequest(
        @NonNull
        String rvText,

        @NonNull
        Long ctIdx,

        Long igIdx,

        @NonNull
        Double rvScore,

        List<String> igPath
) {
    public ReviewEntity ofReview() {
        String usId = LoginUserDTO.get();

        return ReviewEntity.builder()
                .rvText(this.rvText)
                .usId(usId)
                .rvScore(rvScore)
                .ctIdx(this.ctIdx)
                .build();
    }

    public ImageEntity ofImage(Long rvIdx) {
        return ImageEntity.builder()
                .idx(rvIdx)
                .igType(ImageType.RV)
                .igPath(concatIgPath())
                .build();
    }

    public String concatIgPath() {
        return String.join(",", igPath);
    }
}
