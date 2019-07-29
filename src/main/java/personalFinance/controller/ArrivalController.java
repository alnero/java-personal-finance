package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.Arrival;
import personalFinance.model.User;
import personalFinance.repository.ArrivalRepository;
import personalFinance.repository.UserRepository;
import personalFinance.utils.ArrivalDTO;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/arrivals")
public class ArrivalController {
    private UserRepository userRepository;
    private ArrivalRepository arrivalRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ArrivalController(UserRepository userRepository, ArrivalRepository arrivalRepository) {
        this.userRepository = userRepository;
        this.arrivalRepository = arrivalRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Arrival> getAllArrivals() {
        List<Arrival> arrivals = this.arrivalRepository.findAll();
        return arrivals;
    }

    @ResponseBody
    @PutMapping
    public Arrival updateArrivalByUserId(@RequestBody ArrivalDTO arrivalDTO) {
        Arrival arrival = this.arrivalRepository.findArrivalByUserId(arrivalDTO.getUserId());
        this.modelMapper.map(arrivalDTO, arrival);
        return arrival;
    }

    @ResponseBody
    @DeleteMapping
    public void deleteArrivalByUserId(@RequestBody ArrivalDTO arrivalDTO) {
        this.arrivalRepository.deleteByUserId(arrivalDTO.getUserId());
    }

    @ResponseBody
    @PostMapping
    public Arrival createArrival(@RequestBody ArrivalDTO arrivalDTO) {
        User user = this.userRepository.findUserById(arrivalDTO.getUserId());
        BigDecimal amount = arrivalDTO.getAmount();
        Arrival arrival = new Arrival(user, amount);
        arrival = this.arrivalRepository.save(arrival);
        return arrival;
    }
}
