## Application
Beans defined with application scope are scoped to the lifecycle of a ServletContext. 
This means that the bean is shared across all HTTP requests in all sessions but is tied to the lifecycle of the application.

### Use case
Application scope is used for data that needs to be shared across all sessions but still needs to be initialized and cleaned up along with the application, such as application-wide configurations or caches.

### Example
Take a look at ```CountryListProvider``` class