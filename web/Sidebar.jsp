<%-- 
    Document   : Sidebar
    Created on : 8 janv. 2025, 20:07:47
    Author     : Raina
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sidebar">
    <div class="logo">
        <h2>Pharmacy</h2>
    </div>
    <ul>
        <li onclick="toggleSubmenu('stock-submenu')"><i class="fas fa-pills"></i> Produit</li>
        <ul id="stock-submenu" class="submenu">
            <li><a href="insertProduit.jsp" style="color: #fff; text-decoration: none;">Ajouter un Produit</a></li>
            <li><a href="AspectServlet?action=view" style="color: #fff; text-decoration: none;">Aspect</a></li>
            <li><a href="UniteServlet?action=view" style="color: #fff; text-decoration: none;">Unité</a></li>
            <li><a href="listCategorie.jsp" style="color: #fff; text-decoration: none;">Catégorie</a></li>
            <li><a href="listSousCategorie.jsp" style="color: #fff; text-decoration: none;">Sous-Catégorie</a></li>
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
        <li><a href="ClientFideleServlet?action=view" style="color: #fff; text-decoration: none;"><i class="fas fa-users"></i> Clients fidèles</a></li>
        <li><a href="SettingsServlet?action=view" style="color: #fff; text-decoration: none;"><i class="fas fa-cogs"></i> Paramètres</a></li>
    </ul>
</div>

<script>
    function toggleSubmenu(categoryId) {
        const submenu = document.getElementById(categoryId);
        submenu.style.display = (submenu.style.display === "none" || submenu.style.display === "") ? "block" : "none";
    }
    
</script>

<style>
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
</style>

