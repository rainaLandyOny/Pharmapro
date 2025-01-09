<%-- 
    Document   : insertProduit
    Created on : 7 janv. 2025, 13:12:05
    Author     : Raina
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pharmacy Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f6f9;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
        }
        .card {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .card h3 {
            margin: 0 0 10px;
        }
    </style>
    <script>
        function toggleSubmenu(categoryId) {
            const submenu = document.getElementById(categoryId);
            submenu.style.display = (submenu.style.display === "none" || submenu.style.display === "") ? "block" : "none";
        }
        function validateForm() {
    var nomProduit = document.getElementById('nomProduit').value;
    var prix = document.getElementById('prix').value;
    var fournisseur = document.getElementById('idFournisseur').value;
    var categorie = document.getElementById('idCategorie').value;
    var sousCategorie = document.getElementById('idSousCategorie').value;
    var dateFabrication = document.getElementById('dateFabrication').value;

    if (nomProduit == "" || prix == "" || fournisseur == "" || categorie == "" || sousCategorie == "" || dateFabrication == "") {
        alert("Tous les champs doivent être remplis !");
        return false;
    }
    return true;
}
        
    </script>
</head>
<body>
    <jsp:include page="Sidebar.jsp" />
    <div class="content">
       <div class="card">
    <h3>Ajouter un Produit</h3>
    <form action="ProduitServlet?action=add" method="post" onsubmit="return validateForm()">
        <div style="margin-bottom: 15px;">
            <label for="nomProduit" style="display: block; font-weight: bold;">Nom du Produit:</label>
            <input type="text" id="nomProduit" name="nomProduit" required 
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="prix" style="display: block; font-weight: bold;">Prix:</label>
            <input type="number" id="prix" name="prix" step="0.01" required 
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div style="margin-bottom: 15px;">
            <label for="idFournisseur" style="display: block; font-weight: bold;">Fournisseur:</label>
            <select id="idFournisseur" name="idFournisseur" required 
                    style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
                <option value="">-- Sélectionnez un fournisseur --</option>
                <option value="1">Fournisseur 1</option>
                <option value="2">Fournisseur 2</option>
                <!-- Ajoutez les options dynamiquement depuis votre base de données -->
            </select>
        </div>
        <div style="margin-bottom: 15px;">
            <label for="idCategorie" style="display: block; font-weight: bold;">Catégorie:</label>
            <select id="idCategorie" name="idCategorie" required 
                    style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
                <option value="">-- Sélectionnez une catégorie --</option>
                <c:forEach var="categorie" items="${categories}">
                    <option value="${categorie.id}" ${categorie.id == produit.idCategorie ? 'selected' : ''}>
                        ${categorie.nom}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div style="margin-bottom: 15px;">
            <label for="idSousCategorie" style="display: block; font-weight: bold;">Sous Catégorie:</label>
            <select id="idCategorie" name="idCategorie" required 
                    style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
                <option value="">-- Sélectionnez une sous-catégorie --</option>
                <c:forEach var="sousCategorie" items="${sousCategories}">
                    <option value="${sousCategorie.id}" ${sousCategorie.id == produit.idSousCategorie ? 'selected' : ''}>
                        ${sousCategorie.nom}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div style="margin-bottom: 15px;">
            <label for="dateFabrication" style="display: block; font-weight: bold;">Date de Fabrication:</label>
            <input type="date" id="dateFabrication" name="dateFabrication" required 
                   style="width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
        </div>
        <div>
            <button onclick="window.location.href='ProduitServlet?action=add';" 
                    style="background-color: #3c8dbc; color: #fff; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer;">
                Ajouter un Produit
            </button>
        </div>
    </form>
    </div>
    </div>
</body>
</html>


