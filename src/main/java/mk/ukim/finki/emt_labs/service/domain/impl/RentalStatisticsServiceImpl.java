//package mk.ukim.finki.emt_labs.service.domain.impl;
//
//import mk.ukim.finki.emt_labs.model.dto.rentalDto.RentalStatisticsDto;
//import mk.ukim.finki.emt_labs.service.domain.old.RentalStatisticsService;
//import org.springframework.stereotype.Service;
//import mk.ukim.finki.emt_labs.model.domain.Rental;
//import mk.ukim.finki.emt_labs.repository.RentalRepository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Service
//public class RentalStatisticsServiceImpl implements RentalStatisticsService {
//    private final RentalRepository rentalRepository;
//
//    public RentalStatisticsServiceImpl(RentalRepository rentalRepository) {
//        this.rentalRepository = rentalRepository;
//    }
//
//    @Override
//    public RentalStatisticsDto getRentalStatistics() {
//        List<Rental> rentals = rentalRepository.findAll();
//
//        String mostRentedBook = rentals.stream()
//                .collect(Collectors.groupingBy(r -> r.getBook().getName(), Collectors.counting()))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse("No rentals");
//
//        double avgRentalsPerUser = rentals.size() /
//                (double) rentals.stream().map(r -> r.getUser().getName()).distinct().count();
//
//        Map<String, Long> rentalsPerAuthor = rentals.stream()
//                .collect(Collectors.groupingBy(r -> r.getBook().getAuthor().getName(), Collectors.counting()));
//
//        return new RentalStatisticsDto(mostRentedBook, avgRentalsPerUser, rentalsPerAuthor);
//    }
//}
//
