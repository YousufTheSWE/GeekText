#  Profile Management
* Retrieve Profiles
  * Postman: GET localhost:8080/geektext/profiles
* Add Profile
  * Postman: POST localhost:8080/geektext/profiles/{username,email}
* Remove Profile by ID
  * Postman: DELETE localhost:8080/geektext/profiles/{id}
* Change Profile by ID
  * Postman: PUT localhost:8080/geektext/profiles
  * {
    "id": {id},
    "username": "{username}",
    "email": "{email}"
    }
