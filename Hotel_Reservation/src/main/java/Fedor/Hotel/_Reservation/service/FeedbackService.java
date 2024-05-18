package Fedor.Hotel._Reservation.service;

import Fedor.Hotel._Reservation.Dto.FeedbackDto;
import Fedor.Hotel._Reservation.entity.Feedback;
import Fedor.Hotel._Reservation.entity.Hotel;
import Fedor.Hotel._Reservation.entity.UserInfo;
import Fedor.Hotel._Reservation.repository.FeedbackRepository;
import Fedor.Hotel._Reservation.repository.HotelRepository;
import Fedor.Hotel._Reservation.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private HotelRepository hotelRepository;
    public Feedback addFeedback(FeedbackDto feedbackDto){
        UserInfo userInfo=userInfoRepository.getReferenceById(feedbackDto.getUserId());
        Hotel hotel=hotelRepository.getReferenceById(feedbackDto.getHotelId());
        if(hotel==null || userInfo==null){
            return null;
        }
        Feedback feedback=new Feedback();
        feedback.setUser(userInfo);
        feedback.setHotel(hotel);
        feedback.setComment(feedbackDto.getComment());
        feedback.setDate(feedbackDto.getDate());
        feedbackRepository.save(feedback);
        return feedback;
    }

}
