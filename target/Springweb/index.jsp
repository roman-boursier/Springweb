<html>
<body>
<h2>Hello World!</h2>
<!-- premier ne marche pas car il pointe directement sur le fichier.jsp -->
<p><a href ="vues/pagePays.jsp"> lien direct vers la page lien pays</a></p>
<!-- le second lui va se refair� au dispatcher et au controlleur pour d�livrer la page jsp -->
<p><a href ="pagePays"> lien controller</a> </p>
</body>
</html>
