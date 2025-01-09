<%-- 
    Document   : listSousCategorie
    Created on : 8 janv. 2025, 20:38:12
    Author     : Raina
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Sous-Catégories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }
        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            position: relative;
        }
        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        table th {
            background-color: #3c8dbc;
            color: #fff;
        }
        .btn {
            padding: 5px 10px;
            background-color: #3c8dbc;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #367fa9;
        }
        /* Floating form styles */
        .form-overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            justify-content: center;
            align-items: center;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            width: 400px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }
        .form-container h3 {
            margin-bottom: 15px;
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .close-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: red;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            padding: 5px 10px;
        }
    </style>
    <script>
        function showForm() {
            document.getElementById("form-overlay").style.display = "flex";
        }
        function hideForm() {
            document.getElementById("form-overlay").style.display = "none";
        }
    </script>
</head>
<body>
    <div class="container">
            <jsp:include page="Sidebar.jsp" />
        <h2>Liste des Sous-Catégories</h2>
        <button class="btn" onclick="showForm()">Ajouter Sous-Catégorie</button>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sousCategorie" items="${sousCategories}">
                    <tr>
                        <td>${sousCategorie.id}</td>
                        <td>${sousCategorie.nom}</td>
                        <td>
                            <a href="SousCategorieServlet?action=edit&id=${sousCategorie.id}" class="btn">Modifier</a>
                            <a href="SousCategorieServlet?action=delete&id=${sousCategorie.id}" class="btn" onclick="return confirm('Voulez-vous vraiment supprimer cette sous-catégorie ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                         <c:if test="${empty sousCategories}">
        <p>Aucune sous-catégorie disponible.</p>
    </c:if>
    </div>

    <!-- Floating form -->
    <div id="form-overlay" class="form-overlay">
        <div class="form-container">
            <button class="close-btn" onclick="hideForm()">X</button>
            <h3>Ajouter une Sous-Catégorie</h3>
            <form action="SousCategorieServlet" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="nomSousCategorie">Nom de la Sous-Catégorie :</label>
                    <input type="text" id="nomSousCategorie" name="nomSousCategorie" placeholder="Entrez le nom de la sous-catégorie" required>
                </div>
                <button type="submit" class="btn">Ajouter</button>
            </form>
        </div>
    </div>
</body>
</html>  

