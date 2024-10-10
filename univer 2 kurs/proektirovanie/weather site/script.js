document.addEventListener('DOMContentLoaded', () => {
    const apiKey = '7d1bf44229fe282f526e52c301ba6864';
    const city = 'Moscow';  // Вы можете менять город
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&appid=${apiKey}&lang=ru`;

    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const location = document.getElementById('location');
            const temperature = document.getElementById('temperature');
            const description = document.getElementById('description');

            location.textContent = `Город: ${data.name}`;
            temperature.textContent = `Температура: ${data.main.temp}°C`;
            description.textContent = `Погодные условия: ${data.weather[0].description}`;
        })
        .catch(error => console.error('Ошибка получения данных:', error));
});