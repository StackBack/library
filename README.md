# library

url:
post-"rest/user" - - create user
get-"rest/user" - get a list of all users
put-"rest/user" - update date of user
delete-"rest/user/{id}" - delete user by id
get-"rest/user/{id}" - get user by id

post-"rest/book" - - create book
get-"rest/book" - get a list of all book
put-"rest/book" - update date of book
delete-"rest/book/{id}" - delete book by id
get-"rest/book/{id}" - get book by id

-"library/freebook" - get a list of all books that are free
-"library/userWithBook" - get a list of all books taken by users
-"library/return" - return book to library (request param "id" of book)
-"library/take" - the user takes the book (request param "bookId" and "userId")
