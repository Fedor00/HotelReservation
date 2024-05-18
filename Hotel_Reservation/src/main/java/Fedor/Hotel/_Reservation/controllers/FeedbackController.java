package Fedor.Hotel._Reservation.controllers;

import Fedor.Hotel._Reservation.Dto.FeedbackDto;
import Fedor.Hotel._Reservation.entity.Feedback;
import Fedor.Hotel._Reservation.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/add")
    public ResponseEntity<Feedback>  addFeedback(@RequestBody FeedbackDto feedbackDto){
        System.out.println(feedbackDto);
        return ResponseEntity.ok(feedbackService.addFeedback(feedbackDto));
    }

}
