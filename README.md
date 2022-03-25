# etb-bisa

# Install

- mvn install

# Execute

- cd etb-rest
- mvn -Pwildfly:dev wildfly-jar:dev-watch

# Test

Open http://localhost:8080/etb/



API: Producto: /api/producto
-    METHOD: X-PING:   PING Service
-    METHOD: X-CREATE: CReate Object
-    METHOD: X-UPDATE: Update Object  + id
-    METHOD: X-REMOVE: Remove Object  + id
-    METHOD: X-FITER:  Filter Object  + id



API: Producto: /api/pedido
-    METHOD: X-PING:   PING Service
-    METHOD: X-CREATE: CReate Object
-    METHOD: X-UPDATE: Update Object  + id
-    METHOD: X-REMOVE: Remove Object  + id
-    METHOD: X-FITER:  Filter Object  + id



API: Producto: /api/pedido/detalle
-    METHOD: X-PING:   PING Service
-    METHOD: X-CREATE: CReate Object
-    METHOD: X-UPDATE: Update Object  + id
-    METHOD: X-REMOVE: Remove Object  + id
-    METHOD: X-FITER:  Filter Object  + id


# Project

- Controllers:  Class handler only entities class
- Context:      Class CDI, JPA, CONFIG
- Mapper:       Class Mapper DTO to Entity 
- Request:      Class DTO allowed to request
- Response:     Class DTO allowed to response
- Service:      Class REST public Rest API

# Techiology

- WILDFLY width MidroProfile
- JEE   JPA
- JEE   CDI
- JEE   JAX-RS   

