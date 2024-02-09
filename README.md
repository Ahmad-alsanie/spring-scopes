## Spring Scopes
Practical examples and real world use cases of spring scopes

### Table of Contents
- [Description](#Description)
- [How To Navigate](#How-To-Navigate)
- [Available Scopes](#Available-Scopes)

### Description
In the Spring Framework, the concept of "scopes" refers to the lifecycle and visibility of beans managed by the Spring container. 
Understanding bean scopes is crucial for designing and developing robust Spring applications, as it affects how instances of objects are created, shared, and managed across the application.


### How To Navigate
Each package is created to host one scope with a real-world example where there is also a `.md` file that describes each scope and use case
You can also navigate to [controller](./src/main/java/com/sanie/springscopes/controller/ScopedBeansController.java) to see how we used all scopes.

### Available Scopes
- [Singleton Scope](./src/main/java/com/sanie/springscopes/singleton)
- [Prototype Scope](./src/main/java/com/sanie/springscopes/prototype)
- [Request Scope](./src/main/java/com/sanie/springscopes/request)
- [Session Scope](./src/main/java/com/sanie/springscopes/session)
- [Application Scope](./src/main/java/com/sanie/springscopes/application)
- [WebSocket Scope](./src/main/java/com/sanie/springscopes/websocket)

## Contributing

Contributions are welcome! If you have improvements or additions, please submit a pull request or open an issue.

-------------------------------------------------------------
Happy coding!
