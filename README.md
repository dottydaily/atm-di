# ATM-DI Lab exercise

**_Edit by Pornpat Santibuppakul 5910406299_**

**_Forked from : https://github.com/ladyusa/atm-di_**

> 1.) XML-Based DI
> 
>       Package "prob1_atmXML"

> 2.) Annotation-Based DI
>
>       Package "prob2_atmAnnotationDI"

> 3.) Java Config DI
>       
>       Package "prob3_atmJavaConfigDI"

> 4.) Database Connect (Annotation DI)
>
>       Package "prob4_atmDatabaseWithAnnotationDI"
>       Database "customers.db"
>   - Add class DatabaseConnector (Use this for connect & query DB)

> 5.) Database Connect via Spring JDBC/DAO
>
>       Package "prob5_atmSpringJDBC"
>
>   - Re-implement DatabaseConnector / DataSource for using XML-Based DI   
>   - NOTE : Try to using annotation DI with value.properties
>   but found a problem when injecting @Value into properties of Singleton instance
___________________________________________________________________________
**_All .xml files store in directory "resources"_**


