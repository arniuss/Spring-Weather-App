document.addEventListener('DOMContentLoaded', function () {
    const citySelect = document.getElementById('city');
    const cities = ['CRETE', 'FRYDEK_MISTEK', 'BRIGHTON', 'MALAGA', 'MALTA'];

    cities.forEach(city => {
        const option = document.createElement('option');
        option.value = city;
        option.textContent = city.replace('_', ' ');
        citySelect.appendChild(option);
    });

    document.getElementById('weatherForm').addEventListener('submit', function (event) {
        event.preventDefault();
        const selectedCity = citySelect.value;

        if (selectedCity) {
            fetch(`/weather/${selectedCity}`)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('weatherInfo').innerHTML = `
                        <h2>Weather in ${selectedCity.replace('_', ' ')}</h2>
                        <p>Temperature: ${data.temperature}°C</p>
                        <p>Condition: ${data.condition}</p>
                    `;
                })
                .catch(error => {
                    console.error('Error fetching weather data:', error);
                    document.getElementById('weatherInfo').innerHTML = '<p>Error retrieving weather data. Please try again.</p>';
                });
        }
    });
});