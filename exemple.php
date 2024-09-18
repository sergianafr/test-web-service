<?php
$nom = $_GET['nom'];
// URL du service Java (sur Tomcat ou autre serveur)
$url = "http://localhost:8080/initwebservice/api/data?input=$nom";

// Initialisation de cURL
$ch = curl_init();

// Configuration des options cURL
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Exécution de la requête et stockage de la réponse
$response = curl_exec($ch);

// Vérification des erreurs
if ($response === false) {
    echo "Erreur : " . curl_error($ch);
} else {
    // Décodage de la réponse JSON
    $data = json_decode($response, true);
    echo "Coucou " . $data['response'];
}

// Fermeture de cURL
curl_close($ch);