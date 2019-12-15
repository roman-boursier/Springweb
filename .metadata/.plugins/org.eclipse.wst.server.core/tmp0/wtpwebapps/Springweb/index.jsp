<html>
<body>
<h2>Hello World!</h2>
<!-- premier ne marche pas car il pointe directement sur le fichier.jsp -->
<p><a href ="vues/pagePays.jsp"> lien direct vers la page lien pays</a></p>
<!-- le second lui va se refairé au dispatcher et au controlleur pour délivrer la page jsp -->
<p><a href ="pagePays"> lien controller</a> </p>
<!-- le second lui va se refairé au dispatcher et au controlleur pour délivrer la page jsp -->
<p><a href ="pageVille"> lien controllerVille</a> </p>
<!-- le second lui va se refairé au dispatcher et au controlleur pour délivrer la page jsp -->
<p><a href ="pageLangage"> lien controllerLangage</a> </p>
<!-- le second lui va se refairé au dispatcher et au controlleur pour délivrer la page jsp -->
<p><a href ="pageRegions"> lien controllerRegions</a> </p>
<!-- le second lui va se refairé au dispatcher et au controlleur pour délivrer la page jsp -->
<p><a href ="pageRue"> lien controllerRue</a> </p>
<p><a href ="BarRecherche"> GO A LA BAR DE RECHERCHE</a> </p>
</form>  
</body>
</html>
