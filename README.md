# FlightManagementAPI
Midterm Sprint for dev ops 

Q1. Which two endpoints did you add pagination to, and why did those make sense to paginate?
e.g. "We paginated GET /passengers because in a real system there could be thousands of records..."

Answer: I added pagination to AirCraft and Passenger endpoints because these could have a lot of records so now the API returns in smaller groups instead of everything at once which could be to much for someone to sort through. So passengers is split up and Aircraft but they all couldve used it in real life. 


Q2. Show a Postman request that uses pagination and sorting (Show a screenshot from postman when you test)
on one of your endpoints. What URL did you use, and what did the response look like?

Screenshot is added. 


Q3. In your own code, what does the Pageable parameter do in your repository or controller? Paste the relevant
method signature and explain it.

Answer: in aircraft and passenger controllers, Pageable lets the API know which page to return, how much of the records to include and how to sort them. This means someone doesnt have to manually split up all the results from the records. 

@GetMapping
public ResponseEntity<Page<Aircraft>> getAllAircraft(
        @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.ASC)
        Pageable pageable) {
    return ResponseEntity.ok(aircraftService.getAllAircraft(pageable));
}

Q4. What is the difference between Page<T> and List<T> as a return type? Why might you choose one over the
other?

Answer: List would return a list of records in one big list. I used page because it uses pagination which the assignment wanted and it breaks records into smaller groups so instead of getting a bunch of records back at once with list it would show like 50 air crafts at once but with page you can break it into getting 5 at a time. 