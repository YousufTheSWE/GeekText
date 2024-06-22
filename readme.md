#GeekText Navigation and Uses:
-------------------------------
## Book Browsing and Sorting
* Retrieve List of Books by Genre
  * Postman: GET localhost:8080/geekText/browsing/books/genre?genre={genre_type}
* Retrieve List of Top Sellers (Top 10 books that have sold the most copied)
  * Postman: GET localhost:8080/geekText/browsing/books/top-sellers
-------------------------------
## Profile Management
* Retrieve Profiles
  * Postman: GET localhost:8080/geektext/profiles
* Add Profile
  * Postman: POST localhost:8080/geektext/profiles/{username,email}
* Remove Profile by ID
  * Postman: DELETE localhost:8080/geektext/profiles/{id}
* Change Profile by ID
  * Postman: PUT localhost:8080/geektext/profiles
  * { "id": {id}, "username": "{username}", "email": "{email}" }
-------------------------------
## Book Commenting and Rating:
* Commenting:
  * Requests happen from */api/v1/comment where * is host
  * GET *api/v1/comment/{id}
    * Replace {id} with the bookID you want a comment for
    * Returns empty JSON if no comments exist
  * POST */api/v1/comment
    * Requires a paramater body of raw data type JSON.
    * The JSON must contain "userId" "bookId" and "comment" params
    * Throws IllegalArgumentException if any of the 3 above are missing
* Rating:
  * Requests mostly happen from *api/v1/rating where * is host
  * GET *api/v1/book/rating/{id}
    * Replace {id} with id of book you want average rating for
    * Returns 0 if average rating does not exist
    * Returns IllegalStateException if bookId does not exist
  * POST *api/v1/rating
    * Requires a paramater body of raw data type JSON.
    * The JSON must contain "userId" "bookId" and "rating" params
    * Throws IllegalArgumentException if any of the 3 above are missing
    * Throws IllegalArgumentException if the rating is not and integer in range [1,5]
    * Throws IllegalStateException if book with bookId does not exist
-------------------------------
