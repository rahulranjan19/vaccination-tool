# Vaccination Tool
***

This is a part of DBMS Assignment

This application will provide you basic functionality to manage and book vaccinations through UI interface

***

## Pre-requisite :-
1. postgres db
   1. Install DB
   2. Add new user with all grant
      1. `CREATE ROLE sa WITH LOGIN PASSWORD 'password';`
      2. `ALTER ROLE sa CREATEDB;`
      3. Create DB tables by running file from `ddl.sql`
      4. ```GRANT ALL ON TABLE public.center TO sa;
         GRANT ALL ON TABLE public.center_vaccine TO sa;
         GRANT ALL ON TABLE public.register TO sa;
         GRANT ALL ON TABLE public.vaccine TO sa;
      5. Add dummy values in `center` and `vaccine` tables manually
      

2. Compile this application with `mvn clean install`
3. Run the application by Springboot main method in `VaccinationToolApplication`
4. Hit `localhost:8080/swagger-ui.html` in browser to see swagger ui.