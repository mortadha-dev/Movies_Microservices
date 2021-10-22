package tun.dev.ratingsdataservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/ratingmovies")
public class RatingController {

    @RequestMapping("/userrating/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        /// userRating.initData(userId)
        userRating.setRatings(Arrays.asList(
                new Rating("1", 1),
                new Rating("2", 2),
                new Rating("3", 3)
        ));
        userRating.setUserId(userId);
        return userRating;
    }

}
