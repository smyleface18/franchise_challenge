# API Franquify - Documentación de Endpoints

Base URL: `http://localhost:8080/api`

## Endpoints de Franquicias

### 1. Crear Franquicia
```bash
curl -X POST "http://localhost:8080/api/franchise" \
-H "Content-Type: application/json" \
-d '{
  "name": "Mi Franquicia",
  "branches": [
    {
      "name": "Sucursal Centro",
      "products": [
        {
          "name": "Producto 1",
          "stock": 50
        }
      ]
    }
  ]
}'
```

### 2. Agregar Sucursal a Franquicia
```bash
curl -X POST "http://localhost:8080/api/franchise/123/branch" \
-H "Content-Type: application/json" \
-d '{
  "name": "Nueva Sucursal",
  "products": [
    {
      "name": "Laptop Gamer",
      "stock": 25
    }
  ]
}'
```

### 3. Cambiar Nombre de Franquicia
```bash
curl -X PUT "http://localhost:8080/api/franchise/123/name" \
-H "Content-Type: application/json" \
-d '{
  "name": "Nuevo Nombre Franquicia"
}'
```

### 4. Obtener Todas las Franquicias
```bash
curl -X GET "http://localhost:8080/api/franchise" \
-H "Content-Type: application/json"
```

### 5. Obtener Productos con Mayor Stock por Sucursal
```bash
curl -X GET "http://localhost:8080/api/franchise/123/top-products" \
-H "Content-Type: application/json"
```

## Endpoints de Sucursales (Branches)

### 1. Crear Sucursal para Franquicia
```bash
curl -X POST "http://localhost:8080/api/branch/franchise/123" \
-H "Content-Type: application/json" \
-d '{
  "name": "Sucursal Norte",
  "products": [
    {
      "name": "Tablet Android",
      "stock": 30
    },
    {
      "name": "Smartphone",
      "stock": 15
    }
  ]
}'
```

### 2. Agregar Producto a Sucursal
```bash
curl -X POST "http://localhost:8080/api/branch/456/product" \
-H "Content-Type: application/json" \
-d '{
  "name": "Monitor 24\"",
  "stock": 10
}'
```

### 3. Eliminar Producto de Sucursal
```bash
curl -X DELETE "http://localhost:8080/api/branch/456/product/789" \
-H "Content-Type: application/json"
```

### 4. Actualizar Stock de Producto
```bash
curl -X PUT "http://localhost:8080/api/branch/456/product/789/stock" \
-H "Content-Type: application/json" \
-d '{
  "idBranch": "456",
  "name": "Monitor 24\"",
  "stock": 25
}'
```

### 5. Cambiar Nombre de Sucursal
```bash
curl -X PUT "http://localhost:8080/api/branch/456/name" \
-H "Content-Type: application/json" \
-d '{
  "name": "Sucursal Centro Renovada"
}'
```

## Estructuras de Datos

### CreateFranchiseDto
```json
{
  "name": "string",
  "branches": [
    {
      "name": "string",
      "products": [
        {
          "name": "string",
          "stock": 0
        }
      ]
    }
  ]
}
```

### CreateBranchDto
```json
{
  "name": "string",
  "products": [
    {
      "name": "string",
      "stock": 0
    }
  ]
}
```

### CreateProductDto
```json
{
  "name": "string",
  "stock": 0
}
```

### ChangeFranchiseNameDto
```json
{
  "name": "string"
}
```

### ChangeBranchDto
```json
{
  "name": "string"
}
```

### UpdateProductDto
```json
{
  "idBranch": "string",
  "name": "string",
  "stock": 0
}
```

### BranchTopProductDto (Respuesta)
```json
{
  "branchName": "string",
  "productName": "string",
  "stock": 0
}
```

## Notas
- Reemplaza `123`, `456`, `789` con IDs reales de franquicias, sucursales y productos
- Todos los endpoints requieren `Content-Type: application/json`
- Los nombres no pueden estar vacíos
- El stock no puede ser negativo