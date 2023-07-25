
const getGeoLoc=async (input)=>{
    const url = `https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchLocation?query=${input}`;
    const options = {
    	method: 'GET',
    	headers: {
    		'X-RapidAPI-Key': '3ffa31065cmshdb0bf1e8e3afe8cp1bfa1fjsn0ee01bcde51e',
    		'X-RapidAPI-Host': 'tripadvisor16.p.rapidapi.com'
    	}
    };
//    try {
        const response = await fetch(url, options);
        const result = await response.json();
        console.log(result);

        outerLoop: for (const item of result.data) {
            if (item.secondaryText && item.geoId != null) {
                console.log(item);

                if (item.secondaryText.includes("India")) {
//                    console.log(item.geoId.split(";")[1]);
                    // let geoLoc = item.geoId.split(";")[1];
                    console.log(parseInt(item.geoId.split(";")[1]));
                    return item.geoId.split(";")[1];
                    break outerLoop; // Exit the outer loop when both conditions are satisfied
                }
            }
        }
//       return item.geoId.split(";")[1];
//    } catch (error) {
//        console.error(error);
//    }

}


const getHotels=async (geoid,checkIn,checkOut)=>{
//    geoid = geoid;
    const url = `https://tripadvisor16.p.rapidapi.com/api/v1/hotels/searchHotels?geoId=${geoid}&checkIn=${checkIn}&checkOut=${checkOut}&pageNumber=1&currencyCode=USD`;
    const options = {
    	method: 'GET',
    	headers: {
    		'X-RapidAPI-Key': '3ffa31065cmshdb0bf1e8e3afe8cp1bfa1fjsn0ee01bcde51e',
    		'X-RapidAPI-Host': 'tripadvisor16.p.rapidapi.com'
    	}
    };

//    try {
    	const response = await fetch(url, options);
    	const result = await response.json();
    	console.log(result);
    	return result.data.data;
//    	console.log(result);
//    } catch (error) {
//    	console.error(error);
//    }
}

function convertDateFormat(date) {
//      const dateInput = document.getElementById("dateInput");
//      const originalDate = dateInput.value;
      const dateParts = date.split("/");

      if (dateParts.length === 3) {
        const year = dateParts[2];
        const month = dateParts[1].padStart(2, "0"); // Zero-pad the month
        const day = dateParts[0].padStart(2, "0");   // Zero-pad the day
        const formattedDate = `${year}-${month}-${day}`;
        date = formattedDate;
      }
      return date;
    }




const searchBtn = document.getElementById('searchBtn');
searchBtn.addEventListener('click', handleSearch);

// Function to handle the search button click event
async function handleSearch(event) {
  event.preventDefault(); // Prevent the default form submission
console.log("clickeddd");
  // Get the input values
  const origin = document.getElementById('origin').value;
  let checkIn = document.getElementById('checkIn').value;
  checkIn=convertDateFormat(checkIn);
  let checkOut = document.getElementById('checkOut').value;
  checkOut=convertDateFormat(checkOut);
  console.log(checkIn+" "+checkOut);
  let geoId=await getGeoLoc(origin);
//  console.log(getHotels(geoId,checkIn,checkOut));
  let items=await getHotels(geoId,checkIn,checkOut);
  console.log(items)


//  const dataArray = ['Item 1', 'Item 2', 'Item 3', 'Item 4']; // Replace this with your actual array data

  //function displayArrayItems() {
const hotelResultsElement = document.querySelector('.hotel-search-results');
  hotelResultsElement.innerHTML = '';
  items.forEach(item => {
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
    });

}

// Function to update the flight fare details in the webpage
//function updateFlightFares(data) {
//  // Clear the existing flight cards
//  const flightResultsElement = document.querySelector('.flight-search-results');
//  flightResultsElement.innerHTML = '';
//
//  // Create flight cards dynamically based on the data
//  data.forEach(flight => {
//    const flightCard = document.createElement('div');
//    flightCard.classList.add('flight-card');
//
//    const cardBody = document.createElement('div');
//    cardBody.classList.add('card-body');
//
//    const cardTitle = document.createElement('h5');
//    cardTitle.classList.add('card-title');
//    cardTitle.textContent = `${flight.cityCodeFrom} to ${flight.cityCodeTo}`;
//
//    const cardInfo = document.createElement('p');
//    cardInfo.classList.add('card-info');
//    cardInfo.innerHTML = `Flight ID: <strong>${flight.id}</strong><br>Base Fare: ${flight.price_dropdown.base_fare}`;
//
//    const bookButton = document.createElement('button');
//    bookButton.classList.add('btn', 'btn-success', 'book-btn');
//    bookButton.textContent = 'Book';
//
//    cardBody.appendChild(cardTitle);
//    cardBody.appendChild(cardInfo);
//    cardBody.appendChild(bookButton);
//    flightCard.appendChild(cardBody);
//
//    flightResultsElement.appendChild(flightCard);
//  });
//}