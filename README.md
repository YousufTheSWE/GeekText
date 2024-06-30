#  Profile Management
* Retrieve Profiles
  * Postman: GET localhost:8080/geektext/profiles
* Add Profile
  * Postman: POST localhost:8080/geektext/profiles
  * {
    "username": "Mario",
    "password": "h28s9j47",
    "email": "mario@hotmail.com"
    }
* Remove Profile by Username
  * Postman: DELETE localhost:8080/geektext/profiles/{username}
* Change Profile by Username
  * Postman: PUT localhost:8080/geektext/profiles/{username}?{key}={value}
  * {
    "id": {id},
    "username": "{username}",
    "email": "{email}"
    }
