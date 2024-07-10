### Profile Management:
* Retrieve Profiles
  * Postman: GET localhost:8080/geektext/profiles
* Retrieve Profiles by username
  * Postman: GET localhost:8080/geektext/profiles/{username}
* Add Profile
  * Postman: POST localhost:8080/geektext/profiles
  * {username, email, password}
* Remove Profile by username
  * Postman: DELETE localhost:8080/geektext/profiles/{username}
* Change Profile by username
  * Postman: PUT localhost:8080/geektext/profiles/{username}?{key}={value}
* Post Credit Card to Username
  * Postman: POST localhost:8080/geektext/profiles/{username}/creditcards
  * {cardHolderName, cardNumber, expiryDate, securityCode}
* Delete Credit Card by cardNumber
  * Postman: DELETE localhost:8080/geektext/profiles/{username}/creditcards/{cardNumber}
     
