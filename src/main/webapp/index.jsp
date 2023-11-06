<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Про ресурс</h1>
    <h2>Тут ви можете отримати інформацію про поточний час по UTC.</h2>
    <ul>
        <li>Для отримання актуального часу введіть в адресному рядку: <a>http://localhost:8080/UTC_time/time.</a></li>
        <li>Для отримання інформації по конкретному часовому поясу, введіть в адресному рядку: <a>http://localhost:8080/UTC_time/time?timezone=UTC+”yourParameter”</a>, де yourParameter – будь-яке ціле число. </li>
        <li>Зверніть увагу, що найпівденніший часовий пояс – UTC+14, а найзахідніший – UTC-12. При виході за ці межі отримаєте помилку 401.</li>
    </ul>
</body>
</html>