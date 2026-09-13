import math


class Vector:
    def __init__(self, a1, a2, a3):
        self.__a1 = a1
        self.__a2 = a2
        self.__a3 = a3

    def __add__(self, otro):
        a1 = self.__a1 + otro.__a1
        a2 = self.__a2 + otro.__a2
        a3 = self.__a3 + otro.__a3

        return Vector(a1, a2, a3)

    def __sub__(self, otro):
        a1 = self.__a1 - otro.__a1
        a2 = self.__a2 - otro.__a2
        a3 = self.__a3 - otro.__a3

        return Vector(a1, a2, a3)

    def __mul__(self, r):
        a1 = r * self.__a1
        a2 = r * self.__a2
        a3 = r * self.__a3

        return Vector(a1, a2, a3)

    def __rmul__(self, r):
        return self * r
# esto es para hacer la division en self / longitud y sacar la normal
    def __truediv__(self, r):
        if r == 0:
            raise ZeroDivisionError("No se puede dividir entre cero.")

        return Vector(
            self.__a1 / r,
            self.__a2 / r,
            self.__a3 / r
        )

    def longitud(self):
        return math.sqrt(
            self.__a1 ** 2 +
            self.__a2 ** 2 +
            self.__a3 ** 2
        )

    def normal(self):
        longitud = self.longitud()

        if longitud == 0:
            raise ValueError("El vector cero no tiene normal.")

        return self / longitud

    def producto_escalar(self, otro):
        return (
            self.__a1 * otro.__a1 +
            self.__a2 * otro.__a2 +
            self.__a3 * otro.__a3
        )

    def producto_vectorial(self, otro):
        a1 = self.__a2 * otro.__a3 - self.__a3 * otro.__a2
        a2 = self.__a3 * otro.__a1 - self.__a1 * otro.__a3
        a3 = self.__a1 * otro.__a2 - self.__a2 * otro.__a1

        return Vector(a1, a2, a3)

    def __str__(self):
        return "({}, {}, {})".format(
            self.__a1,
            self.__a2,
            self.__a3
        )