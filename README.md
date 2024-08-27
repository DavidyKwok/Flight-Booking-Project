# Flight-Booking-Project
The Flight Booking Project is a system designed to manage flight bookings.

## Overview

The Flight Booking Project is a system designed to manage flight bookings using Java and JavaFX. It allows different user roles to interact with the system in various ways:

- **Manager**: Can create and delete flights (Username: manager, Password: admin).
- **Members**: Can book flights with a discount (Username: customer, Password: member).
- **Guests**: Can book flights with limited discounts.

![Manager Login Interface]

![image](https://github.com/user-attachments/assets/7ee06cee-91bb-4a13-9ce0-685861424fc6)
## Features

- **Flight Management**:
  - Create new flights.
  - Delete existing flights.

![Flight Management Interface]

![image](https://github.com/user-attachments/assets/1e3ced6d-c362-43d7-a927-374193eea6c9)

- **Booking System**:
  - Members receive discounts on bookings.
  - Guests can book flights at standard rates.

![Member Interface]

![image](https://github.com/user-attachments/assets/8bd87b50-361a-4567-ab9e-9e42735641f1)


![Guest Interface]

![image](https://github.com/user-attachments/assets/1505d301-f937-4b3e-b52c-6104cd3a7e0e)




- **Discount System**:
- Members that have a membership for 1 or less years don’t get a discount
- Members that have a membership for more than 1 year but less than 5 get a 10% discount
- Members that have a membership for more than 10 years get a 50% discount
- Regular customers that are over that age of 65 get a 10% discount


## Technologies Used

- **Java**: Core programming language used for development.
- **JavaFX**: Provides the graphical user interface (GUI) for the application.




