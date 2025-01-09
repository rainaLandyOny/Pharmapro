<%-- 
    Document   : listProduit
    Created on : 9 janv. 2025, 11:41:18
    Author     : Raina
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Produits</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }
        .container {
            max-width: 1200px;
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
        .form-group input, .form-group textarea {
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
        <h2>Liste des Produits</h2>
        <button class="btn" onclick="showForm()">Ajouter Produit</button>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prix</th>
                    <th>Fournisseur</th>
                    <th>Catégorie</th>
                    <th>Sous-Catégorie</th>
                    <th>Date de Fabrication</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="produit" items="${produits}">
                    <tr>
                        <td>${produit.idProduit}</td>
                        <td>${produit.nomProduit}</td>
                        <td>${produit.prixProduit}</td>
                        <td>${produit.idFournisseur}</td>
                        <td>${produit.idCategorie}</td>
                        <td>${produit.idSousCategorie}</td>
                        <td>${produit.dateFabrication}</td>
                        <td>${produit.description}</td>
                        <td>
                            <a href="ProduitServlet?action=edit&id=${produit.idProduit}" class="btn">Modifier</a>
                            <a href="ProduitServlet?action=delete&id=${produit.idProduit}" class="btn" onclick="return confirm('Voulez-vous vraiment supprimer ce produit ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty produits}">
            <p>Aucun produit disponible.</p>
        </c:if>
    </div>

    <!-- Floating form -->
    <div id="form-overlay" class="form-overlay">
        <div class="form-container">
            <button class="close-btn" onclick="hideForm()">X</button>
            <h3>Ajouter un Produit</h3>
            <form action="ProduitServlet" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="nomProduit">Nom du Produit :</label>
                    <input type="text" id="nomProduit" name="nomProduit" placeholder="Entrez le nom du produit" required>
                </div>
                <div class="form-group">
                    <label for="prixProduit">Prix du Produit :</label>
                    <input type="number" id="prixProduit" name="prixProduit" placeholder="Entrez le prix du produit" required>
                </div>
                <div class="form-group">
                    <label for="idFournisseur">Fournisseur :</label>
                    <input type="text" id="idFournisseur" name="idFournisseur" placeholder="Entrez l'ID du fournisseur" required>
                </div>
                <div class="form-group">
                    <label for="idCategorie">Catégorie :</label>
                    <input type="number" id="idCategorie" name="idCategorie" placeholder="Entrez l'ID de la catégorie" required>
                </div>
                <div class="form-group">
                    <label for="idSousCategorie">Sous-Catégorie :</label>
                    <input type="number" id="idSousCategorie" name="idSousCategorie" placeholder="Entrez l'ID de la sous-catégorie" required>
                </div>
                <div class="form-group">
                    <label for="dateFabrication">Date de Fabrication :</label>
                    <input type="date" id="dateFabrication" name="dateFabrication" required>
                </div>
                <div class="form-group">
                    <label for="description">Description :</label>
                    <textarea id="description" name="description" placeholder="Entrez une description" rows="4"></textarea>
                </div>
                <button type="submit" class="btn">Ajouter</button>
            </form>
        </div>
    </div>
</body>
</html>