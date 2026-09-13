from vector import Vector


a = Vector(1, 2, 3)
b = Vector(4, 5, 6)

print("Vector a =", a)
print("Vector b =", b)

print("Suma de a y b =", a + b)

print("Resta de a y b =", a - b)

print("Multiplicacion de 3 por a =", 3 * a)


print("Longitud de a =", a.longitud())

print("Normal de a =", a.normal())

print("Producto escalar de a y b =", a.producto_escalar(b))

print("Producto vectorial de a y b =", a.producto_vectorial(b))