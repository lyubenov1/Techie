# Techie - E-commerce website for tech products

### Running the Application

To get the application up and running, follow these steps:

1.  **Create Database Tables:**

    The application is configured to automatically create the necessary database tables on startup using Hibernate. Simply launch the application, and it will handle this for you.
2.  **Populate Tables with Initial Data:**

    Execute the `data.sql` file located in the `src/main/resources` directory of the project. This will populate the tables with essential data.
3.  **Start the Application:**

    Now that the tables are created and populated, you can launch the application. Additional data will be populated during startup using `@PostConstruct` methods.


### Index page current state

<img src="src/main/resources/static/images/index_page.png" alt="Database Diagram" width="800" height="400">



### Database diagram (as of right now)
The product entity (table) is inherited by various child entities (laptop, smartphone, etc.), which add their own fields (attributes) in addition to the attributes of the parent product entity. Pictures are shown below.

<img src="src/main/resources/static/images/diagram.png" alt="Database Diagram" width="800" height="700">


### The products:
<img src="src/main/resources/static/images/products_diagram.png" alt="Database Diagram" width="750" height="700">



