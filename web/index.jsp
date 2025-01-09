<%-- 
    Document   : index
    Created on : 5 janv. 2025, 17:18:00
    Author     : Raina
--%>
<!--
<%@page import="models.Aspect"%>
<%@page import="java.util.ArrayList"%>
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
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #3c8dbc;
            color: #fff;
            position: fixed;
            top: 0;
            left: 0;
            display: flex;
            flex-direction: column;
        }
        .sidebar .logo {
            text-align: center;
            padding: 20px;
            background-color: #367fa9;
        }
        .sidebar .logo h2 {
            margin: 0;
            font-size: 24px;
        }
        .sidebar ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .sidebar ul li {
            padding: 15px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .sidebar ul li:hover {
            background-color: #29507a;
        }
        .sidebar ul li i {
            margin-right: 10px;
        }
        .sidebar ul .submenu {
            display: none;
            background-color: #29507a;
            padding-left: 20px;
        }
        .sidebar ul .submenu li {
            padding: 10px 20px;
        }
        .sidebar ul .submenu li:hover {
            background-color: #204060;
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
    </script>
</head>
<body>
    <div class="sidebar">
        <div class="logo">
            <h2>Pharmacy</h2>
        </div>
        <ul>
            <li onclick="toggleSubmenu('stock-submenu')"><i class="fas fa-pills"></i> Produit</li>
            <ul id="stock-submenu" class="submenu">
                <li><a href="ProduitServlet?action=add" style="color: #fff; text-decoration: none;">Ajouter un Produit</a></li>
                <li><a href="ProduitServlet?action=view" style="color: #fff; text-decoration: none;">Liste des Produits</a></li>
                <li><a href="CategorieServlet" style="color: #fff; text-decoration: none;">Categorie</a></li>
                <li><a href="SousCategorieServlet" style="color: #fff; text-decoration: none;">SousCategorie</a></li>
            </ul>
            <li onclick="toggleSubmenu('prescriptions-submenu')"><i class="fas fa-chart-line"></i> Vente</li>
            <ul id="prescriptions-submenu" class="submenu">
                <li><a href="VenteServlet?action=add" style="color: #fff; text-decoration: none;">Ajouter une Vente</a></li>
                <li><a href="VenteServlet?action=historique" style="color: #fff; text-decoration: none;">Historique</a></li>
            </ul>
            <li onclick="toggleSubmenu('sales-submenu')"><i class="fas fa-truck"></i> Fournisseur</li>
            <ul id="sales-submenu" class="submenu">
                <li><a href="FournisseurServlet?action=add" style="color: #fff; text-decoration: none;">Ajouter un Fournisseur</a></li>
                <li><a href="FournisseurServlet?action=view" style="color: #fff; text-decoration: none;">Liste des Fournisseurs</a></li>
            </ul>
            <li onclick="toggleSubmenu('product-submenu')"><i class="fas fa-box-open"></i> Approvisionnement</li>
            <ul id="product-submenu" class="submenu">
                <li><a href="ApprovisionnementServlet?action=add" style="color: #fff; text-decoration: none;">Ajouter un Approvisionnement</a></li>
            </ul>
            <li><i class="fas fa-users"></i> Clients fidele</li>
            <li><i class="fas fa-cogs"></i> Settings</li>
        </ul>
    </div>
    <div class="content">
        <div class="card">
            <h3>Welcome to the Dashboard</h3>
            <p>Here is the main content of the pharmacy dashboard.</p>
        </div>
    </div>
</body>
</html>

-->

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
    </script>
</head>
<body>
    <!-- Inclure le Sidebar -->
    <jsp:include page="Sidebar.jsp" />

    <!-- Contenu principal -->
    <div class="content">
        <div class="card">
            <h3>Welcome to the Dashboard</h3>
            <p>Here is the main content of the pharmacy dashboard.</p>
        </div>
    </div>
</body>
</html>





