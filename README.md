Ratings functionality for movies

## Requirements
We want to build 2 functionalities:

### 1. Rate a movie
- Users should be able to rate a movie on a scale of 1 to 5.
- Once a user has rated a movie, they can update their rating.
- Users cannot delete their rating for a movie.

Request for rating a movie will contain:
* `userId` - Id of the user who is rating the movie.
* `movieId` - Id of the movie which is being rated.
* `rating` - Rating given by the user.

Response for rating a movie will contain:
* rating object
* response status - it will be SUCCESS or FAILURE

### 2. Get average rating of a movie
- Users should be able to get average rating of a movie.

Request for getting average rating of a movie will contain:
* `movieId` - Id of the movie for which average rating is being requested.

Response for getting average rating of a movie will contain:
* `averageRating` - Average rating of the movie.
* response status - it will be SUCCESS or FAILURE
