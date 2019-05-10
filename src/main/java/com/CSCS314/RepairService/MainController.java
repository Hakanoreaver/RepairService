package com.CSCS314.RepairService;

import com.CSCS314.RepairService.Repositories.*;
import com.CSCS314.RepairService.Repositories.Objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private StandbyRepository standbyRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

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

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "vehicles/{userId}")
    public @ResponseBody
    List<Vehicles> logInUser(@PathVariable int userId) {
        return vehicleRepository.findById(userId);
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "addVehicle/{userId}/{number}/{make}/{year}")
    public @ResponseBody
    String logInUser(@PathVariable int userId, @PathVariable String number, @PathVariable String make, @PathVariable int year) {
        Vehicles v = new Vehicles();
        v.setUserId(userId);
        v.setMakeModel(make);
        v.setNumberPlate(number);
        v.setYear(year);
        vehicleRepository.save(v);
        return "Vehicle Succesfully Added";
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
    void createProfessional(String email, String name, String bankToken, String mobileNumber, String passwordToken, String ABN, String certificationNumber, double priceVariance) {
        Professionals p = new Professionals();
        p.setABN(ABN);
        p.setBankToken(bankToken);
        p.setEmail(email);
        p.setName(name);
        p.setMobileNumber(mobileNumber);
        p.setPasswordToken(passwordToken);
        p.setCertificationNumber(certificationNumber);
        p.setPriceVariance(priceVariance);
        professionalRepository.save(p);
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "user/create")
    public @ResponseBody
    boolean createCustomer(String name, String cardAuthToken, String email, String mobileNumber, String passwordToken) {
        Customers c = new Customers();
        c.setName(name);
        c.setCardAuthToken(cardAuthToken);
        c.setEmail(email);
        c.setMobileNumber(mobileNumber);
        c.setPasswordToken(passwordToken);
        customerRepository.save(c);
        return true;
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "admin/create")
    public @ResponseBody
    void createAdmin(String passwordToken) {
        Admin a = new Admin();
        a.setPasswordToken(passwordToken);
    }

    /**
     * http://localhost:9090/main/request/start?customerId=1&longitude=0&latitude=0&vehicleId=0&issue=0
     * @param customerId
     * @param longitude
     * @param latitude
     * @param vehicleId
     * @param issue
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "request/start")
    public @ResponseBody
    void startRequest(int customerId, Double longitude, Double latitude, int vehicleId, int issue) {
        Iterable<Professionals> profs = professionalRepository.findAll();
        Requests r = new Requests();
        r.setCustomerId(customerId);
        r.setVehicleId(vehicleId);
        int max;
        try {
            max = requestRepository.findMax() + 1;
        }
        catch (Exception e) {
            max = 1;
        }
        r.setRequestId(max);
        requestRepository.save(r);
        StandbyRequests standby = new StandbyRequests(r);
        System.out.println(r.getRequestId());
        System.out.println(requestRepository.findMax());
        standbyRepository.save(standby);
        System.out.println(standby.getRequestId());

        for(Professionals p : profs) {
            if(distance(longitude, latitude, p.getLongitude(), p.getLatitude(), 0, 0) < 4000) {
                p.setPossibleRequests(p.getPossibleRequests() + Integer.toString(r.getRequestId()) + ',');
            }
        }

    }

    /**
     * @param professionalId
     * @param longitude
     * @param latitude
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professionals/requests/check")
    public @ResponseBody
    ArrayList<Requests> checkRequests(int professionalId, double longitude, double latitude) {
        Professionals p = professionalRepository.findById(professionalId);
        p.setLongitude(longitude);
        p.setLatitude(latitude);
        ArrayList<Requests> returns = new ArrayList<>();
        for(String s : p.getPossibleRequests().split(",")) {
            int id = Integer.parseInt(s);
            Requests temp = requestRepository.findById(id);
            returns.add(temp);
        }
        return returns;
    }

    /**
     * http://localhost:9090/main/professionals/requests/select/1/1
     * @param professionalId
     * @param requestId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professionals/requests/select/{professionalId}/{requestId}")
    public @ResponseBody
    boolean selectRequest(@PathVariable int professionalId, @PathVariable int requestId) {
        professionalRepository.updateRequest(requestId, professionalId);

        //r.setAccepted(true);
        long secondsSinceEpoch =  System.currentTimeMillis();
        standbyRepository.updateDuration(secondsSinceEpoch, requestId);
        return true;
    }

    /**
     * http://localhost:9090/main/professionals/requests/complete/1
     * @param professionalId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professionals/requests/complete/{professionalId}")
    public @ResponseBody
    boolean completeRequest(@PathVariable int professionalId) {
        Professionals p = professionalRepository.findById(professionalId);
        StandbyRequests r = standbyRepository.findById(p.getRequestId());
        long secondsSinceEpoch =  System.currentTimeMillis();
        r.setDuration(secondsSinceEpoch - r.getDuration());
        r.setFinished(true);
        Requests temp = new Requests(r);
        requestRepository.deleteById(temp.getRequestId());
        requestRepository.save(temp);
        standbyRepository.deleteById(r.getRequestId());
        return true;
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "customer/requests/status/{requestId}")
    public @ResponseBody
    boolean getRequestStatus(@PathVariable int requestId) {
        return requestRepository.findById(requestId).isAccepted();
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "customer/all")
    public @ResponseBody
    Iterable<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "customer/all")
    public @ResponseBody
    Iterable<Professionals> getProfessionals() {
        return professionalRepository.findAll();
    }





    /**
     * https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
                                  double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }



}