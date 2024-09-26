// Получение кнопок и блоков для взаимодействия
const stathamQuoteButton = document.getElementById('statham-quote-button');
const stathamQuote = document.getElementById('statham-quote');
const hamsterButton = document.getElementById('hamster-button');
const hamsterMessage = document.getElementById('hamster-message');
const contactButton = document.getElementById('contact-button');
const contactInfo = document.getElementById('contact-info');

// Массив цитат Джейсона Стетхема
const stathamQuotes = [
    "Лучше я умру как волк, чем буду жить как собака.",
    "Я предпочитаю жить на полной скорости. Ведь остановиться всегда можно.",
    "Не стоит быть слишком добрым, чтобы не стать слишком наивным.",
    "Жизнь – это череда испытаний. Главное – пройти их достойно."
];

// Функция для показа случайной цитаты
stathamQuoteButton.addEventListener('click', () => {
    const randomIndex = Math.floor(Math.random() * stathamQuotes.length);
    stathamQuote.textContent = stathamQuotes[randomIndex];
    stathamQuote.classList.toggle('hidden');
});

// Функция для показа сообщения про хомяка
hamsterButton.addEventListener('click', () => {
    hamsterMessage.textContent = "Вы че там совсем? Какой хомяк?! Сейчас сентябрь 24 года, одумайтесь!!!";
    hamsterMessage.classList.toggle('hidden');
});

// Функция для показа контактной информации
contactButton.addEventListener('click', () => {
    contactInfo.classList.toggle('hidden');
});

// Функция для получения и отображения прогноза погоды
async function getWeatherForecast(country, city) {
    try {
        // Получите ключ API и замените 'YOUR_API_KEY'
        const apiKey = 'Tf4qGnJrLAx1HtAAUFqFoAuWb8kbaVAC';
        
        // Получение идентификатора города
        const locationResponse = await fetch(`http://dataservice.accuweather.com/locations/v1/cities/search?apikey=${apiKey}&q=${city}`);
        const locationData = await locationResponse.json();
        const locationKey = locationData[0].Key;
        
        // Получение прогноза на 30 дней
        const forecastResponse = await fetch(`http://dataservice.accuweather.com/forecasts/v1/daily/30day/${locationKey}?apikey=${apiKey}&language=ru-ru&metric=true`);
        const forecastData = await forecastResponse.json();
        
        // Отображение прогноза
        const forecastList = document.getElementById('forecast-list');
        forecastList.innerHTML = '';
        forecastData.DailyForecasts.forEach(day => {
            const listItem = document.createElement('li');
            listItem.textContent = `${day.Date}: Min ${day.Temperature.Minimum.Value}°C, Max ${day.Temperature.Maximum.Value}°C`;
            forecastList.appendChild(listItem);
        });
        document.getElementById('weather-forecast').classList.remove('hidden');
    } catch (error) {
        console.error('Ошибка при получении данных:', error);
    }
}

// Обработчик для формы прогноза погоды
document.getElementById('weather-form').addEventListener('submit', event => {
    event.preventDefault();
    const country = document.getElementById('country').value;
    const city = document.getElementById('city').value;
    getWeatherForecast(country, city);
});
