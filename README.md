# Appointment_Taker_Application


-> It is the basic Appointment Taker Application using the Java SpringBoot framework.
-> In this application, users/customers can register themselves, and create an appointment for their reasons or treatment.
-> Users/Customers can modify their information. For these features, this application uses CRUD operation.
-> So, this application is for creating your appointment for any kind. And admin or owner can check this appointment and user information for their work.

-> Requirement for this application
1) Java -> 17
2) SpringBoot -> 3.0.2 version
The dependency you should add -> Spring Web, Spring Data JPA, MySQL Driver, spring-boot-starter-validation, model mapper, and Lombok.
3) MySQL Database -> in DB workbench create schema -> with name appointment_taker
4) Postman Client-> for test REST API


Application REST APIs ->
In Postman Client ->
Request From User ->

User APIs ->

1) create user -> 

localhost:9002/api/user/createUser

add data ->
{
    "userName" : "Aditya Shinde",
    "userEmail" : "adityarshinde1999@gmail.com",
    "userMobileNumber" : "9689729099",
    "userWhatsAppNumber" : "Your_WhatsApp_Number",
    "userPassword" : "Your_Password@123"
}

2) update user ->

localhost:9002/api/user/updateUser/{userId}

update data ->
{
    "userName" : "Rahul Mohite",
    "userEmail" : "rahul@yahoo.com",
    "userMobileNumber" : "User_Number",
    "userWhatsAppNumber" : "User_WhatsApp_Number",
    "userPassword" : "rahul@123"
}

3) get user by userId->

localhost:9002/api/user/getUser/{userId}

4) get all users ->

localhost:9002/api/user/admin/getAllUser

5) delete user by userId ->

localhost:9002/api/user/deleteUser/{userId}



Appointment APIs ->

1) create appointment ->

localhost:9002/api/appointment/user/{userId}/createAppointment

add data ->
{
    "appointmentDate" : "20/01/2023",
    "appointmentTime" : "01:30 AM",
    "appointmentFor" : "Facial and protein treatment"
}

2) update appointment ->

localhost:9002/api/appointment/updateAppintment/{userId}

update data ->
{
    "appointmentDate" : "20/01/2023",
    "appointmentTime" : "01:30 AM",
    "appointmentFor" : "Facial and protein treatment"
}

3) get appointment by appointmentId->

localhost:9002/api/appointment/getAppointment/{appointmentId}

4) get all appointments ->

localhost:9002/api/appointment/getAllAppointments

5) get appointment by userId ->

localhost:9002/api/appointment/user/{userId}/getAllAppointments

6) delete appointment by appointmentId ->

localhost:9002/api/appointment/deleteAppointment/{appointmentId}
