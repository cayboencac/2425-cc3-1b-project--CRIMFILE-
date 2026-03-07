// Fetch car data from JSON and render cards dynamically
async function loadCars() {
    const response = await fetch('cars.json');
    const cars = await response.json();
    const carGrid = document.getElementById('carGrid');

    cars.forEach(car => {
        const card = document.createElement('div');
        card.className = 'car-card';
        card.innerHTML = `
            <div class="car-image">
                <img src="${car.image}" alt="${car.make}">
                <span class="status ${car.status.toLowerCase()}">${car.status}</span>
            </div>
            <div class="car-info">
                <h3>${car.make}</h3>
                <p class="price">$${car.pricePerDay} / day</p>
                <button class="rent-btn">Rent Now</button>
            </div>
        `;
        carGrid.appendChild(card);
    });
}

// Search filter
const searchInput = document.getElementById('searchInput');
searchInput.addEventListener('input', async () => {
    const response = await fetch('cars.json');
    const cars = await response.json();
    const query = searchInput.value.toLowerCase();
    const filtered = cars.filter(car => car.make.toLowerCase().includes(query));
    
    const carGrid = document.getElementById('carGrid');
    carGrid.innerHTML = ''; // Clear previous cards

    filtered.forEach(car => {
        const card = document.createElement('div');
        card.className = 'car-card';
        card.innerHTML = `
            <div class="car-image">
                <img src="${car.image}" alt="${car.make}">
                <span class="status ${car.status.toLowerCase()}">${car.status}</span>
            </div>
            <div class="car-info">
                <h3>${car.make}</h3>
                <p class="price">$${car.pricePerDay} / day</p>
                <button class="rent-btn">Rent Now</button>
            </div>
        `;
        carGrid.appendChild(card);
    });
});

loadCars();