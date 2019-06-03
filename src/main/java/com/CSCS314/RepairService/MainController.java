package com.CSCS314.RepairService;

import com.CSCS314.RepairService.Models.*;
import com.CSCS314.RepairService.Repositories.*;
import com.CSCS314.RepairService.Repositories.Objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This is the main controller that handles all API endpoints
 */
@Controller // This means that this class is a Controller
@CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(path="/main")  // This means URL's start with /main (after Application path)
public class MainController {

    //Declaration of all of our repositories
    @Autowired
    private CustomersRepository customerRepository;
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private ReviewRepository reviewRepository;

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
     * This returns all vehicles for a user
     * @param userId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "vehicles/{userId}")
    public @ResponseBody
    List<Vehicles> logInUser(@PathVariable int userId) {
        return vehicleRepository.findByUserId(userId);
    }

    /**
     * This adds a vehicle for a user
     * @param userId
     * @param number
     * @param make
     * @param year
     * @return
     */
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

    /**
     * This is an endpoint for a user to lodge a review
     * @param requestId
     * @param review
     * @param rating
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "review/lodge/{requestId}/{review}/{rating}")
    public @ResponseBody
    void lodgeReview(@PathVariable int requestId, @PathVariable String review, @PathVariable double rating) {
        Requests temp = requestRepository.findById(requestId);
        int professionalId = temp.getProfessionalId();
        double total = 0;
        double amount = 0;
        Reviews rev = new Reviews();
        rev.setCustomerId(temp.getCustomerId());
        rev.setProfessionalId(temp.getProfessionalId());
        rev.setRating(rating);
        rev.setTextString(review);
        reviewRepository.save(rev);
        for(Reviews r : reviewRepository.findById(professionalId)) {
            total += r.getRating();
            amount += 1;
        }
        professionalRepository.updateRating(total/amount, professionalId);

    }

    /**
     * This is an API to create a new professional
     * @param email
     * @param name
     * @param bankToken
     * @param mobileNumber
     * @param passwordToken
     * @param ABN
     * @param certificationNumber
     * @param priceVariance
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "professional/create")
    public @ResponseBody
    boolean createProfessional(String email, String name, String bankToken, String mobileNumber, String passwordToken, String ABN, String certificationNumber, double priceVariance) {
        Professionals check = professionalRepository.findByEmail(email);
        if(check == null) {
            return false;
        }
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
        return true;
    }

    /**
     * This is an API to create a new User
     * @param name
     * @param cardAuthToken
     * @param email
     * @param mobileNumber
     * @param passwordToken
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "user/create")
    public @ResponseBody
    boolean createCustomer(String name, String cardAuthToken, String email, String mobileNumber, String passwordToken) {
        Customers check = customerRepository.findByEmail(email);
        if(check != null) {
            return false;
        }
        Customers c = new Customers();
        c.setName(name);
        c.setCardAuthToken(cardAuthToken);
        c.setEmail(email);
        c.setMobileNumber(mobileNumber);
        c.setPasswordToken(passwordToken);
        customerRepository.save(c);
        return true;
    }

    /**
     * This is an api to create a new Admin
     * @param passwordToken
     */
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
    int startRequest(int customerId, Double longitude, Double latitude, int vehicleId, int issue) {
        Requests r = new Requests();
        r.setCustomerId(customerId);
        r.setVehicleId(vehicleId);
        r.setLatitude(latitude);
        r.setProblem(issue);
        r.setLongitude(longitude);
        r.setAccepted(false);
        int max;
        try {
            max = requestRepository.findMax() + 1;
        }
        catch (Exception e) {
            max = 1;
        }
        r.setRequestId(max);
        requestRepository.save(r);
        return r.getRequestId();
    }

    /**
     * Function to get professionals that have accepted an offer
     * @param requestId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "request/checkOffers/{requestId}")
    public @ResponseBody
    List<Professionals> startRequest(@PathVariable int requestId) {
        ArrayList<Professionals> temp = new ArrayList<>();
        try {
            String profs = requestRepository.findById(requestId).getProfessionalIds();
            for (String s : profs.split(",")) {
                temp.add(professionalRepository.findById(Integer.parseInt(s)));
            }
            return temp;
        }
        catch (Exception e) {
            return temp;
        }
    }

    /**
     * This is an api for professionals to check nearby requests
     * @param professionalId id of a professional
     * @param longitude longitude
     * @param latitude latitude
     * @return return a list of requestreturns to the professional
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionals/requests/check")
    public @ResponseBody
    ArrayList<RequestReturnProfessional> checkRequests(int professionalId, double longitude, double latitude) {
        Professionals p = professionalRepository.findById(professionalId);
        p.setLongitude(longitude);
        p.setLatitude(latitude);
        ArrayList<RequestReturnProfessional> returns = new ArrayList<>();
        for(Requests r : requestRepository.findAll()) {
            double distance = distance(longitude, latitude, p.getLongitude(), p.getLatitude(), 0, 0);
            System.out.println("Distance is " + distance);
            if(distance < 4000 && !r.isAccepted()) {
                RequestReturnProfessional temp = new RequestReturnProfessional();
                temp.setDistance(distance);
                Services s = serviceRepository.findById(r.getProblem());
                temp.setIssue(s.getName());
                Vehicles v = vehicleRepository.findById(r.getVehicleId());
                temp.setVd(v.getMakeModel() + " " + v.getYear() + " " + v.getNumberPlate());
                temp.setCost(s.getCost() * (p.getPriceVariance() + 1));
                temp.setId(r.getRequestId());
                returns.add(temp);
            }
        }
        return returns;
    }

    /**
     * This is an api for a professional to select a request.
     * http://localhost:9090/main/professionals/requests/select/1/1
     * @param professionalId id of a professional
     * @param requestId id of a request
     * @return return true if the operation successfuly completed
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionals/requests/select/{professionalId}/{requestId}")
    public @ResponseBody
    boolean selectRequest(@PathVariable int professionalId, @PathVariable int requestId) {
        String temp = requestRepository.findById(requestId).getProfessionalIds();
        if(temp == null) {
            temp = Integer.toString(professionalId);
        }
        else {
            temp += "," + professionalId;
        }
        requestRepository.updateProfessionals(requestId, temp);
        return true;
    }

    /**
     * This is an api for a professional to complete a request
     * http://localhost:9090/main/professionals/requests/complete/1
     * @param professionalId id of a professional
     * @return return true once the operation is completed
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionals/requests/complete/{professionalId}")
    public @ResponseBody
    boolean completeRequest(@PathVariable int professionalId) {
        Transactions t = new Transactions();

        Professionals p = professionalRepository.findById(professionalId);
        Requests r = requestRepository.findById(p.getRequestId());
        Services s = serviceRepository.findById(r.getProblem());
        double amount = s.getCost() * (p.getPriceVariance() + 1) - 10;
        t.setAmount(amount);
        balanceRepository.updateBalance(balanceRepository.getBalance() - amount);
        t.setRequestId(p.getRequestId());
        t.setStatus("Payment from us to professional");
        t.setDate(new Date(System.currentTimeMillis()));
        transactionRepository.save(t);
        long secondsSinceEpoch =  System.currentTimeMillis();
        long duration = secondsSinceEpoch - requestRepository.findById(p.getRequestId()).getDuration();
        requestRepository.updateDuration(duration, p.getRequestId());
        requestRepository.updateFinished(true, p.getRequestId());
        return true;
    }

    /**
     * This is an API for professionals to check if the request they selected was accepted
     * @param professionalId id of a professional
     * @param requestId id of a request
     * @return returns an int from -1 , 0 , 1
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionals/requests/checkIfAccepted/{professionalId}/{requestId}")
    public @ResponseBody
    int checkIfAcceptedProfessional(@PathVariable int professionalId, @PathVariable int requestId) {
        Requests r = requestRepository.findById(requestId);
        System.out.println(r.isAccepted() + " " + requestId);
        if(!r.isAccepted()) return 0;
        else if(r.getProfessionalId() != professionalId) return -1;
        else return 1;
    }

    /**
     * This is an API for a customer to select a profesional to perform the job for them.
     * @param professionalId
     * @param requestId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "customer/requests/select/{professionalId}/{requestId}")
    public @ResponseBody
    boolean selectProfessional(@PathVariable int professionalId,@PathVariable int requestId) {
        Requests r = requestRepository.findById(requestId);
        Customers c = customerRepository.findById(r.getCustomerId());
        double amount;
        if(c.getCustomerType()) {
            amount = 30;
        }
        else {
            Transactions t = new Transactions();
            Professionals p = professionalRepository.findById(professionalId);
            Services s = serviceRepository.findById(r.getProblem());
            amount = s.getCost() * (p.getPriceVariance() + 1);
        }
        Transactions t = new Transactions();
        t.setAmount(amount);
        t.setRequestId(requestId);
        t.setStatus("Payment from customer to us");
        t.setDate(new Date(System.currentTimeMillis()));
        balanceRepository.updateBalance(balanceRepository.getBalance() + amount);
        transactionRepository.save(t);
        professionalRepository.updateRequest(requestId, professionalId);
        requestRepository.updateProfessional(professionalId, requestId);
        requestRepository.updateDuration(System.currentTimeMillis(), requestId);
        requestRepository.updateAccepted(true, requestId);
        return true;
    }

    /**
     * This is an API for customers to check if the request has been completed
     * @param requestId
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @PostMapping(path = "customer/requests/status/{requestId}")
    public @ResponseBody
    boolean getRequestStatus(@PathVariable int requestId) {
        System.out.println(requestRepository.findById(requestId).isFinished());
        return requestRepository.findById(requestId).isFinished();
    }

    /**
     * This is an API to return all customers
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "customer/all")
    public @ResponseBody
    Iterable<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * This is an api to return all professionals
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionals/all")
    public @ResponseBody
    Iterable<Professionals> getProfessionals() {
        return professionalRepository.findAll();
    }

    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "vehicles/all")
    public @ResponseBody
    Iterable<Vehicles> getVehicles() {
        return vehicleRepository.findAll();
    }

    /**
     * This is an api to return all services
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "services/all")
    public @ResponseBody
    Iterable<Services> getServices() {
        return serviceRepository.findAll();
    }

    /**
     * This is an API to return all requests
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "requests/all")
    public @ResponseBody
    Iterable<Requests> getRequests() {
        return requestRepository.findAll();
    }

    /**
     * This is an API to return all transactions
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "transactions/all")
    public @ResponseBody
    Iterable<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    /**
     * This is an api to return the balance
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "balance")
    public @ResponseBody
    double getBalance() {
        return balanceRepository.getBalance();
    }

    /**
     * This is an API to return a takins report between two dates
     * @param sd
     * @param ed
     * @return
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "takingsReport/{sd}/{ed}")
    public @ResponseBody
    TakingsRequest takingsReport(@PathVariable String sd, @PathVariable String ed) {
        TakingsRequest tr = new TakingsRequest();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date startDate = sdf.parse(sd);
            java.util.Date endDate = sdf.parse(ed);
            Date startDatee = new Date(startDate.getTime());
            Date endDatee = new Date(endDate.getTime());
            HalfModel incoming = transactionRepository.calcBetweenDates("Payment from customer to us", startDatee, endDatee);
            HalfModel outgoing = transactionRepository.calcBetweenDates("Payment from us to professional", startDatee, endDatee);
            tr.setAverageIncoming(incoming.getAverage());
            tr.setAverageOutgoing(outgoing.getAverage());
            tr.setHighestIncoming(incoming.getHighest());
            tr.setHighestOutgoing(outgoing.getHighest());
            tr.setLowestIncoming(incoming.getLowest());
            tr.setLowestOutgoing(outgoing.getLowest());
            tr.setTotalIncoming(incoming.getTotal());
            tr.setTotalOutgoing(outgoing.getTotal());
            tr.setProfit(incoming.getTotal() - outgoing.getTotal());
        }
        catch (Exception e) {

        }
        System.out.println();


        return tr;
    }

    /**
     * This is an api to return a customer report
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "customerReport")
    public @ResponseBody
    CustomerRequest customerReport() {
        CustomerRequest c = new CustomerRequest();
        int total = requestRepository.getAmounts();
        int totalC = customerRepository.findTotal();
        c.setNumCustomers(totalC);
        c.setAverageNumRequests(total/totalC);
        int loyalty = customerRepository.findTotalLoyalty();
        c.setNumLoyaltyCustomers(loyalty);
        c.setNumNotLoyaltyCustomers(totalC - loyalty);
        c.setAverageSpent(transactionRepository.getTotal("Payment from customer to us") / totalC);
        return c;

    }

    /**
     * This is an API to return a professional report.
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professionalReport")
    public @ResponseBody
    ProfessionalRequest professionalReport() {
        ProfessionalRequest pr = new ProfessionalRequest();
        int total = requestRepository.getAmounts();
        int totalP = professionalRepository.findTotal();
        pr.setNumProfessionals(total);
        pr.setAverageNum(total/totalP);
        pr.setAverageEarnt(transactionRepository.getTotal("Payment from us to professional")/totalP);
        return pr;

    }

    /**
     * This is an API to return a request report between two dates
     * @param sd
     * @param ed
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "requestsReport/{sd}/{ed}")
    public @ResponseBody
    RequestsRequest requestReport(@PathVariable String sd, @PathVariable String ed) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date startDate = sdf.parse(sd);
        java.util.Date endDate = sdf.parse(ed);
        Date startDatee = new Date(startDate.getTime());
        Date endDatee = new Date(endDate.getTime());
        RequestsRequest rr = new RequestsRequest();
        double total = transactionRepository.calcTotalBetweenDates("Payment from customer to us", startDatee, endDatee);
        int numR = transactionRepository.calcAmountBetweenDates("Payment from customer to us", startDatee, endDatee);
        rr.setAverage(total/numR);
        rr.setNumRequests(numR);
        rr.setTotal(total);
        return rr;

    }

    /**
     * This is an API to return a problem report.
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "problemReport")
    public @ResponseBody
    List<Requests> problemReport() {
        Date date = new Date(System.currentTimeMillis() - 4 * 24 * 60 * 60 * 1000);
        return requestRepository.findProblems(date);
        

    }

    /**
     * This is an API to update a user
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "customer/update")
    public @ResponseBody
    void updateCustomer() {

    }

    /**
     * This is an API to update a user
     */
    @CrossOrigin(origins = "http://127.0.0.1:7080", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping(path = "professional/update")
    public @ResponseBody
    void updateProfessional() {

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