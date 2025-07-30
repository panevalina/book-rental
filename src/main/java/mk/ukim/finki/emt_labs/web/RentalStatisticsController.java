//package mk.ukim.finki.emt_labs.web;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import mk.ukim.finki.emt_labs.model.dto.rentalDto.RentalStatisticsDto;
//import mk.ukim.finki.emt_labs.service.application.old.RentalStatisticsApplicationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/rental-statistics")
//@Tag(name = "Rental Statistics API", description = "Endpoints for book rental statistics")
//public class RentalStatisticsController {
//
//    private final RentalStatisticsApplicationService rentalStatisticsApplicationService;
//
//    public RentalStatisticsController(RentalStatisticsApplicationService rentalStatisticsApplicationService) {
//        this.rentalStatisticsApplicationService = rentalStatisticsApplicationService;
//    }
//
//    @Operation(summary = "Get rental statistics", description = "Fetches statistics about book rentals")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Statistics retrieved successfully")
//    })
//    @GetMapping
//    public ResponseEntity<RentalStatisticsDto> getRentalStatistics() {
//        return ResponseEntity.ok(rentalStatisticsApplicationService.getRentalStatistics());
//    }
//}
//
