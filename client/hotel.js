// Function to convert date format
function convertDateFormat(date) {
  const dateParts = date.split("/");
  if (dateParts.length === 3) {
    const year = dateParts[2];
    const month = dateParts[1].padStart(2, "0"); // Zero-pad the month
    const day = dateParts[0].padStart(2, "0"); // Zero-pad the day
    const formattedDate = `${year}-${month}-${day}`;
    date = formattedDate;
  }
  return date;
}

// Function to fetch hotel data from the backend using API
async function getHotels(origin, checkIn, checkOut) {
  try {
    const response = await fetch(`http://localhost:8080/hotels/search?location=${origin}&checkIn=${checkIn}&checkOut=${checkOut}`);
    const result = await response.json();
    console.log(result);
    return result;
  } catch (error) {
    console.error(error);
    return [];
  }
}

// Function to display hotel data in the webpage
function displayHotels(hotels) {
  const hotelResultsElement = document.querySelector('.hotel-search-results');
  hotelResultsElement.innerHTML = '';

  const maxCards = 10;
  for (let i = 0; i < Math.min(hotels.length, maxCards); i++) {
    const item = hotels[i];
    const hotelCard = document.createElement('div');
    hotelCard.classList.add('hotel-card');

    const cardBody = document.createElement('div');
    cardBody.classList.add('card-body');

    const cardTitle = document.createElement('h5');
    cardTitle.classList.add('card-title');
    cardTitle.textContent = `${item.title}`;

    const cardInfo = document.createElement('p');
    cardInfo.classList.add('card-info');
    cardInfo.innerHTML = `Provider: <strong>${item.id}</strong><br>rating: ${item.bubbleRating.rating}<br>Price:  ${item.priceForDisplay}`;

    const bookButton = document.createElement('button');
    bookButton.classList.add('btn', 'btn-success', 'book-btn');
    bookButton.textContent = 'Book';

    cardBody.appendChild(cardTitle);
    cardBody.appendChild(cardInfo);
    cardBody.appendChild(bookButton);
    hotelCard.appendChild(cardBody);

    hotelResultsElement.appendChild(hotelCard);
  }
}

// Function to handle the search button click event
async function handleSearch(event) {
  event.preventDefault(); // Prevent the default form submission

  // Get the input values
  const origin = document.getElementById('origin').value;
  let checkIn = document.getElementById('checkIn').value;
  checkIn = convertDateFormat(checkIn);
  let checkOut = document.getElementById('checkOut').value;
  checkOut = convertDateFormat(checkOut);
  console.log(checkIn + " " + checkOut);

  // Fetch hotel data using the API
  const hotels = await getHotels(origin, checkIn, checkOut);

  // Display hotel data in the webpage
  displayHotels(hotels);
}

// Attach the handleSearch function to the search button click event
const searchBtn = document.getElementById('searchBtn');
searchBtn.addEventListener('click', handleSearch);
