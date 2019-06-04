#!/bin/bash
# Automation API tests 

SVR='http://localhost:9090'

echo -e "\nGet all customers\n"
curl -X GET "$SVR/main/customer/all"

echo -e "\nGet all professionals\n"
curl -X GET "$SVR/main/professionals/all"

echo -e "\nGet all reviews\n"
curl -X GET "$SVR/main/reviews/all"

echo -e "\nGet all vehicles\n"
curl -X GET "$SVR/main/vehicles/all"

echo -e "\nGet all services\n"
curl -X GET "$SVR/main/services/all"
	
echo -e "\nGet all requests\n"
curl -X GET "$SVR/main/requests/all"

echo -e "\nGet all transactions\n"
curl -X GET "$SVR/main/transactions/all"

echo -e "\nCreate a Professional\n"
curl -X POST "$SVR/main/professional/create?email=prof@prof.com&name=profuser&bankToken=123123456&mobileNumber=043212345&passwordToken=pass&ABN=54321&certificationNumber=1990001&priceVariance=0.6"

echo -e "\nCreate a Customer\n"
curl -X POST "$SVR/main/user/create?name=customeruser&cardAuthToken=1232019-06-04123&email=cust@cust.com&mobileNumber=1234567&passwordToken=cust"

echo -e "\nLogin Customer\n"
customerID=$(curl -X POST "$SVR/main/user/logIn/cust@cust.com/cust")

echo -e "\nLogin as Professional\n"
professionalID=$(curl -X POST "$SVR/main/professional/logIn/prof@prof.com/pass")

echo -e "\nAdd vehicle to customer id\n"
curl -X POST "$SVR/main/addVehicle/$customerID/ABC321/ford/1992"

echo -e "\nGet vehicles by userID\n" 
curl -X GET "$SVR/main/vehicles/$customerID"

echo -e "\nLogin as Admin\n"
curl -X POST "$SVR/main/admin/logIn/1/password"

echo -e "\nFind Admin by ID\n"
curl -X GET "$SVR/main/admin/find/1"

echo -e "\nFind User by ID\n"
curl -X GET "$SVR/main/user/find/$customerID"

echo -e "\nFind Professional by ID\n"
curl -X GET "$SVR/main/professional/find/$professionalID"

echo -e "\nCreate a Admin\n"
curl -X POST "$SVR/main/admin/create?passwordToken=password"

echo -e "\nStart a request\n"
requestID=$(curl -X POST "$SVR/main/request/start?customerId=$customerID&longitude=0&latitude=0&vehicleId=1&issue=2")

echo -e "\nProfessional Accept a request\n"
curl -X GET "$SVR/main/professionals/requests/select/$professionalID/$requestID"

echo -e "\nCheck if professional has accepted an offer\n" 
curl -X POST "$SVR/main/request/checkOffers/$requestID"

echo -e "\nCustomer pick professional\n" 
curl -X POST "$SVR/main/customer/requests/select/$professionalID/$requestID"

echo -e "\nProfessional Complete Request\n" 
curl -X GET "$SVR/main/professionals/requests/complete/$professionalID"

echo -e "\nCustomer Check Request Status\n" 
curl -X POST "$SVR/main/customer/requests/status/$requestID"

echo -e "\nlodge a review for a request\n"
curl -X GET "$SVR/main/review/lodge/$requestID/Great/5.0"

exit 0
