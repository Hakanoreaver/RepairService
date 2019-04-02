package com.CSCS314.RepairService;

import com.CSCS314.RepairService.Repositories.AdminRepository;
import com.CSCS314.RepairService.Repositories.CustomersRepository;
import com.CSCS314.RepairService.Repositories.Objects.Admin;
import com.CSCS314.RepairService.Repositories.ProfessionalRepository;
import com.CSCS314.RepairService.Repositories.Objects.Customers;
import com.CSCS314.RepairService.Repositories.Objects.Professionals;
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
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private AdminRepository adminRepository;

    /**
     * This is the test to see if the backend is live.
     * @return
     */
    @GetMapping(path = "/isServerRunning")
    public @ResponseBody
    boolean sendTest() {
        return true;
    }

    /**
     * Post Mapping to log a user into the system
     * @param email
     * @param password
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "user/logIn/{email}/{password}")
    public @ResponseBody
    String logInUser(@PathVariable String email, @PathVariable String password) {
            Customers cust = customerRepository.findByEmail(email);
            if(cust == null) {
                return "Username or Password not found";
            }
            if(cust.getPasswordToken().equals(password)) {
                return Integer.toString(cust.getCustomerId());
            }
            return "Username or Password not found";
    }

    /**
     * Post Mapping to log a professional into the system
     * @param email
     * @param password
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professional/logIn/{email}/{password}")
    public @ResponseBody
    String logInProfessional(@PathVariable String email, @PathVariable String password) {
            Professionals prof = professionalRepository.findByEmail(email);
            if(prof == null) {
                return "Username or Password not found";
            }
            if(prof.getPasswordToken().equals(password)) {
                return Integer.toString(prof.getProfessionalId());
            }
            return "Username or Password not found";
    }

    /**
     * Post Mapping to log an admin into the system
     * @param adminId
     * @param password
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "admin/logIn/{adminId}/{password}")
    public @ResponseBody
    String logInAdmin(@PathVariable int adminId, @PathVariable String password) {
        Admin admin = adminRepository.findById(adminId);
        if(admin == null) {
            return "Username or Password not found";
        }
        if(admin.getPasswordToken().equals(password)) {
            return "Logged In";
        }
        return "Username or Password not found";
    }

    /**
     * Get mapping to find a user by ID.
     * @param userId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "user/find/{userId}")
    public @ResponseBody
    Customers findCustomer(@PathVariable int userId) {
        Customers cust = customerRepository.findById(userId);
        return cust;
    }

    /**
     * Get mapping to find a professional by ID.
     * @param professionalId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professional/find/{professionalId}")
    public @ResponseBody
    Professionals findProfessional(@PathVariable int professionalId) {
        Professionals prof = professionalRepository.findById(professionalId);
        return prof;
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professional/create")
    public @ResponseBody
    void createProfessional(String email, String name, String services, String bankToken, String mobileNumber, String passwordToken, String ABN, String certificationNumber, double priceVariance) {
        Professionals p = new Professionals();
        p.setABN(ABN);
        p.setBankToken(bankToken);
        p.setEmail(email);
        p.setName(name);
        p.setServices(services);
        p.setMobileNumber(mobileNumber);
        p.setPasswordToken(passwordToken);
        p.setCertificationNumber(certificationNumber);
        p.setPriceVariance(priceVariance);
        professionalRepository.save(p);
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professional/create")
    public @ResponseBody
    void createCustomer(String name, String cardAuthToken, String vehicles, String email, String mobileNumber, String passwordToken) {
        Customers c = new Customers();
        c.setName(name);
        c.setCardAuthToken(cardAuthToken);
        c.setVehicles(vehicles);
        c.setEmail(email);
        c.setMobileNumber(mobileNumber);
        c.setPasswordToken(passwordToken);
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "admin/create")
    public @ResponseBody
    void createAdmin(String passwordToken) {
        Admin a = new Admin();
        a.setPasswordToken(passwordToken);
    }
}