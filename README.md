# GeekText Navigation and Uses:
-------------------------------
# Book Browsing and Sorting
* Retrieve List of Books by Genre
  * Postman: GET localhost:8080/geekText/browsing/books/genre?genre={genre_type}
* Retrieve List of Top Sellers (Top 10 books that have sold the most copied)
  * Postman: GET localhost:8080/geekText/browsing/books/top-sellers
-------------------------------
# Profile Management:
* Retrieve Profiles
  * Postman: GET localhost:8080/geektext/profiles
* Add Profile
  * Postman: POST localhost:8080/geektext/profiles/{username,email}
* Remove Profile by ID
  * Postman: DELETE localhost:8080/geektext/profiles/{id}
* Change Profile by ID
  * Postman: PUT localhost:8080/geektext/profiles
  * { "id": {id}, "username": "{username}", "email": "{email}" }
