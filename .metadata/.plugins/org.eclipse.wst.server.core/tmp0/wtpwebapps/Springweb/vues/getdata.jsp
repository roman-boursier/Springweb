<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.projet.autocomplete.SearchDB"%>


<%
    SearchDB db = new SearchDB();

    String query = request.getParameter("term");
//    out.println("q");


    List<String> countries = db.getData(query);
	//out.println(countries);
    
    Iterator<String> iterator = countries.iterator();
    
    //out.println(countries);
    while(iterator.hasNext()) {
       String country = (String)iterator.next();
       out.println(country + ',');
    }
    

    //out.print("{'name': 'toto'}");
    
%>