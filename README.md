## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [✔️] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [✔️] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [❌] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [✔️] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [✔️] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [✔️] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [❌] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [❌] Apply data binding for views to help remove boilerplate code. (1 point)
- [✔️] Add a rounded corners for the images using the Glide transformations. (1 point)
- [✔️] Splash screen added when opening app (my inclusion) 

### App Walkthough GIF
<img src="https://i.imgur.com/ZtrMI6W.gif" width=250><img src="https://i.imgur.com/MMrveQf.gif" width=250><img src="https://i.imgur.com/vG5aCbT.gif" width=250><br>

### Notes
Some challenges that I had while developing had to do with glide and rounded edges. Based off some code snippets, I attempted to give round edges to the poster images on the recycle view and it ended up messing up the aspect ratio. However, i did find a work around by editing the xml of the movie entry. One other challenge was the splash screen and getting the text to scale properly. I am working on that on that when I can as it was an extra feature I added and it needs to scale to many screens. 
## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
