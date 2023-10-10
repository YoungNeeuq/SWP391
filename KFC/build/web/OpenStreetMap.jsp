<%-- 
    Document   : OpenStreetMap
    Created on : Oct 1, 2023, 4:07:07 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>OpenStreetMap</title>
    <!-- Bao gồm thư viện Leaflet -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
</head>
<body>
    <!-- Div để hiển thị bản đồ -->
    <div id="map" style="width: 100%; height: 600px;"></div>

    <script>
        // Khởi tạo bản đồ Leaflet
        var map = L.map('map').setView([16.054407 ,108.202164], 13);

        // Thêm layer OpenStreetMap
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

        // Thêm marker (điểm đánh dấu) vào bản đồ
        var marker = L.marker([ 16.054407,108.202164]).addTo(map);

        // Thêm popup cho marker
        marker.bindPopup("<b>Hello world!</b><br>I am a popup.").openPopup();
    </script>
</body>
</html>
