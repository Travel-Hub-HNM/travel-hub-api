package com.travelhub.travelhub_api.controller.review;

import com.travelhub.travelhub_api.controller.review.request.ReviewCreateRequest;
import com.travelhub.travelhub_api.controller.review.response.ReviewListResponse;
import com.travelhub.travelhub_api.data.dto.auth.LoginUserDTO;
import com.travelhub.travelhub_api.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.travelhub.travelhub_api.common.resource.TravelHubResource.*;

@RestController
@RequestMapping(API_V1_REVIEW)
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * 리뷰 목록 조회
     * GET /travel/v1/review/list
     */
    @GetMapping(LIST)
    public List<ReviewListResponse> findReviews(Long ctIdx) {
        return reviewService.findReviews(ctIdx);
    }

    /**
     * 사용자 리뷰 목록 조회
     * GET /travel/v1/review/list-user
     */
    @GetMapping(LIST_USER)
    public List<ReviewListResponse> findReviewsByUser() {
        String uId = LoginUserDTO.get();
        return reviewService.findReviewsUser(uId);
    }

    /**
     * 리뷰 작성
     * POST /travel/v1/review
     * @param request request body
     */
    @PostMapping
    public void createReview(@RequestBody ReviewCreateRequest request) {
        reviewService.createReview(request);
    }

    /**
     * 리뷰 업데이트
     * PUT /travel/v1/review
     */
    @PutMapping
    public void updateReview(@RequestParam Long rvIdx, @RequestBody ReviewCreateRequest request){
        reviewService.updateReview(rvIdx, request);
    }

    /**
     * 리뷰 삭제
     * DELETE /travel/v1/review
     * @param rvIdx 리뷰 idx
     */
    @DeleteMapping
    public void deleteReview(@RequestParam Long rvIdx) {
        reviewService.deleteReview(rvIdx);
    }
}
