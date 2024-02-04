## Web-Socket Scope
This is a scope for beans that are tied to the lifecycle of a WebSocket session. 
Beans in this scope live from the moment a WebSocket session is established until the session is closed.

### Use case
Used for managing data that is specific to a single WebSocket user session.

### Example
Take a look at ```MyWebSocketHandler``` class
