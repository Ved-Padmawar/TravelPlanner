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

  console.log(origin)

  // Construct the URL with the dynamic inputs
  const apiUrl = `https://api.tequila.kiwi.com/v2/search?fly_from=${origin}&fly_to=${destination}&date_from=${dateFrom}&date_to=${dateFrom}&max_stopovers=1&vehicle_type=aircraft&limit=20&curr=INR&sort=price`;
  const apiKey = "1wU6jIQnCeBsJ12o94xH5xr0IpQ2YU_k";



  fetch(apiUrl, {
                          method: 'GET',
                          headers: {
                              'Accept': 'application/json',
                              'apikey': apiKey
                          }
                      })
    .then(response => response.json())
    .then(data => {
      // Process the response data here
      console.log(data);
      // Update the flight fare details in the webpage
      updateFlightFares(data.data);
    })
    .catch(error => {
      // Handle any errors that occurred during the request
      console.log('Erroroojio:', error);
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
    cardTitle.textContent = `${flight.cityCodeFrom} to ${flight.cityCodeTo}`;

    const cardInfo = document.createElement('p');
    cardInfo.classList.add('card-info');
    cardInfo.innerHTML = `Flight ID: <strong>${flight.id}</strong><br>Base Fare: ${flight.price_dropdown.base_fare}`;

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