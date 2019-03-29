package com.CSCS314.RepairService;

import com.CSCS314.RepairService.Repositories.CustomersRepository;
import com.CSCS314.RepairService.Repositories.Objects.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.validation.constraints.Null;


@Controller // This means that this class is a Controller
@CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(path="/main")  // This means URL's start with /main (after Application path)
public class MainController {

    @Autowired
    private CustomersRepository customerRepository;

    /**
     * This is the test to see if the backend is live.
     * @return
     */
    @GetMapping(path = "/isServerRunning")
    public @ResponseBody
    boolean sendTest() {
        return true;
    }
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/logIn/{email}/{password}")
    public @ResponseBody
    String logIn(@PathVariable String email, @PathVariable String password) {
        Customers cust = customerRepository.findByUsername(email);
        if(cust == null) {
            return "Username or Password not found";
        }
        if(cust.getPasswordToken().equals(password)) {
            return "Logged In";
        }
        return "Username or Password not found";
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "/logIn/{userId}/{problem}")
    public @ResponseBody
    boolean makeRequest(@PathVariable int userId, @PathVariable String problem) {
        Customers cust = customerRepository.findById(userId);
        return true;
    }
}