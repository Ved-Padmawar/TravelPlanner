

// Get the search button element
const searchBtn = document.getElementById('searchBtn');

// Add event listener for search button click
searchBtn.addEventListener('click', handleSearch);

// Function to handle the search button click event
function handleSearch(event) {
  event.preventDefault(); // Prevent the default form submission

  // Get the input values
  const origin = document.getElementById('origin').value;
  const destination = document.getElementById('destination').value;
  const dateFrom = document.getElementById('dateFrom').value;

 // Construct the URL with the dynamic inputs
const apiUrl = `http://localhost:8080/flights/search?fromLoc=${origin}&toLoc=${destination}&date_from=${dateFrom}`;

  // Note: We are using a relative URL here, assuming the frontend is served from the same domain as the Spring Boot backend.

  fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
      // Process the response data here
      console.log(data);
      // Update the flight fare details in the webpage
      updateFlightFares(data);
    })
    .catch(error => {
      // Handle any errors that occurred during the request
      console.log('Error:', error);
    });
}
// Function to update the flight fare details in the webpage
function updateFlightFares(data) {
  // Clear the existing flight cards
  const flightResultsElement = document.querySelector('.flight-search-results');
  flightResultsElement.innerHTML = '';

  // Create flight cards dynamically based on the data
  data.forEach(flight => {
    const flightCard = document.createElement('div');
    flightCard.classList.add('flight-card');

    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');

    const cardTitle = document.createElement('h5');
    cardTitle.classList.add('card-title');
    cardTitle.textContent = `${flight.cityFrom} to ${flight.cityTo}`;

    const cardInfo = document.createElement('p');
    cardInfo.classList.add('card-info');
    cardInfo.innerHTML = `Base Fare: ${flight.baseFare}`;

    const bookButton = document.createElement('button');
    bookButton.classList.add('btn', 'btn-success', 'book-btn');
    bookButton.textContent = 'Book';

    cardBody.appendChild(cardTitle);
    cardBody.appendChild(cardInfo);
    cardBody.appendChild(bookButton);
    flightCard.appendChild(cardBody);

    flightResultsElement.appendChild(flightCard);
  });
}
