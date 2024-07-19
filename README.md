# GeekText Navigation and Uses  
<br />

### Book Browsing and Sorting:
* Retrieve List of Books by Genre
  * Postman: GET localhost:8080/geekText/browsing/books/genre?genre={genre_type}
* Retrieve List of Top Sellers (Top 10 books that have sold the most copied)
  * Postman: GET localhost:8080/geekText/browsing/books/top-sellers
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
### Book Commenting and Rating:
* Commenting:
  * Requests happen from */api/v1/comment where * is host
  * GET *api/v1/comment/{id}
    * Replace {id} with the bookID you want a comment for
    * Returns empty JSON if no comments exist
    * Throws IllegalStateException if book with bookId does not exist
  * POST */api/v1/comment
    * Requires a parameter body of raw data type JSON.
    * The JSON must contain "userId" "bookId" and "comment" params
    * Throws IllegalArgumentException if any of the 3 above are missing
    * Throws IllegalStateException if book with bookId does not exist
* Rating:
  * Requests mostly happen from *api/v1/rating where * is host
  * GET *api/v1/book/rating/{id}
    * Replace {id} with id of book you want average rating for
    * Returns 0 if average rating does not exist
    * Returns IllegalStateException if bookId does not exist
  * POST *api/v1/rating
    * Requires a parameter body of raw data type JSON.
    * The JSON must contain "userId" "bookId" and "rating" params
    * Throws IllegalArgumentException if any of the 3 above are missing
    * Throws IllegalArgumentException if the rating is not and integer in range [1,5]
    * Throws IllegalStateException if book with bookId does not exist
    * Throws DoubleRatingException if the user already rated this book.
### Wishlist Management:
* Create Wishlist:
  * Postman:
    * Method: POST
    * URL: http://localhost:8080/api/v1/wishlists
    * Body: (form-data)
    * Key: userID, value: 1 // value instance '1' used in demo video
* Add book to Wishlist:
  * Postman:
    * Method: POST
    * URL: http://localhost:8080/api/v1/wishlists/{wishlistId}/books
    * Body: (form-data)
    * Key: bookId, value: 1 // value instance '1' used in demo video
* Remove book from Wishlist:
   * Postman
    * Method: DELETE
    * URL: http://localhost:8080/api/v1/wishlists/{wishlistId}/books/{bookId}
* List books in Wishlist:
   * Postman:
    * Method: GET
    * URL: http://localhost:8080/api/v1/wishlists/{wishlistId}/books
    * Response data: JSON LIST of books in the user's wishlist





